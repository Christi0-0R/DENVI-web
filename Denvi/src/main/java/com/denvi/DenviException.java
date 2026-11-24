package com.denvi;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

public class DenviException extends RuntimeException {

    private static final int MAX_FRAMES = 12;

    private final String categoria;
    private final String detalle;
    private final int linea;
    private final int columna;
    private final String archivo;

    // codigo fuente y ayuda
    private String lineaTexto;      // texto de la linea con el error (puede ser null)
    private int ancho = 1;          // cuantos caracteres se subrayan
    private String ayuda;           // sugerencia para corregirlo

    // traza estilo Java
    private final List<String> pila = new ArrayList<>();
    private int framesTotales = 0;
    private int lineaSiguiente;
    private String archivoSiguiente;

    protected DenviException(String categoria, String detalle, int linea, int columna, String archivo) {
        super(categoria + ": " + detalle + ". (Line:" + linea + ", Col " + columna + ")", null, false, false);
        this.categoria = categoria;
        this.detalle = detalle;
        this.linea = linea;
        this.columna = columna;
        this.archivo = archivo;
        this.lineaSiguiente = linea;
        this.archivoSiguiente = archivo;
    }

    protected DenviException(String categoria, String detalle, int linea, int columna) {
        this(categoria, detalle, linea, columna, "<entrada>");
    }

    protected DenviException(String categoria, String detalle, ParserRuleContext ctx) {
        this(categoria, detalle, lineaDeCtx(ctx), columnaDeCtx(ctx), archivoDe(ctx));
        try {
            this.lineaTexto = lineaDe(ctx.getStart().getInputStream(), linea);
            if (ctx.getStop() != null && ctx.getStop().getLine() == linea
                    && ctx.getStop().getStopIndex() >= ctx.getStart().getStartIndex()) {
                this.ancho = ctx.getStop().getStopIndex() - ctx.getStart().getStartIndex() + 1;
            }
        } catch (RuntimeException e) {
            this.lineaTexto = null;
        }
    }

    private static int lineaDeCtx(ParserRuleContext ctx) {
        return (ctx == null || ctx.getStart() == null) ? 0 : ctx.getStart().getLine();
    }

    private static int columnaDeCtx(ParserRuleContext ctx) {
        return (ctx == null || ctx.getStart() == null) ? 0 : ctx.getStart().getCharPositionInLine();
    }

    public int getLinea()   { return linea; }
    public int getColumna() { return columna; }
    public String getCategoria() { return categoria; }
    public String getDetalle()   { return detalle; }
    public String getAyuda()     { return ayuda; }
    public String getArchivo()   { return archivo; }

    /** Sugerencia para corregir el error. */
    protected void ayuda(String texto) {
        this.ayuda = texto;
    }

    /** Agrega la linea de codigo (usado por los errores lexicos y sintacticos). */
    public DenviException conCodigo(CharStream cs) {
        try {
            this.lineaTexto = lineaDe(cs, linea);
        } catch (RuntimeException e) {
            this.lineaTexto = null;
        }
        return this;
    }

    // ---------------- Codigo fuente ----------------

    static String lineaDe(CharStream cs, int numero) {
        if (cs == null || cs.size() == 0) {
            return null;
        }
        String todo = cs.getText(Interval.of(0, cs.size() - 1));
        String[] lineas = todo.split("\n", -1);
        if (numero < 1 || numero > lineas.length) {
            return null;
        }
        return lineas[numero - 1].replace("\r", "");
    }

    private String bloqueCodigo() {
        if (lineaTexto == null) {
            return "";
        }
        String num = String.valueOf(linea);
        String margen = " ".repeat(num.length());
        StringBuilder relleno = new StringBuilder();
        for (int i = 0; i < columna && i < lineaTexto.length(); i++) {
            relleno.append(lineaTexto.charAt(i) == '\t' ? '\t' : ' ');
        }
        int resto = Math.max(1, Math.min(ancho, Math.max(1, lineaTexto.length() - columna)));
        return "\n    " + num + " | " + lineaTexto
                + "\n    " + margen + " | " + relleno + "^".repeat(resto);
    }

