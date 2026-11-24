// RespuestaEjecucion.java
package com.denvi;

public record RespuestaEjecucion(boolean ok, String salida, ErrorDto error) {
    public static RespuestaEjecucion exito(String salida) {
        return new RespuestaEjecucion(true, salida, null);
    }

    public static RespuestaEjecucion fallo(String salida, ErrorDto error) {
        return new RespuestaEjecucion(false, salida, error);
    }
}