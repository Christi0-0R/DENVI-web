package com.denvi;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.springframework.stereotype.Service;

import com.denvi.denviParser.ArchivoContext;

@Service
public class EjecutorService {

    private static final int TIMEOUT_SEG = 5;
    private static final int MAX_SALIDA = 100_000;
    private static final String DIR_IMPORTS = "src/test/resources";

    // hilos con pila grande (16 MB) para soportar la recursion del interprete
    private final ExecutorService pool = Executors.newCachedThreadPool(r -> {
        Thread t = new Thread(null, r, "denvi-exec", 16L * 1024 * 1024);
        t.setDaemon(true);
        return t;
    });

    /** Revisa lexico y sintaxis. Lanza DenviException si hay error. */
    public ArchivoContext parsear(String codigo) {
        denviLexer lexer = new denviLexer(CharStreams.fromString(codigo));
        lexer.removeErrorListeners();
        lexer.addErrorListener(new DenviErrorListener());

        denviParser parser = new denviParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(new DenviErrorListener());
        return parser.archivo();
    }

    public RespuestaEjecucion analizar(String codigo) {
        try {
            parsear(codigo == null ? "" : codigo);
            return RespuestaEjecucion.exito("");
        } catch (DenviException e) {
            return RespuestaEjecucion.fallo("", ErrorDto.de(e));
        }
    }

    public RespuestaEjecucion ejecutar(String codigo, List<String> entradas) {
        final String fuente = (codigo == null) ? "" : codigo;
        final List<String> lineasEntrada = (entradas == null) ? List.of() : entradas;

        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(buf, true, StandardCharsets.UTF_8);

        Callable<Object> trabajo = () -> {
            ArchivoContext arbol = parsear(fuente);
            String stdin = String.join("\n", lineasEntrada);
            denviCustomVisitor visitor = new denviCustomVisitor(out, new Scanner(stdin));
            visitor.directorioBase = Paths.get(DIR_IMPORTS).toAbsolutePath().toString();
            visitor.visit(arbol);
            return null;
        };
        Future<Object> tarea = pool.submit(trabajo);

        try {
            tarea.get(TIMEOUT_SEG, TimeUnit.SECONDS);
            return RespuestaEjecucion.exito(salida(buf));
        } catch (TimeoutException e) {
            tarea.cancel(true);
            return RespuestaEjecucion.fallo(salida(buf), ErrorDto.simple("Tiempo agotado",
                    "El programa tardo mas de " + TIMEOUT_SEG + " segundos (posible ciclo infinito)"));
        } catch (ExecutionException e) {
            Throwable causa = e.getCause();
            if (causa instanceof DenviException d) {
                return RespuestaEjecucion.fallo(salida(buf), ErrorDto.de(d));
            }
            if (causa instanceof CancellationException) {
                return RespuestaEjecucion.fallo(salida(buf),
                        ErrorDto.simple("Tiempo agotado", "La ejecucion fue cancelada"));
            }
            return RespuestaEjecucion.fallo(salida(buf),
                    ErrorDto.simple("Error interno", String.valueOf(causa)));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return RespuestaEjecucion.fallo(salida(buf),
                    ErrorDto.simple("Interrumpido", "La peticion fue interrumpida"));
        } catch (CancellationException e) {
            return RespuestaEjecucion.fallo(salida(buf),
                    ErrorDto.simple("Tiempo agotado", "La ejecucion fue cancelada"));
        }
    }

    private String salida(ByteArrayOutputStream buf) {
        String s = buf.toString(StandardCharsets.UTF_8);
        return s.length() > MAX_SALIDA ? s.substring(0, MAX_SALIDA) + "\n... (salida recortada)" : s;
    }
}