    // ---------------- Traza estilo Java ----------------

    static String archivoDe(ParserRuleContext ctx) {
        try {
            return nombreArchivo(ctx.getStart().getInputStream().getSourceName());
        } catch (RuntimeException e) {
            return "<entrada>";
        }
    }

    static String nombreArchivo(String source) {
        try {
            if (source == null || source.startsWith("<")) {
                return "<entrada>";
            }
            return Paths.get(source).getFileName().toString();
        } catch (RuntimeException e) {
            return "<entrada>";
        }
    }

    /** Se llama cuando la excepcion sale de una funcion/metodo: agrega "at Nombre(archivo:linea)". */
    public void agregarFrame(String nombre, ParserRuleContext llamada) {
        String pos = archivoSiguiente + ":" + lineaSiguiente + (framesTotales == 0 ? ":" + columna : "");
        if (pila.size() < MAX_FRAMES) {
            pila.add("at " + nombre + "(" + pos + ")");
        }
        framesTotales++;
        if (llamada != null && llamada.getStart() != null) {
            lineaSiguiente = llamada.getStart().getLine();
            archivoSiguiente = archivoDe(llamada);
        }
    }

    protected String nombreJava() {
        return "denvi.lang." + getClass().getSimpleName() + "Exception";
    }

    @Override
    public String toString() {
        return nombreJava() + ": " + detalle;
    }

    public String traza() {
        StringBuilder sb = new StringBuilder(toString());
        sb.append("\n");
        sb.append("\n  Error  : ").append(categoria);
        sb.append("\n  Archivo: ").append(archivo);
        sb.append("\n  Lugar  : linea ").append(linea).append(", columna ").append(columna);
        sb.append("\n").append(bloqueCodigo());
        sb.append("\n  Causa  : ").append(detalle);
        if (ayuda != null) {
            sb.append("\n  Ayuda  : ").append(ayuda);
        }
        sb.append("\n");
        if (pila.isEmpty()) {
            sb.append("\n\tat ").append(archivoSiguiente).append(':').append(linea).append(':').append(columna);
        }
        for (String f : pila) {
            sb.append("\n\t").append(f);
        }
        if (framesTotales > pila.size()) {
            sb.append("\n\t... ").append(framesTotales - pila.size()).append(" more");
        }
        return sb.toString();
    }

    /** Lo que imprime un Main que solo hace println(e.getMessage()). */
    @Override
    public String getMessage() {
        return "Exception in thread \"main\" " + traza();
    }

    @Override public void printStackTrace(PrintStream s) { s.println(traza()); }
    @Override public void printStackTrace(PrintWriter s) { s.println(traza()); }

    // ---------------- Traduccion de mensajes de ANTLR ----------------

