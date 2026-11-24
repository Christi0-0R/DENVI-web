package com.denvi;

public class Simbolo {

    public enum TipoDato{ // TT-TT
        ENTERO, DECIMAL, BOOLEANO, CADENA,
        CARACTER, TIEMPO, NULO,
        ARREGLO,
        LISTA,
        OBJETO,
        VACIO
    }
    public static TipoDato desdeToken(String token) {
        switch (token) {
            case "ent": return TipoDato.ENTERO;
            case "dec": return TipoDato.DECIMAL;
            case "cad": return TipoDato.CADENA;
            case "car": return TipoDato.CARACTER;
            case "boo": return TipoDato.BOOLEANO;
            case "tm":  return TipoDato.TIEMPO;
            case "nl":  return TipoDato.NULO;
            default:    return null;
        }
    }

    public TipoDato tipo;
    public Object valor;

    // EXTRAS DEL LENGUAJE
    public boolean esConstante = false;
    public boolean esGlobal = false;
    public TipoDato tipoElemento = null;
    public String nombreClase = null;

    // Constructor basico
    public Simbolo(TipoDato tipo, Object valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    // Constantes y globales
    public Simbolo(TipoDato tipo, Object valor, boolean esConstante, boolean esGlobal){
        this.tipo = tipo;
        this.valor = valor;
        this.esConstante = esConstante;
        this.esGlobal = esGlobal;
    }
}