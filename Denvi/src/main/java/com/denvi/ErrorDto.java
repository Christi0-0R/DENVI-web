package com.denvi;

public record ErrorDto(String categoria, String detalle, String ayuda,
                       int linea, int columna, String archivo, String traza) {

    public static ErrorDto de(DenviException e) {
        return new ErrorDto(e.getCategoria(), e.getDetalle(), e.getAyuda(),
                e.getLinea(), e.getColumna(), e.getArchivo(), e.traza());
    }

    public static ErrorDto simple(String categoria, String detalle) {
        return new ErrorDto(categoria, detalle, null, 0, 0, null, null);
    }
}