    private static final Map<String, String> SIMBOLOS = new HashMap<>();
    static {
        String[][] t = {
            {"CIER", "';'"}, {"PAR_A", "'('"}, {"PAR_C", "')'"}, {"COR_A", "'['"}, {"COR_C", "']'"},
            {"LLA_A", "'{'"}, {"LLA_C", "'}'"}, {"COMA", "','"}, {"PUNTO", "'.'"}, {"DOB_P", "':'"},
            {"ASIG", "':='"}, {"CONEE", "'-->'"}, {"CONEG", "'->'"}, {"OP_COND", "'?'"},
            {"OR", "'||'"}, {"AND", "'^'"}, {"NOT", "'!'"}, {"COMP", "'=='"}, {"DIF", "'!='"},
            {"MA_Q", "'>'"}, {"MEN_Q", "'<'"}, {"MA_IG", "'=>'"}, {"MEN_IG", "'=<'"},
            {"OP_SUM", "'+'"}, {"OP_REST", "'-'"}, {"OP_MULT", "'*'"}, {"OP_DIV", "'/'"}, {"OP_MOD", "'%'"},
            {"INCS", "'++'"}, {"DECS", "'--'"}, {"INCV", "'+?'"}, {"DECV", "'-?'"},
            {"IDE", "variable (&nombre)"}, {"IDECON", "constante (#nombre)"},
            {"IDEEST", "nombre con mayuscula inicial"}, {"IDEOBJ", "nombre de objeto en minusculas"},
            {"VAL_ENT", "entero"}, {"VAL_DEC", "decimal"}, {"VAL_CAD", "cadena"}, {"VAL_CAR", "caracter"},
            {"VAL_BOO", "verdadero/falso"}, {"VAL_TM", "tiempo"}, {"VAL_NL", "nulo"},
            {"IGNOR", "'IGNOR'"}, {"ESQUELETO", "'Esqueleto'"}, {"PRINCIPAL", "'Principal'"},
            {"METAACCION", "'MetaAccion'"}, {"ACCION", "'Accion'"}, {"OBTIENEDE", "'ObtieneDe'"},
            {"INICIAR", "'iniciar'"}, {"ESTO", "'@esto'"}, {"RETORNAR", "'retornar'"},
            {"SUCESO", "'Suceso'"}, {"NIVEL", "'Nivel'"}, {"ZONA", "'Zona'"}, {"PORTAL", "'Portal'"},
            {"SITUAR", "'Situar'"}, {"RETIRAR", "'Retirar'"}, {"VIAJAR", "'Viajar'"},
            {"IMPORTAR", "'Import'"}, {"IMPORTINT", "archivo .clase.dnv"},
            {"IMPCONS", "'ImpCons'"}, {"IMPCONSSL", "'ImpConsSl'"}, {"OBTDATOS", "'ObtDatos'"},
            {"MUNDO", "'Mundo'"}, {"EVALUAR", "'ev'"}, {"ALTERNO", "'evalt'"}, {"ALTERNATIVA", "'alt'"},
            {"REPETICION", "'rep'"}, {"ENT", "'ent'"}, {"DEC", "'dec'"}, {"CAD", "'cad'"},
            {"CAR", "'car'"}, {"BOO", "'boo'"}, {"TM", "'tm'"}, {"NL", "'nl'"}, {"AR", "'ar'"}, {"LT", "'lt'"}
        };
        for (String[] par : t) {
            SIMBOLOS.put(par[0], par[1]);
        }
    }

    private static final Pattern TOKEN = Pattern.compile("\\b[A-Z][A-Z_0-9]*\\b");
    private static final Pattern P_MISMATCHED = Pattern.compile("^mismatched input (.+)$", Pattern.DOTALL);
    private static final Pattern P_EXTRANEOUS = Pattern.compile("^extraneous input (.+)$", Pattern.DOTALL);
    private static final Pattern P_MISSING = Pattern.compile("^missing (.+) at (.+)$", Pattern.DOTALL);
    private static final Pattern P_NOVIABLE = Pattern.compile("^no viable alternative at input (.+)$", Pattern.DOTALL);
    private static final Pattern P_TOKEN_ERR = Pattern.compile("^token recognition error at: (.+)$", Pattern.DOTALL);

