package com.denvi;

import java.io.InputStream;
import java.io.InterruptedIOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EntradaInteractiva extends InputStream {

    private final BlockingQueue<byte[]> cola = new LinkedBlockingQueue<>();
    private final Runnable alEsperar;
    private byte[] actual = new byte[0];
    private int pos = 0;

    public EntradaInteractiva(Runnable alEsperar) {
        this.alEsperar = alEsperar;
    }

    /** Llega una línea escrita por el usuario. */
    public void enviarLinea(String texto) {
        cola.add((texto + "\n").getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public int read() throws InterruptedIOException {
        byte[] uno = new byte[1];
        int n = read(uno, 0, 1);
        return n < 0 ? -1 : (uno[0] & 0xFF);
    }

    @Override
    public int read(byte[] b, int off, int len) throws InterruptedIOException {
        if (len == 0) {
            return 0;
        }
        if (pos >= actual.length) {
            if (cola.isEmpty()) {
                alEsperar.run();            // avisa: "estoy esperando entrada"
            }
            try {
                actual = cola.take();       // se bloquea hasta que el usuario escriba
                pos = 0;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException("ejecucion detenida");
            }
        }
        int n = Math.min(len, actual.length - pos);
        System.arraycopy(actual, pos, b, off, n);
        pos += n;
        return n;
    }
}