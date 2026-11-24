package com.denvi;

import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.denvi.denviParser.ArchivoContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class EjecucionHandler extends TextWebSocketHandler {

    private static final int MAX_SALIDA = 100_000;
    private static final int LIMITE_SEG = 120;           // tiempo total máximo (incluye esperar al usuario)
    private static final String DIR_IMPORTS = "src/test/resources";

    private final EjecutorService servicio;
    private final ObjectMapper json = new ObjectMapper();
    private final Map<String, Sesion> sesiones = new ConcurrentHashMap<>();

    // hilos con pila grande (16 MB) para la recursion del interprete
    private final ExecutorService pool = Executors.newCachedThreadPool(r -> {
        Thread t = new Thread(null, r, "denvi-exec", 16L * 1024 * 1024);
        t.setDaemon(true);
        return t;
    });
    private final ScheduledExecutorService reloj = Executors.newSingleThreadScheduledExecutor(r -> {
        Thread t = new Thread(r, "denvi-reloj");
        t.setDaemon(true);
        return t;
    });

    private static class Sesion {
        final EntradaInteractiva entrada;
        final AtomicBoolean detenida = new AtomicBoolean(false);
        volatile String motivo;                // por que se cancelo (tiempo, salida enorme)
        volatile Future<?> tarea;
        volatile ScheduledFuture<?> limite;

        Sesion(EntradaInteractiva entrada) {
            this.entrada = entrada;
        }
    }

    public EjecucionHandler(EjecutorService servicio) {
        this.servicio = servicio;
    }

    @Override
    protected void handleTextMessage(WebSocketSession ws, TextMessage message) throws Exception {
        JsonNode msg = json.readTree(message.getPayload());
        switch (msg.path("tipo").asText()) {
            case "ejecutar" -> iniciar(ws, msg.path("codigo").asText(""));
            case "entrada" -> {
                Sesion s = sesiones.get(ws.getId());
                if (s != null) {
                    s.entrada.enviarLinea(msg.path("texto").asText(""));
                }
            }
            case "detener" -> detener(ws.getId());
            default -> { }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession ws, CloseStatus status) {
        detener(ws.getId());
    }

    private void iniciar(WebSocketSession ws, String codigo) {
        detener(ws.getId());
        Sesion[] ref = new Sesion[1];
        EntradaInteractiva entrada = new EntradaInteractiva(() -> enviar(ws, ref[0], Map.of("tipo", "entrada")));
        Sesion s = new Sesion(entrada);
        ref[0] = s;
        sesiones.put(ws.getId(), s);

        s.tarea = pool.submit(() -> correr(ws, s, codigo));
        s.limite = reloj.schedule(() -> {
            s.motivo = "El programa supero los " + LIMITE_SEG + " segundos (posible ciclo infinito)";
            Future<?> t = s.tarea;
            if (t != null) {
                t.cancel(true);
            }
        }, LIMITE_SEG, TimeUnit.SECONDS);
    }

    private void detener(String id) {
        Sesion s = sesiones.remove(id);
        if (s == null) {
            return;
        }
        s.detenida.set(true);
        if (s.limite != null) {
            s.limite.cancel(false);
        }
        if (s.tarea != null) {
            s.tarea.cancel(true);
        }
    }

    private void correr(WebSocketSession ws, Sesion s, String codigo) {
        AtomicInteger total = new AtomicInteger();
        OutputStream flujo = new OutputStream() {
            @Override
            public void write(int b) {
                write(new byte[] { (byte) b }, 0, 1);
            }

            @Override
            public void write(byte[] b, int off, int len) {
                if (len <= 0) {
                    return;
                }
                if (total.addAndGet(len) > MAX_SALIDA) {
                    if (s.motivo == null) {
                        s.motivo = "La salida supero los " + MAX_SALIDA + " caracteres";
                    }
                    Thread.currentThread().interrupt();   // el interprete se detiene en la siguiente linea
                    return;
                }
                enviar(ws, s, Map.of("tipo", "salida", "texto", new String(b, off, len, StandardCharsets.UTF_8)));
            }
        };
        PrintStream out = new PrintStream(flujo, true, StandardCharsets.UTF_8);

        try {
            ArchivoContext arbol = servicio.parsear(codigo);
            denviCustomVisitor visitor = new denviCustomVisitor(out, new Scanner(s.entrada, StandardCharsets.UTF_8), true);
            visitor.directorioBase = Paths.get(DIR_IMPORTS).toAbsolutePath().toString();
            visitor.visit(arbol);
            enviar(ws, s, Map.of("tipo", "fin"));
        } catch (Throwable e) {
            if (s.motivo != null) {
                enviar(ws, s, Map.of("tipo", "error", "error", ErrorDto.simple("Tiempo agotado", s.motivo)));
            } else if (e instanceof DenviException d) {
                enviar(ws, s, Map.of("tipo", "error", "error", ErrorDto.de(d)));
            } else if (e instanceof CancellationException) {
                enviar(ws, s, Map.of("tipo", "error", "error", ErrorDto.simple("Cancelado", "La ejecucion fue cancelada")));
            } else {
                enviar(ws, s, Map.of("tipo", "error", "error", ErrorDto.simple("Error interno", String.valueOf(e))));
            }
            enviar(ws, s, Map.of("tipo", "fin"));
        } finally {
            if (s.limite != null) {
                s.limite.cancel(false);
            }
            sesiones.remove(ws.getId(), s);
        }
    }

    /** Un solo hilo a la vez puede escribir en el WebSocket; si la sesion se detuvo, no se manda nada. */
    private void enviar(WebSocketSession ws, Sesion s, Object payload) {
        if (s != null && s.detenida.get()) {
            return;
        }
        try {
            String texto = json.writeValueAsString(payload);
            synchronized (ws) {
                if (ws.isOpen()) {
                    ws.sendMessage(new TextMessage(texto));
                }
            }
        } catch (Exception ignorada) {
            // conexion cerrada
        }
    }
}