    private static String traducirTokens(String s) {
        String base = s.replace("<EOF>", "fin del archivo");
        Matcher m = TOKEN.matcher(base);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String r = SIMBOLOS.get(m.group());
            m.appendReplacement(sb, Matcher.quoteReplacement(r != null ? r : m.group()));
        }
        m.appendTail(sb);
        return sb.toString();
    }

    /** Pasa los mensajes de ANTLR (ingles) a mensajes de DENVI. */
    static String traducir(String msg) {
        if (msg == null) {
            return "error de lectura";
        }
        String m = msg;
        String esperado = null;
        int i = m.indexOf(" expecting ");
        if (i >= 0) {
            esperado = traducirTokens(m.substring(i + " expecting ".length()));
            m = m.substring(0, i);
        }
        String sufijo = (esperado == null) ? "" : ", se esperaba " + esperado;
        Matcher x;
        if ((x = P_MISMATCHED.matcher(m)).matches()) {
            return "se encontro " + x.group(1).replace("'<EOF>'", "el fin del archivo") + sufijo;
        }
        if ((x = P_EXTRANEOUS.matcher(m)).matches()) {
            return "sobra " + x.group(1).replace("'<EOF>'", "el fin del archivo") + sufijo;
        }
        if ((x = P_MISSING.matcher(m)).matches()) {
            return "falta " + traducirTokens(x.group(1)) + " antes de "
                    + x.group(2).replace("'<EOF>'", "el fin del archivo");
        }
        if ((x = P_NOVIABLE.matcher(m)).matches()) {
            return "no se reconoce la instruccion cerca de " + x.group(1).replace("'<EOF>'", "el fin del archivo");
        }
        if ((x = P_TOKEN_ERR.matcher(m)).matches()) {
            return "caracter o texto no reconocido: " + x.group(1);
        }
        return msg;
    }

    // ---------------- Fase lexica y sintactica ----------------

    public static class ErrorLexico extends DenviException {
        private static final String AYUDA =
                "Hay un caracter o texto que no pertenece al lenguaje (simbolo invalido, cadena o caracter sin cerrar).";

        public ErrorLexico(int linea, int columna, String detalle) {
            super("Error lexico", traducir(detalle), linea, columna);
            ayuda(AYUDA);
        }
        public ErrorLexico(int linea, int columna, String detalle, String archivo) {
            super("Error lexico", traducir(detalle), linea, columna, archivo);
            ayuda(AYUDA);
        }
    }

    public static class ErrorSintactico extends DenviException {
        private static final String AYUDA =
                "Revisa que no falte un ';', un parentesis o una llave cerca de esta posicion (o en la linea anterior).";

        public ErrorSintactico(int linea, int columna, String detalle) {
            super("Error sintactico", traducir(detalle), linea, columna);
            ayuda(AYUDA);
        }
        public ErrorSintactico(int linea, int columna, String detalle, String archivo) {
            super("Error sintactico", traducir(detalle), linea, columna, archivo);
            ayuda(AYUDA);
        }
    }

    // ---------------- Fase semantica ----------------

    /** Padre de todos los errores semanticos. */
    public static class Semantico extends DenviException {
        protected Semantico(String categoria, String detalle, ParserRuleContext ctx) {
            super(categoria, detalle, ctx);
        }
    }

    public static class VariableNoDeclarada extends Semantico {
        public VariableNoDeclarada(ParserRuleContext ctx, String nombre) {
            super("Variable no declarada", nombre + " no ha sido declarada", ctx);
            ayuda("Declara la variable antes de usarla (ej. &x(ent);) y revisa que el nombre este bien escrito.");
        }
    }

    public static class VariableNoInicializada extends Semantico {
        public VariableNoInicializada(ParserRuleContext ctx, String nombre) {
            super("Variable no inicializada", nombre + " no tiene valor asignado", ctx);
            ayuda("Asignale un valor antes de leerla, o declarala con valor (ej. &x(ent) := 0;).");
        }
    }

    public static class ConstanteInmodificable extends Semantico {
        public ConstanteInmodificable(ParserRuleContext ctx, String nombre) {
            super("Constante inmodificable", "la constante " + nombre + " no puede cambiar de valor", ctx);
            ayuda("Una constante recibe su valor al declararse. Si necesitas cambiarlo, usa una variable (&nombre).");
        }
    }

    public static class TipoIncompatible extends Semantico {
        /** Operacion binaria: ENTERO + BOOLEANO */
        public TipoIncompatible(ParserRuleContext ctx, String operador,
                                Simbolo.TipoDato izq, Simbolo.TipoDato der) {
            super("Tipos incompatibles", izq + " " + operador + " " + der, ctx);
            ayuda("Los dos lados deben ser del mismo tipo.");
        }

        /** Operador que exige un tipo concreto: ! requiere BOOLEANO */
        public TipoIncompatible(ParserRuleContext ctx, String operador,
                                String esperado, Simbolo.TipoDato recibido) {
            super("Tipos incompatibles",
                    "el operador " + operador + " requiere " + esperado + ", se recibio " + recibido, ctx);
            ayuda("Cambia el valor por uno de tipo " + esperado + " o corrige la expresion.");
        }
    }

    public static class ClaseIncompatible extends Semantico {
        public ClaseIncompatible(ParserRuleContext ctx, String quien, String esperada, String recibida) {
            super("Clase incompatible",
                    quien + " espera un objeto " + esperada + " y recibio un objeto " + recibida, ctx);
            ayuda("Pasa un objeto de la clase " + esperada + " o de una clase que herede de ella (ObtieneDe).");
        }
    }

    public static class DivisionEntreCero extends Semantico {
        public DivisionEntreCero(ParserRuleContext ctx, String operador) {
            super("Division entre cero", "el operador " + operador + " tiene divisor 0", ctx);
            ayuda("Comprueba que el divisor no sea 0 antes de dividir (por ejemplo con un ev).");
        }
    }

    public static class Desbordamiento extends Semantico {
        public Desbordamiento(ParserRuleContext ctx, String operacion) {
            super("Desbordamiento de entero", operacion + " excede el rango de ent", ctx);
            ayuda("ent solo llega de -2147483648 a 2147483647. Usa dec para valores mas grandes.");
        }
    }

    public static class LiteralFueraDeRango extends Semantico {
        public LiteralFueraDeRango(ParserRuleContext ctx, String literal) {
            super("Literal fuera de rango", literal + " no cabe en su tipo", ctx);
            ayuda("Usa un valor mas pequeno (ent llega hasta 2147483647) o cambia el tipo a dec.");
        }
    }

    public static class NoSoportado extends Semantico {
        public NoSoportado(ParserRuleContext ctx, String que) {
            super("No soportado", que + " aun no esta implementado", ctx);
        }
    }

    public static class DeclaracionDuplicada extends Semantico {
        public DeclaracionDuplicada(ParserRuleContext ctx, String que, String nombre) {
            super("Declaracion duplicada", que + " " + nombre + " ya fue declarado(a) en este ambito", ctx);
            ayuda("Cambia el nombre o elimina la declaracion repetida. Para cambiar el valor usa solo la asignacion (&x := valor;).");
        }
    }

    public static class SimboloNoEncontrado extends Semantico {
        public SimboloNoEncontrado(ParserRuleContext ctx, String que, String nombre) {
            super("Simbolo no encontrado", "no existe " + que + " " + nombre, ctx);
            ayuda("Declara la funcion con Accion o MetaAccion, o revisa el nombre (distingue mayusculas y minusculas).");
        }
    }

    public static class ClaseNoEncontrada extends Semantico {
        public ClaseNoEncontrada(ParserRuleContext ctx, String nombre) {
            super("Clase no encontrada", "la clase " + nombre + " no existe (olvidaste el Import?)", ctx);
            ayuda("Importa el archivo donde esta la clase al inicio del programa (ej. Import Archivo.clase.dnv;).");
        }
    }

    public static class MiembroNoEncontrado extends Semantico {
        public MiembroNoEncontrado(ParserRuleContext ctx, String clase, String que, String nombre) {
            super("Miembro no encontrado", "la clase " + clase + " no tiene el " + que + " " + nombre, ctx);
            ayuda("Revisa los atributos y metodos que define la clase " + clase + " (y sus clases padre).");
        }
    }

    public static class ArgumentosInvalidos extends Semantico {
        public ArgumentosInvalidos(ParserRuleContext ctx, String quien, int esperados, int recibidos) {
            super("Argumentos invalidos", quien + " espera " + esperados + " argumento(s) y recibio " + recibidos, ctx);
            ayuda("Pasa exactamente los argumentos que declara en sus parentesis, en el mismo orden y tipo.");
        }
    }

    /** Equivalente a NullPointerException. */
    public static class ObjetoNulo extends Semantico {
        public ObjetoNulo(ParserRuleContext ctx, String detalle) {
            super("Objeto nulo", detalle, ctx);
            ayuda("El objeto vale nulo. Crealo con iniciar(...) antes de usarlo.");
        }
    }

    public static class EstoInvalido extends Semantico {
        public EstoInvalido(ParserRuleContext ctx) {
            super("Uso invalido de @esto", "@esto solo se puede usar dentro de un metodo de una clase", ctx);
            ayuda("Mueve esta instruccion a una MetaAccion de una clase, o usa el objeto por su nombre.");
        }
    }

    public static class RetornoInvalido extends Semantico {
        public RetornoInvalido(ParserRuleContext ctx, String detalle) {
            super("Retorno invalido", detalle, ctx);
            ayuda("(...).retornar solo puede usarse dentro de una Accion o MetaAccion.");
        }
    }

    public static class SinValorDeRetorno extends Semantico {
        public SinValorDeRetorno(ParserRuleContext ctx, String nombre) {
            super("Sin valor de retorno", nombre + " no retorna ningun valor y se uso como si lo devolviera", ctx);
            ayuda("Agrega (valor).retornar; en la funcion o metodo, o llamala como instruccion sin usar su resultado.");
        }
    }

    /** Equivalente a StackOverflowError. */
    public static class DesbordamientoDePila extends Semantico {
        public DesbordamientoDePila(ParserRuleContext ctx, int max) {
            super("Desbordamiento de pila", "se excedio la profundidad maxima de llamadas (" + max + ")", ctx);
            ayuda("Probablemente hay una recursion sin condicion de salida. Agrega un ev que detenga las llamadas.");
        }
    }

    public static class ColeccionInvalida extends Semantico {
        public ColeccionInvalida(ParserRuleContext ctx, String detalle) {
            super("Coleccion invalida", detalle, ctx);
            ayuda("Una lista no puede contener otras colecciones; un arreglo si puede anidarse.");
        }
    }

    public static class EntradaInvalida extends Semantico {
        public EntradaInvalida(ParserRuleContext ctx, String detalle) {
            super("Entrada invalida", detalle, ctx);
            ayuda("Escribe un valor que corresponda al tipo pedido en ObtDatos (ej. ent: 25, boo: verdadero, tm: 1:30).");
        }
    }

    public static class ImportacionInvalida extends Semantico {
        public ImportacionInvalida(ParserRuleContext ctx, String detalle) {
            super("Importacion invalida", detalle, ctx);
            ayuda("Revisa la ruta del archivo y que sea un archivo de clases (.clase.dnv) sin Esqueleto Principal.");
        }
    }

    public static class HerenciaInvalida extends Semantico {
        public HerenciaInvalida(ParserRuleContext ctx, String detalle) {
            super("Herencia invalida", detalle, ctx);
            ayuda("Una clase no puede heredar de si misma, ni formar un ciclo con sus padres.");
        }
    }

    public static class NivelInvalido extends Semantico {
        public NivelInvalido(ParserRuleContext ctx, String detalle) {
            super("Nivel invalido", detalle, ctx);
            ayuda("Declara el nivel con Nivel antes de usarlo en Viajar, Situar o en un Portal.");
        }
    }

    public static class PortalInvalido extends Semantico {
        public PortalInvalido(ParserRuleContext ctx, String detalle) {
            super("Portal invalido", detalle, ctx);
            ayuda("Agrega un Portal en el nivel de origen hacia el destino (ej. .Portal --> Destino).");
        }
    }

    public static class SucesoInvalido extends Semantico {
        public SucesoInvalido(ParserRuleContext ctx, String tipo, Set<String> catalogo) {
            super("Suceso invalido",
                    "el tipo de suceso " + tipo + " no pertenece al catalogo (" + String.join(", ", catalogo) + ")", ctx);
            ayuda("Usa un tipo del catalogo, o escribe una condicion libre: Suceso((condicion) -> { ... });");
        }
    }
}