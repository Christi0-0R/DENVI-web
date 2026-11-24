package com.denvi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.StringJoiner;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.denvi.denviParser.AccmetContext;
import com.denvi.denviParser.AccmiemContext;
import com.denvi.denviParser.ArchclaseContext;
import com.denvi.denviParser.ArchivoContext;
import com.denvi.denviParser.ArchprinContext;
import com.denvi.denviParser.ArregloContext;
import com.denvi.denviParser.AsigMiembroContext;
import com.denvi.denviParser.AsigVarContext;
import com.denvi.denviParser.Asig_globContext;
import com.denvi.denviParser.AsignacionContext;
import com.denvi.denviParser.AutoIncPasoContext;
import com.denvi.denviParser.AutoIncSimpleContext;
import com.denvi.denviParser.AutoincContext;
import com.denvi.denviParser.BaseContext;
import com.denvi.denviParser.ClasprinContext;
import com.denvi.denviParser.ConexionContext;
import com.denvi.denviParser.ConstanteContext;
import com.denvi.denviParser.Cont_arrContext;
import com.denvi.denviParser.ContevaltContext;
import com.denvi.denviParser.ContrepContext;
import com.denvi.denviParser.CuerpofuncionContext;
import com.denvi.denviParser.CuerpometodoContext;
import com.denvi.denviParser.CuerponivelContext;
import com.denvi.denviParser.DatoContext;
import com.denvi.denviParser.DecarContext;
import com.denvi.denviParser.Decla_globContext;
import com.denvi.denviParser.DeclaobjContext;
import com.denvi.denviParser.DeclaracionAsigContext;
import com.denvi.denviParser.DeclaracionSimpleContext;
import com.denvi.denviParser.DecltContext;
import com.denvi.denviParser.DecparamContext;
import com.denvi.denviParser.EnlaceContext;
import com.denvi.denviParser.EscclaseContext;
import com.denvi.denviParser.EscfuncionContext;
import com.denvi.denviParser.EscmetodoContext;
import com.denvi.denviParser.EscnivelContext;
import com.denvi.denviParser.EscondContext;
import com.denvi.denviParser.EscretorContext;
import com.denvi.denviParser.EscsucesoContext;
import com.denvi.denviParser.ExpresionContext;
import com.denvi.denviParser.ImpconsContext;
import com.denvi.denviParser.ImpconsslContext;
import com.denvi.denviParser.ImportarContext;
import com.denvi.denviParser.ImportextContext;
import com.denvi.denviParser.ImportintContext;
import com.denvi.denviParser.ImprimibleContext;
import com.denvi.denviParser.IncreContext;
import com.denvi.denviParser.IncreespContext;
import com.denvi.denviParser.LincodContext;
import com.denvi.denviParser.ListaContext;
import com.denvi.denviParser.LlamadaContext;
import com.denvi.denviParser.LlamfunContext;
import com.denvi.denviParser.LogandContext;
import com.denvi.denviParser.LogarContext;
import com.denvi.denviParser.LogigContext;
import com.denvi.denviParser.LogorContext;
import com.denvi.denviParser.LogrelContext;
import com.denvi.denviParser.MiembroContext;
import com.denvi.denviParser.ObtdatosContext;
import com.denvi.denviParser.ParametroContext;
import com.denvi.denviParser.PasoContext;
import com.denvi.denviParser.ProgContext;
import com.denvi.denviParser.PropiedadContext;
import com.denvi.denviParser.PropiedadesContext;
import com.denvi.denviParser.RecparamContext;
import com.denvi.denviParser.RepAsignacionContext;
import com.denvi.denviParser.RepDeclaracionContext;
import com.denvi.denviParser.RetirarContext;
import com.denvi.denviParser.SimbunContext;
import com.denvi.denviParser.SituarContext;
import com.denvi.denviParser.SubzonaContext;
import com.denvi.denviParser.TerminoContext;
import com.denvi.denviParser.TipoContext;
import com.denvi.denviParser.ValorContext;
import com.denvi.denviParser.ValpContext;
import com.denvi.denviParser.ValsimpleContext;
import com.denvi.denviParser.ViajarContext;

public class denviCustomVisitor extends denviBaseVisitor<Simbolo> {

    // ==================================================================
    // Clases de apoyo
    // ==================================================================

    /** Un "piso" de variables. Busca primero aqui y si no, en el padre. */
    static class Ambito {
        final HashMap<String, Simbolo> vars;
        final Ambito padre;

        Ambito(Ambito padre) {
            this(padre, new HashMap<>());
        }

        Ambito(Ambito padre, HashMap<String, Simbolo> vars) {
            this.padre = padre;
            this.vars = vars;
        }

        /** Regresa el ambito donde vive la variable, o null si no existe. */
        Ambito duenio(String nombre) {
            for (Ambito a = this; a != null; a = a.padre) {
                if (a.vars.containsKey(nombre)) {
                    return a;
                }
            }
            return null;
        }
    }

    /** Valor de un arreglo o lista. */
    static class Coleccion {
        Simbolo.TipoDato tipoElem;   // null = literal que todavia no se valida
        List<Simbolo> elementos;     // null = declarado sin valor
        final boolean esLista;

        Coleccion(Simbolo.TipoDato tipoElem, List<Simbolo> elementos, boolean esLista) {
            this.tipoElem = tipoElem;
            this.elementos = elementos;
            this.esLista = esLista;
        }

        @Override
        public String toString() {
            if (elementos == null) {
                return "(sin valor)";
            }
            StringJoiner sj = new StringJoiner(", ", esLista ? "{" : "[", esLista ? "}" : "]");
            for (Simbolo e : elementos) {
                sj.add(texto(e));
            }
            return sj.toString();
        }
    }

    /** Un objeto creado con iniciar(...). */
    static class Objeto {
        final String clase;
        final LinkedHashMap<String, Simbolo> atributos = new LinkedHashMap<>();
        String nivel;      // nivel donde esta situado (null = no esta en el mundo)
        String zona;       // zona dentro del nivel (null = ninguna)
        double x, y;

        Objeto(String clase) {
            this.clase = clase;
        }

        @Override
        public String toString() {
            StringJoiner sj = new StringJoiner(", ", clase + "(", ")");
            for (Map.Entry<String, Simbolo> e : atributos.entrySet()) {
                sj.add(e.getKey() + "=" + texto(e.getValue()));
            }
            return sj.toString();
        }
    }

    /** Un Suceso registrado. */
    static class Suceso {
        final EscsucesoContext ctx;
        final Ambito ambito;
        final Objeto objeto;       // objeto en cuyo metodo se registro (para @esto)
        final String tipoCorto;    // Choque, Toma, Ingreso, Egreso; null = forma general
        boolean activo = false;    // ultimo valor de la condicion (Choque, Toma y forma general)
        String ubicacionPrevia;    // ultima ubicacion vista (Ingreso y Egreso)

        Suceso(EscsucesoContext ctx, Ambito ambito, Objeto objeto, String tipoCorto) {
            this.ctx = ctx;
            this.ambito = ambito;
            this.objeto = objeto;
            this.tipoCorto = tipoCorto;
        }
    }

    /** Destino de un Portal que se valida al terminar el programa. */
    static class PortalPendiente {
        final EnlaceContext ctx;
        final String origen;
        final String destino;

        PortalPendiente(EnlaceContext ctx, String origen, String destino) {
            this.ctx = ctx;
            this.origen = origen;
            this.destino = destino;
        }
    }

    /** Se lanza con (valor).retornar para salir de la funcion. */
    static class Retorno extends RuntimeException {
        final Simbolo valor;

        Retorno(Simbolo valor) {
            super(null, null, false, false);
            this.valor = valor;
        }
    }

    /** Errores semanticos genericos. */
    public static class ErrorDenvi extends DenviException.Semantico {
        public ErrorDenvi(ParserRuleContext ctx, String mensaje) {
            super("Error semantico", mensaje, ctx);
        }

        @Override
        protected String nombreJava() {
            return "denvi.lang.SemanticoException";
        }
    }

    // ==================================================================
    // Variables del interprete
    // ==================================================================

    public final HashMap<String, Simbolo> tablaSimbolos = new HashMap<>();   // variables del programa principal
    public final HashMap<String, EscfuncionContext> tablaFunciones = new HashMap<>();
    public final HashMap<String, EscmetodoContext> metodosPrincipal = new HashMap<>();
    public final HashMap<String, EscclaseContext> tablaClases = new HashMap<>();
    public final HashMap<String, EscnivelContext> tablaNiveles = new HashMap<>();
    public final HashMap<String, Set<String>> portales = new HashMap<>();
    public String directorioBase = ".";

    /** Tipos de suceso de la forma corta. Para agregar uno nuevo basta ampliar este catalogo. */
    private static final Set<String> CATALOGO_SUCESOS =
            new LinkedHashSet<>(Arrays.asList("Choque", "Toma", "Ingreso", "Egreso"));
    private static final String CLASE_RECOMPENSA = "Recompensa";

    private final Ambito ambitoGlobal = new Ambito(null);                 // Mundo
    private Ambito ambito = new Ambito(ambitoGlobal, tablaSimbolos);      // ambito actual

    private Objeto objetoActual = null;                                   // para @esto
    private HashMap<String, EscfuncionContext> funcionesLocales = new HashMap<>();
    private int profundidad = 0;
    private static final int MAX_PROFUNDIDAD = 300;

    private String nivelActual = null;
    private String zonaActual = null;
    private final Set<Objeto> enMundo = new LinkedHashSet<>();
    private final List<Suceso> sucesos = new ArrayList<>();
    private final List<PortalPendiente> portalesPendientes = new ArrayList<>();
    private boolean revisandoSucesos = false;
    private boolean revisionPendiente = false;
    private static final int MAX_PASADAS = 100;

    private final Set<String> importados = new HashSet<>();
    //private Scanner entrada;
    private final java.io.PrintStream out;
    private final Scanner entrada;
    private final boolean mostrarPrompt;

    public denviCustomVisitor() {
        this(System.out, new Scanner(System.in), true);
    }

    public denviCustomVisitor(java.io.PrintStream out, Scanner entrada) {
        this(out, entrada, false);
    }

    public denviCustomVisitor(java.io.PrintStream out, Scanner entrada, boolean mostrarPrompt) {
        this.out = out;
        this.entrada = entrada;
        this.mostrarPrompt = mostrarPrompt;
    }

    // ==================================================================
    // Archivos e importaciones
    // ==================================================================

    // archivo: archprin | archclase
    @Override
    public Simbolo visitArchivo(ArchivoContext ctx) {
        return visit(ctx.getChild(0));
    }

    // archprin: importar* clasprin EOF
    @Override
    public Simbolo visitArchprin(ArchprinContext ctx) {
        for (ImportarContext imp : ctx.importar()) {
            visit(imp);
        }
        return visit(ctx.clasprin());
    }

    // archclase: importar* escclase+ EOF
    @Override
    public Simbolo visitArchclase(ArchclaseContext ctx) {
        for (ImportarContext imp : ctx.importar()) {
            visit(imp);
        }
        for (EscclaseContext c : ctx.escclase()) {
            visit(c);
        }
        // validar herencia: padre existente, sin ciclos y sin atributos repetidos
        for (EscclaseContext c : ctx.escclase()) {
            validarParametros(c, atributosDe(c, c.IDEEST(0).getText()));
        }
        return null;
    }

    // importar: (importext | importint) CIER
    @Override
    public Simbolo visitImportar(ImportarContext ctx) {
        return visit(ctx.getChild(0));
    }

    // importext: Import "ruta/archivo.clase.dnv"
    @Override
    public Simbolo visitImportext(ImportextContext ctx) {
        String t = ctx.VAL_CAD().getText();
        cargarArchivo(ctx, desescapar(t.substring(1, t.length() - 1)));
        return null;
    }

    // importint: Import Archivo.clase.dnv
    @Override
    public Simbolo visitImportint(ImportintContext ctx) {
        cargarArchivo(ctx, ctx.IMPORTINT().getText());
        return null;
    }

    /** Lee otro archivo, lo parsea y registra sus clases. */
    private void cargarArchivo(ParserRuleContext ctx, String ruta) {
        Path archivo = Paths.get(directorioBase).resolve(ruta).toAbsolutePath().normalize();
        if (!importados.add(archivo.toString())) {
            return; // ya estaba importado
        }
        if (!Files.exists(archivo)) {
            throw new DenviException.ImportacionInvalida(ctx, "no se encontro el archivo " + archivo);
        }

        ArchivoContext arbol;
        try {
            denviLexer lexer = new denviLexer(CharStreams.fromPath(archivo));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new DenviErrorListener());
            denviParser parser = new denviParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(new DenviErrorListener());
            arbol = parser.archivo();
        } catch (IOException e) {
            throw new DenviException.ImportacionInvalida(ctx, "no se pudo leer " + archivo);
        }

        if (arbol.archclase() == null) {
            throw new DenviException.ImportacionInvalida(ctx,
                    "solo se pueden importar archivos de clases (sin Esqueleto Principal)");
        }

        String dirAnterior = directorioBase;
        directorioBase = archivo.getParent().toString();
        try {
            visit(arbol);
        } finally {
            directorioBase = dirAnterior;
        }
    }

    // ==================================================================
    // Programa, clases, metodos y funciones (registro)
    // ==================================================================

    // clasprin: Esqueleto Principal --> { escmetodo* prog } ;
    @Override
    public Simbolo visitClasprin(ClasprinContext ctx) {
        for (EscmetodoContext m : ctx.escmetodo()) {
            visit(m);
        }
        return visit(ctx.prog());
    }

    // Prog: IGNOR CIER | (lincod, escfuncion)
    @Override
    public Simbolo visitProg(ProgContext ctx) {
        if (ctx.IGNOR() != null) {
            return null;
        }
        try {
            // 1ra pasada: registrar todas las funciones primero
            for (EscfuncionContext fun : ctx.escfuncion()) {
                visit(fun);
            }
            Simbolo result = null;
            for (LincodContext instr : ctx.lincod()) {
                result = visit(instr);
            }
            validarPortales();
            return result;
        } catch (DenviException e) {
            e.agregarFrame("Principal.Main", null);
            throw e;
        }
    }

    // escfuncion: solo se registra, se ejecuta al llamarla
    @Override
    public Simbolo visitEscfuncion(EscfuncionContext ctx) {
        String nombre = ctx.IDEEST().getText();
        if (tablaFunciones.containsKey(nombre)) {
            throw new DenviException.DeclaracionDuplicada(ctx, "la funcion", nombre);
        }
        validarParametros(ctx, parametros(ctx.decparam()));
        tablaFunciones.put(nombre, ctx);
        return null;
    }

    // escclase: solo se registra, se usa con iniciar(...)
    @Override
    public Simbolo visitEscclase(EscclaseContext ctx) {
        String nombre = ctx.IDEEST(0).getText();
        if (tablaClases.containsKey(nombre)) {
            throw new DenviException.DeclaracionDuplicada(ctx, "la clase", nombre);
        }
        validarParametros(ctx, parametros(ctx.decparam()));
        Set<String> metodos = new HashSet<>();
        for (EscmetodoContext m : ctx.esccuerpo().escmetodo()) {
            String n = m.IDEEST().getText();
            if (!metodos.add(n)) {
                throw new DenviException.DeclaracionDuplicada(m, "el metodo", nombre + "." + n);
            }
            validarMetodo(m, nombre + "." + n);
        }
        tablaClases.put(nombre, ctx);
        return null;
    }

    // escmetodo: solo se registra (los de la clase Principal)
    @Override
    public Simbolo visitEscmetodo(EscmetodoContext ctx) {
        if (ctx.getParent() instanceof ClasprinContext) {
            String n = ctx.IDEEST().getText();
            if (metodosPrincipal.containsKey(n)) {
                throw new DenviException.DeclaracionDuplicada(ctx, "el metodo", "Principal." + n);
            }
            validarMetodo(ctx, "Principal." + n);
            metodosPrincipal.put(n, ctx);
        }
        return null;
    }

    // cuerpometodo: registra sus funciones locales y ejecuta sus lineas
    @Override
    public Simbolo visitCuerpometodo(CuerpometodoContext ctx) {
        for (EscfuncionContext f : ctx.escfuncion()) {
            funcionesLocales.put(f.IDEEST().getText(), f);
        }
        ejecutarBloque(ctx.lincod());
        return null;
    }

    // cuerpofuncion: ejecuta sus lineas
    @Override
    public Simbolo visitCuerpofuncion(CuerpofuncionContext ctx) {
        ejecutarBloque(ctx.lincod());
        return null;
    }

    // escretor: (valor).retornar
    @Override
    public Simbolo visitEscretor(EscretorContext ctx) {
        if (profundidad == 0) {
            throw new DenviException.RetornoInvalido(ctx,
                    "(...).retornar solo se puede usar dentro de una funcion o metodo");
        }
        Simbolo v = (ctx.dato() == null) ? new Simbolo(Simbolo.TipoDato.VACIO, null) : visit(ctx.dato());
        throw new Retorno(v);
    }

    // ==================================================================
    // Llamadas
    // ==================================================================

    // llamada: llamfun | accmet
    @Override
    public Simbolo visitLlamada(LlamadaContext ctx) {
        return visit(ctx.getChild(0));
    }

    // llamfun: Nombre(args)
    @Override
    public Simbolo visitLlamfun(LlamfunContext ctx) {
        String nombre = ctx.IDEEST().getText();
        List<Simbolo> args = evaluarArgs(ctx.recparam());

        // 1) funcion local del metodo, 2) funcion global
        EscfuncionContext f = funcionesLocales.get(nombre);
        boolean local = f != null;
        if (f == null) {
            f = tablaFunciones.get(nombre);
        }
        if (f != null) {
            return ejecutarFuncion(ctx, f, args, local);
        }
        // 3) metodo del objeto actual
        if (objetoActual != null) {
            EscmetodoContext m = buscarMetodo(ctx, objetoActual.clase, nombre);
            if (m != null) {
                return ejecutarMetodo(ctx, objetoActual, m, args);
            }
        }
        // 4) metodo de Principal
        EscmetodoContext mp = metodosPrincipal.get(nombre);
        if (mp != null) {
            return ejecutarMetodo(ctx, null, mp, args);
        }
        throw new DenviException.SimboloNoEncontrado(ctx, "la funcion o metodo", nombre);
    }

    // accmet: (obj | @esto | llamfun) (.miembro)* .Metodo(args)
    @Override
    public Simbolo visitAccmet(AccmetContext ctx) {
        Simbolo receptor;
        if (ctx.IDEOBJ() != null) {
            receptor = obtenerVariable(ctx, ctx.IDEOBJ().getText());
        } else if (ctx.ESTO() != null) {
            receptor = esto(ctx);
        } else {
            receptor = visit(ctx.llamfun());
        }
        for (MiembroContext m : ctx.miembro()) {
            receptor = aplicarMiembro(receptor, m);
        }
        return llamarMetodo(ctx, receptor, ctx.IDEEST().getText(), evaluarArgs(ctx.recparam()));
    }

    // recparam: dato (, dato)*
    private List<Simbolo> evaluarArgs(RecparamContext r) {
        List<Simbolo> args = new ArrayList<>();
        if (r != null) {
            for (DatoContext d : r.dato()) {
                args.add(visit(d));
            }
        }
        return args;
    }

    // decparam: parametro (, parametro)*
    private List<ParametroContext> parametros(DecparamContext d) {
        return (d == null) ? Collections.emptyList() : d.parametro();
    }

    /** Revisa cantidad y tipos de los argumentos y los guarda en "destino". */
    private void asignarParametros(ParserRuleContext ctx, String quien, List<ParametroContext> params,
                                   List<Simbolo> args, HashMap<String, Simbolo> destino) {
        if (params.size() != args.size()) {
            throw new DenviException.ArgumentosInvalidos(ctx, quien, params.size(), args.size());
        }
        for (int i = 0; i < params.size(); i++) {
            ParametroContext p = params.get(i);
            Simbolo arg = args.get(i);
            String op = quien + " (parametro " + (i + 1) + ")";

            if (p.IDEEST() != null) {
                // Clase obj
                String clase = p.IDEEST().getText();
                clase(ctx, clase);   // la clase del parametro debe existir
                if (arg.tipo != Simbolo.TipoDato.NULO) {
                    Objeto o = exigirObjeto(ctx, arg);
                    if (!esSubclase(ctx, o.clase, clase)) {
                        throw new DenviException.ClaseIncompatible(ctx, op, clase, o.clase);
                    }
                }
                Simbolo s = new Simbolo(arg.tipo, arg.valor);
                s.nombreClase = clase;
                destino.put(p.IDEOBJ().getText(), s);
            } else {
                Simbolo.TipoDato tipo = Simbolo.desdeToken(p.tipo().getText());
                Simbolo val;
                if (p.AR() != null) {
                    val = validarColeccion(ctx, arg, tipo, false);
                } else if (p.LT() != null) {
                    val = validarColeccion(ctx, arg, tipo, true);
                } else {
                    Simbolo ajustado = ajustarTipo(ctx, tipo, arg, op);
                    // copia: el parametro no hereda "constante" ni "global" del argumento
                    val = new Simbolo(ajustado.tipo, ajustado.valor);
                }
                destino.put(p.IDE().getText(), val);
            }
        }
    }

    private Simbolo ejecutarFuncion(ParserRuleContext ctx, EscfuncionContext f, List<Simbolo> args, boolean local) {
        String nombre = f.IDEEST().getText();
        Ambito nuevo = new Ambito(ambitoGlobal);
        asignarParametros(ctx, "la funcion " + nombre, parametros(f.decparam()), args, nuevo.vars);
        // una funcion local de un metodo sigue viendo @esto y a sus funciones hermanas
        return ejecutarCuerpo(ctx, nuevo, local ? objetoActual : null,
                local ? funcionesLocales : new HashMap<>(), f.cuerpofuncion(), nombre);
    }

    private Simbolo ejecutarMetodo(ParserRuleContext ctx, Objeto obj, EscmetodoContext m, List<Simbolo> args) {
        String nombre = (obj == null ? "Principal" : obj.clase) + "." + m.IDEEST().getText();
        // los atributos del objeto se ven como variables dentro del metodo
        Ambito base = (obj == null) ? ambitoGlobal : new Ambito(ambitoGlobal, obj.atributos);
        Ambito nuevo = new Ambito(base);
        asignarParametros(ctx, "el metodo " + nombre, parametros(m.decparam()), args, nuevo.vars);
        return ejecutarCuerpo(ctx, nuevo, obj, new HashMap<>(), m.cuerpometodo(), nombre);
    }

    /** Cambia de ambito, ejecuta el cuerpo, atrapa el retornar y regresa todo como estaba. */
    private Simbolo ejecutarCuerpo(ParserRuleContext ctx, Ambito nuevo, Objeto obj,
                                   HashMap<String, EscfuncionContext> locales,
                                   ParserRuleContext cuerpo, String nombre) {
        if (profundidad >= MAX_PROFUNDIDAD) {
            throw new DenviException.DesbordamientoDePila(ctx, MAX_PROFUNDIDAD);
        }
        Ambito ambAnt = ambito;
        Objeto objAnt = objetoActual;
        HashMap<String, EscfuncionContext> locAnt = funcionesLocales;

        ambito = nuevo;
        objetoActual = obj;
        funcionesLocales = locales;
        profundidad++;
        try {
            visit(cuerpo);
            return new Simbolo(Simbolo.TipoDato.VACIO, null);   // termino sin retornar
        } catch (Retorno r) {
            return r.valor;
        } catch (DenviException e) {
            e.agregarFrame(nombre, ctx);          // "at nombre(archivo:linea)"
            throw e;
        } catch (StackOverflowError so) {
            throw new DenviException.DesbordamientoDePila(ctx, MAX_PROFUNDIDAD);
        } finally {
            ambito = ambAnt;
            objetoActual = objAnt;
            funcionesLocales = locAnt;
            profundidad--;
        }
    }

    // ==================================================================
    // Objetos
    // ==================================================================

    // declaobj: Clase obj := iniciar(args)
    @Override
    public Simbolo visitDeclaobj(DeclaobjContext ctx) {
        String clase = ctx.IDEEST().getText();
        String nombre = ctx.IDEOBJ().getText();
        exigirNoDeclarada(ctx, nombre, "el objeto");
        clase(ctx, clase);   // la clase debe existir
        List<Simbolo> args = evaluarArgs(ctx.recparam());

        Objeto o = new Objeto(clase);
        asignarParametros(ctx, "iniciar de " + clase, atributosDe(ctx, clase), args, o.atributos);
        Simbolo s = new Simbolo(Simbolo.TipoDato.OBJETO, o);
        s.nombreClase = clase;
        ambito.vars.put(nombre, s);
        return null;
    }

    private Simbolo esto(ParserRuleContext ctx) {
        if (objetoActual == null) {
            throw new DenviException.EstoInvalido(ctx);
        }
        return new Simbolo(Simbolo.TipoDato.OBJETO, objetoActual);
    }

    private Objeto exigirObjeto(ParserRuleContext ctx, Simbolo s) {
        if (s.tipo == Simbolo.TipoDato.NULO) {
            throw new DenviException.ObjetoNulo(ctx, "no se puede usar un objeto nulo");
        }
        if (s.tipo == Simbolo.TipoDato.VACIO) {
            throw new DenviException.SinValorDeRetorno(ctx, "la llamada anterior");
        }
        if (s.tipo != Simbolo.TipoDato.OBJETO) {
            throw new DenviException.TipoIncompatible(ctx, ".", "OBJETO", s.tipo);
        }
        return (Objeto) s.valor;
    }

    /** Una llamada sin retorno no se puede usar como valor. */
    private void exigirValor(ParserRuleContext ctx, Simbolo s, String quien) {
        if (s != null && s.tipo == Simbolo.TipoDato.VACIO) {
            throw new DenviException.SinValorDeRetorno(ctx, quien);
        }
    }

    // miembro: &attr | #attr | Metodo(args)   (se aplica sobre un objeto)
    private Simbolo aplicarMiembro(Simbolo receptor, MiembroContext m) {
        if (m.IDEEST() != null) {
            return llamarMetodo(m, receptor, m.IDEEST().getText(), evaluarArgs(m.recparam()));
        }
        return leerAtributo(m, receptor, m.getText());
    }

    private Simbolo leerAtributo(ParserRuleContext ctx, Simbolo receptor, String nombre) {
        Objeto o = exigirObjeto(ctx, receptor);
        Simbolo v = o.atributos.get(nombre);
        if (v == null) {
            throw new DenviException.MiembroNoEncontrado(ctx, o.clase, "atributo", nombre);
        }
        if (sinValor(v)) {
            throw new DenviException.VariableNoInicializada(ctx, nombre);
        }
        return v;
    }

    private Simbolo llamarMetodo(ParserRuleContext ctx, Simbolo receptor, String nombre, List<Simbolo> args) {
        Objeto o = exigirObjeto(ctx, receptor);
        EscmetodoContext m = buscarMetodo(ctx, o.clase, nombre);
        if (m == null) {
            throw new DenviException.MiembroNoEncontrado(ctx, o.clase, "metodo", nombre);
        }
        return ejecutarMetodo(ctx, o, m, args);
    }

    // --- Herencia ---

    private EscclaseContext clase(ParserRuleContext ctx, String nombre) {
        EscclaseContext c = tablaClases.get(nombre);
        if (c == null) {
            throw new DenviException.ClaseNoEncontrada(ctx, nombre);
        }
        return c;
    }

    /** La clase y todos sus padres: [Hija, Padre, Abuelo...] */
    private List<EscclaseContext> cadenaDeClases(ParserRuleContext ctx, String nombre) {
        List<EscclaseContext> cadena = new ArrayList<>();
        Set<String> vistos = new HashSet<>();
        EscclaseContext c = clase(ctx, nombre);
        while (c != null) {
            if (!vistos.add(c.IDEEST(0).getText())) {
                throw new DenviException.HerenciaInvalida(ctx, "herencia circular en la clase " + nombre);
            }
            cadena.add(c);
            c = (c.IDEEST().size() > 1) ? clase(ctx, c.IDEEST(1).getText()) : null;
        }
        return cadena;
    }

    /** Atributos en orden: primero los del padre mas lejano, al final los de la clase. */
    private List<ParametroContext> atributosDe(ParserRuleContext ctx, String clase) {
        List<EscclaseContext> cadena = cadenaDeClases(ctx, clase);
        List<ParametroContext> attrs = new ArrayList<>();
        for (int i = cadena.size() - 1; i >= 0; i--) {
            attrs.addAll(parametros(cadena.get(i).decparam()));
        }
        return attrs;
    }

    private EscmetodoContext buscarMetodo(ParserRuleContext ctx, String clase, String nombre) {
        for (EscclaseContext c : cadenaDeClases(ctx, clase)) {
            for (EscmetodoContext m : c.esccuerpo().escmetodo()) {
                if (m.IDEEST().getText().equals(nombre)) {
                    return m;
                }
            }
        }
        return null;
    }

    private boolean esSubclase(ParserRuleContext ctx, String clase, String esperada) {
        for (EscclaseContext c : cadenaDeClases(ctx, clase)) {
            if (c.IDEEST(0).getText().equals(esperada)) {
                return true;
            }
        }
        return false;
    }

    // ==================================================================
    // Utilidades
    // ==================================================================

    private boolean esNumero(Simbolo s) {
        return s.tipo == Simbolo.TipoDato.ENTERO || s.tipo == Simbolo.TipoDato.DECIMAL;
    }

    /** Dos simbolos se pueden ordenar si ambos son numeros o ambos son tiempos. */
    private boolean esComparable(Simbolo a, Simbolo b) {
        return (esNumero(a) && esNumero(b))
                || (a.tipo == Simbolo.TipoDato.TIEMPO && b.tipo == Simbolo.TipoDato.TIEMPO);
    }

    private double aDouble(Simbolo s) {
        return ((Number) s.valor).doubleValue();
    }

    /** Texto de un valor, usado para imprimir y concatenar. */
    private static String texto(Simbolo s) {
        switch (s.tipo) {
            case BOOLEANO:
                return (Boolean) s.valor ? "verdadero" : "falso";
            case NULO:
                return "nulo";
            case TIEMPO: {
                int t = (Integer) s.valor;
                int abs = Math.abs(t);
                return String.format("%s[%d:%02d:%02d]", t < 0 ? "-" : "", abs / 3600, (abs % 3600) / 60, abs % 60);
            }
            default:
                return String.valueOf(s.valor);
        }
    }

    private void exigirBooleano(ParserRuleContext ctx, Simbolo s, String op) {
        if (s.tipo != Simbolo.TipoDato.BOOLEANO) {
            throw new DenviException.TipoIncompatible(ctx, op, "BOOLEANO", s.tipo);
        }
    }

    /** true si la variable existe pero no tiene valor. */
    private boolean sinValor(Simbolo s) {
        if (s.valor == null) {
            return s.tipo != Simbolo.TipoDato.NULO;
        }
        return s.valor instanceof Coleccion && ((Coleccion) s.valor).elementos == null;
    }

    /** Revisa que el valor sea del tipo pedido (un entero se convierte a decimal). */
    private Simbolo ajustarTipo(ParserRuleContext ctx, Simbolo.TipoDato tipo, Simbolo val, String op) {
        if (tipo == Simbolo.TipoDato.DECIMAL && val.tipo == Simbolo.TipoDato.ENTERO) {
            return new Simbolo(Simbolo.TipoDato.DECIMAL, ((Integer) val.valor).doubleValue());
        }
        if (val.tipo != tipo) {
            throw new DenviException.TipoIncompatible(ctx, op, tipo, val.tipo);
        }
        return val;
    }

    /** Pasa las marcas del simbolo anterior al nuevo (constante, global, clase). */
    private void copiarMeta(Simbolo origen, Simbolo destino) {
        destino.esConstante = origen.esConstante;
        destino.esGlobal = origen.esGlobal;
        destino.nombreClase = origen.nombreClase;
        destino.tipoElemento = origen.tipoElemento;
    }

    private void exigirModificable(ParserRuleContext ctx, Simbolo s, String nombre) {
        if (s != null && s.esConstante) {
            throw new DenviException.ConstanteInmodificable(ctx, nombre);
        }
    }

    /** Busca una variable en el ambito actual y sus padres. */
    private Simbolo obtenerVariable(ParserRuleContext ctx, String nombre) {
        Ambito a = ambito.duenio(nombre);
        if (a == null) {
            throw new DenviException.VariableNoDeclarada(ctx, nombre);
        }
        Simbolo s = a.vars.get(nombre);
        if (sinValor(s)) {
            throw new DenviException.VariableNoInicializada(ctx, nombre);
        }
        return s;
    }

    /** La tabla donde vive la variable (para poder modificarla). */
    private HashMap<String, Simbolo> tablaDe(ParserRuleContext ctx, String nombre) {
        Ambito a = ambito.duenio(nombre);
        if (a == null) {
            throw new DenviException.VariableNoDeclarada(ctx, nombre);
        }
        return a.vars;
    }

    /** El nombre no debe existir ya en el ambito actual. */
    private void exigirNoDeclarada(ParserRuleContext ctx, String nombre, String que) {
        if (ambito.vars.containsKey(nombre)) {
            throw new DenviException.DeclaracionDuplicada(ctx, que, nombre);
        }
    }

    /** Parametros (o atributos) sin nombres repetidos. */
    private void validarParametros(ParserRuleContext ctx, List<ParametroContext> params) {
        Set<String> vistos = new HashSet<>();
        for (ParametroContext p : params) {
            String n = (p.IDEEST() != null) ? p.IDEOBJ().getText() : p.IDE().getText();
            if (!vistos.add(n)) {
                throw new DenviException.DeclaracionDuplicada(ctx, "el parametro", n);
            }
        }
    }

    /** Parametros del metodo y funciones locales sin duplicados. */
    private void validarMetodo(EscmetodoContext m, String duenio) {
        validarParametros(m, parametros(m.decparam()));
        Set<String> locales = new HashSet<>();
        for (EscfuncionContext f : m.cuerpometodo().escfuncion()) {
            String n = f.IDEEST().getText();
            if (!locales.add(n)) {
                throw new DenviException.DeclaracionDuplicada(f, "la funcion local", n + " (en " + duenio + ")");
            }
            validarParametros(f, parametros(f.decparam()));
        }
    }

    /** Ejecuta un bloque en su propio ambito (ev, evalt, alt, rep). */
    private void ejecutarBloqueLocal(List<LincodContext> lineas) {
        Ambito anterior = ambito;
        ambito = new Ambito(anterior);
        try {
            ejecutarBloque(lineas);
        } finally {
            ambito = anterior;
        }
    }

    // ==================================================================
    // Declaraciones y asignaciones
    // ==================================================================

    // &x(ent);
    @Override
    public Simbolo visitDeclaracionSimple(DeclaracionSimpleContext ctx) {
        String nombre = ctx.IDE().getText();
        exigirNoDeclarada(ctx, nombre, "la variable");
        Simbolo.TipoDato tipo = Simbolo.desdeToken(ctx.tipo().getText());
        ambito.vars.put(nombre, new Simbolo(tipo, null));
        return null;
    }

    // &x(ent) := expresion;
    @Override
    public Simbolo visitDeclaracionAsig(DeclaracionAsigContext ctx) {
        String nombre = ctx.IDE().getText();
        exigirNoDeclarada(ctx, nombre, "la variable");
        Simbolo.TipoDato tipo = Simbolo.desdeToken(ctx.tipo().getText());
        Simbolo val = ajustarTipo(ctx, tipo, visit(ctx.expresion()), ":=");
        ambito.vars.put(nombre, new Simbolo(tipo, val.valor));
        return null;
    }

    // constante: #pi(dec) := 3.14;
    @Override
    public Simbolo visitConstante(ConstanteContext ctx) {
        String nombre = ctx.IDECON().getText();
        Simbolo.TipoDato tipo = Simbolo.desdeToken(ctx.tipo().getText());
        exigirNoDeclarada(ctx, nombre, "la constante");
        Simbolo val = ajustarTipo(ctx, tipo, visit(ctx.expresion()), ":=");
        ambito.vars.put(nombre, new Simbolo(tipo, val.valor, true, false));
        return null;
    }

    // asignacion: &x := (dato | autoinc)
    @Override
    public Simbolo visitAsigVar(AsigVarContext ctx) {
        String nombre = ctx.IDE().getText();
        asignarEn(ctx, tablaDe(ctx, nombre), nombre, ctx.dato(), ctx.autoinc());
        return null;
    }

    // asignacion: obj.&attr := (dato | autoinc)    (accmiem)
    @Override
    public Simbolo visitAsigMiembro(AsigMiembroContext ctx) {
        AccmiemContext m = ctx.accmiem();
        Simbolo actual = (m.IDEOBJ() != null) ? obtenerVariable(m, m.IDEOBJ().getText()) : esto(m);
        List<TerminalNode> attrs = m.IDE();
        for (int i = 0; i < attrs.size() - 1; i++) {
            actual = leerAtributo(m, actual, attrs.get(i).getText());
        }
        Objeto o = exigirObjeto(m, actual);
        String ultimo = attrs.get(attrs.size() - 1).getText();
        if (!o.atributos.containsKey(ultimo)) {
            throw new DenviException.MiembroNoEncontrado(ctx, o.clase, "atributo", ultimo);
        }
        asignarEn(ctx, o.atributos, ultimo, ctx.dato(), ctx.autoinc());
        return null;
    }

    /** Asigna dentro de una tabla (variables, globales o atributos de un objeto). */
    private void asignarEn(ParserRuleContext ctx, HashMap<String, Simbolo> tabla, String nombre,
                           DatoContext dato, AutoincContext autoinc) {
        Simbolo actual = tabla.get(nombre);
        exigirModificable(ctx, actual, nombre);
        if (autoinc != null) {
            aplicarAutoinc(autoinc, tabla, nombre);
            return;
        }
        Simbolo val = visit(dato);
        Simbolo nuevo;
        if (actual.tipo == Simbolo.TipoDato.ARREGLO || actual.tipo == Simbolo.TipoDato.LISTA) {
            nuevo = validarColeccion(ctx, val, ((Coleccion) actual.valor).tipoElem,
                    actual.tipo == Simbolo.TipoDato.LISTA);
        } else if (actual.nombreClase != null) {
            // variable o atributo de tipo objeto: acepta un objeto de la clase (o hija) o nulo
            if (val.tipo == Simbolo.TipoDato.NULO) {
                nuevo = new Simbolo(Simbolo.TipoDato.NULO, null);
            } else {
                Objeto o = exigirObjeto(ctx, val);
                if (!esSubclase(ctx, o.clase, actual.nombreClase)) {
                    throw new DenviException.ClaseIncompatible(ctx, nombre, actual.nombreClase, o.clase);
                }
                nuevo = new Simbolo(Simbolo.TipoDato.OBJETO, o);
            }
        } else {
            exigirValor(ctx, val, "la expresion asignada a " + nombre);
            nuevo = new Simbolo(actual.tipo, ajustarTipo(ctx, actual.tipo, val, ":=").valor);
        }
        copiarMeta(actual, nuevo);
        tabla.put(nombre, nuevo);
    }

    // decla_glob: Mundo (declaracion | constante | decar | declt | declaobj)
    @Override
    public Simbolo visitDecla_glob(Decla_globContext ctx) {
        // se declara en un ambito temporal (para que la expresion vea las variables locales)
        // y despues se pasa al ambito global
        Ambito anterior = ambito;
        Ambito temporal = new Ambito(anterior);
        ambito = temporal;
        try {
            visit(ctx.getChild(1));
        } finally {
            ambito = anterior;
        }
        for (Map.Entry<String, Simbolo> e : temporal.vars.entrySet()) {
            if (ambitoGlobal.vars.containsKey(e.getKey())) {
                throw new DenviException.DeclaracionDuplicada(ctx, "la variable global", e.getKey());
            }
            e.getValue().esGlobal = true;
            ambitoGlobal.vars.put(e.getKey(), e.getValue());
        }
        return null;
    }

    // asig_glob: Mundo asignacion
    @Override
    public Simbolo visitAsig_glob(Asig_globContext ctx) {
        AsignacionContext a = ctx.asignacion();
        if (a instanceof AsigVarContext) {
            AsigVarContext v = (AsigVarContext) a;
            String nombre = v.IDE().getText();
            if (!ambitoGlobal.vars.containsKey(nombre)) {
                throw new DenviException.VariableNoDeclarada(ctx, nombre + " (declarala con Mundo)");
            }
            asignarEn(v, ambitoGlobal.vars, nombre, v.dato(), v.autoinc());
            return null;
        }
        return visit(a); // los objetos ya se comparten, se asigna normal
    }

    // ==================================================================
    // Arreglos y listas
    // ==================================================================

    // decar: ar &x(ent) (:= [..])?  |  ar #x(ent) := [..]
    @Override
    public Simbolo visitDecar(DecarContext ctx) {
        declararColeccion(ctx, ctx.IDE() != null ? ctx.IDE() : ctx.IDECON(), ctx.tipo(), ctx.arreglo(), false);
        return null;
    }

    // declt: lt &x(ent) (:= {..})?  |  lt #x(ent) := {..}
    @Override
    public Simbolo visitDeclt(DecltContext ctx) {
        declararColeccion(ctx, ctx.IDE() != null ? ctx.IDE() : ctx.IDECON(), ctx.tipo(), ctx.lista(), true);
        return null;
    }

    private void declararColeccion(ParserRuleContext ctx, TerminalNode id, TipoContext tipoCtx,
                                   ParserRuleContext valorCtx, boolean lista) {
        String nombre = id.getText();
        Simbolo.TipoDato tipo = Simbolo.desdeToken(tipoCtx.getText());
        boolean constante = nombre.startsWith("#");
        exigirNoDeclarada(ctx, nombre, constante ? "la constante" : "la variable");
        Simbolo s;
        if (valorCtx == null) {
            s = new Simbolo(lista ? Simbolo.TipoDato.LISTA : Simbolo.TipoDato.ARREGLO,
                    new Coleccion(tipo, null, lista));
        } else {
            s = validarColeccion(ctx, visit(valorCtx), tipo, lista);
        }
        s.esConstante = constante;
        s.tipoElemento = tipo;
        ambito.vars.put(nombre, s);
    }

    /** Revisa que todos los elementos sean del tipo pedido (los anidados tambien). Regresa una copia. */
    private Simbolo validarColeccion(ParserRuleContext ctx, Simbolo val, Simbolo.TipoDato tipo, boolean lista) {
        Simbolo.TipoDato esperado = lista ? Simbolo.TipoDato.LISTA : Simbolo.TipoDato.ARREGLO;
        if (val.tipo != esperado) {
            throw new DenviException.TipoIncompatible(ctx, ":=", esperado, val.tipo);
        }
        Coleccion c = (Coleccion) val.valor;
        if (c.tipoElem != null) {
            if (c.tipoElem != tipo) {
                throw new DenviException.TipoIncompatible(ctx, ":=", tipo, c.tipoElem);
            }
            List<Simbolo> copia = (c.elementos == null) ? null : new ArrayList<>(c.elementos);
            return new Simbolo(esperado, new Coleccion(tipo, copia, lista));
        }
        List<Simbolo> nuevos = new ArrayList<>();
        for (Simbolo e : c.elementos) {
            if (!lista && e.tipo == Simbolo.TipoDato.ARREGLO) {
                nuevos.add(validarColeccion(ctx, e, tipo, false));
            } else {
                nuevos.add(ajustarTipo(ctx, tipo, e, "elemento"));
            }
        }
        return new Simbolo(esperado, new Coleccion(tipo, nuevos, lista));
    }

    // arreglo: [ cont_arr (, cont_arr)* ]
    @Override
    public Simbolo visitArreglo(ArregloContext ctx) {
        List<Simbolo> elems = new ArrayList<>();
        for (Cont_arrContext c : ctx.cont_arr()) {
            elems.add(visit(c));
        }
        return new Simbolo(Simbolo.TipoDato.ARREGLO, new Coleccion(null, elems, false));
    }

    // cont_arr: valor | IDE | IDECON | arreglo
    @Override
    public Simbolo visitCont_arr(Cont_arrContext ctx) {
        if (ctx.valor() != null) {
            return visit(ctx.valor());
        }
        if (ctx.arreglo() != null) {
            return visit(ctx.arreglo());
        }
        return obtenerVariable(ctx, ctx.getText());
    }

    // lista: { (valor | IDE | IDECON) (, ...)* }
    @Override
    public Simbolo visitLista(ListaContext ctx) {
        List<Simbolo> elems = new ArrayList<>();
        for (ParseTree hijo : ctx.children) {
            if (hijo instanceof ValorContext) {
                elems.add(visit(hijo));
            } else if (hijo instanceof TerminalNode) {
                int t = ((TerminalNode) hijo).getSymbol().getType();
                if (t == denviParser.IDE || t == denviParser.IDECON) {
                    Simbolo s = obtenerVariable(ctx, hijo.getText());
                    if (s.tipo == Simbolo.TipoDato.ARREGLO || s.tipo == Simbolo.TipoDato.LISTA) {
                        throw new DenviException.ColeccionInvalida(ctx, "una lista no puede contener otra coleccion");
                    }
                    elems.add(s);
                }
            }
        }
        return new Simbolo(Simbolo.TipoDato.LISTA, new Coleccion(null, elems, true));
    }

    // dato: arreglo | lista | expresion
    @Override
    public Simbolo visitDato(DatoContext ctx) {
        if (ctx.arreglo() != null) {
            return visit(ctx.arreglo());
        }
        if (ctx.lista() != null) {
            return visit(ctx.lista());
        }
        return visit(ctx.expresion());
    }

    // ==================================================================
    // Entrada / Salida
    // ==================================================================

    @Override
    public Simbolo visitImpcons(ImpconsContext ctx) {
        out.print(construirSalida(ctx.imprimible()));
        return null;
    }

    @Override
    public Simbolo visitImpconssl(ImpconsslContext ctx) {
        out.println(construirSalida(ctx.imprimible()));
        return null;
    }

    private String construirSalida(List<ImprimibleContext> items) {
        StringBuilder sb = new StringBuilder();
        for (ImprimibleContext item : items) {
            Simbolo s = visit(item);
            exigirValor(item, s, "la expresion a imprimir");
            sb.append(texto(s));
        }
        return sb.toString();
    }

    // imprimible: dato (tambien arreglos y listas)
    @Override
    public Simbolo visitImprimible(ImprimibleContext ctx) {
        return visit(ctx.dato());
    }

    // obtdatos: ObtDatos(tipo : &x)
    @Override
    public Simbolo visitObtdatos(ObtdatosContext ctx) {
        Simbolo.TipoDato tipo = Simbolo.desdeToken(ctx.tipo().getText());
        String nombre = ctx.IDE().getText();

        if (mostrarPrompt) {
            out.print(nombre + " (" + tipo.name().toLowerCase() + "): ");
        }
        if (!entrada.hasNextLine()) {
            throw new DenviException.EntradaInvalida(ctx, "no hay mas datos en la entrada");
        }
        Simbolo val = leerComo(ctx, tipo, entrada.nextLine());

        Ambito a = ambito.duenio(nombre);
        if (a == null) {
            ambito.vars.put(nombre, val);
        } else {
            Simbolo actual = a.vars.get(nombre);
            exigirModificable(ctx, actual, nombre);
            Simbolo nuevo = new Simbolo(actual.tipo, ajustarTipo(ctx, actual.tipo, val, "ObtDatos").valor);
            copiarMeta(actual, nuevo);
            a.vars.put(nombre, nuevo);
        }
        return null;
    }

    private Simbolo leerComo(ParserRuleContext ctx, Simbolo.TipoDato tipo, String linea) {
        String t = linea.trim();
        try {
            switch (tipo) {
                case ENTERO:
                    return new Simbolo(tipo, Integer.parseInt(t));
                case DECIMAL:
                    return new Simbolo(tipo, Double.parseDouble(t));
                case CADENA:
                    return new Simbolo(tipo, linea);
                case CARACTER:
                    if (linea.length() == 1) {
                        return new Simbolo(tipo, linea.charAt(0));
                    }
                    if (t.length() != 1) {
                        break;
                    }
                    return new Simbolo(tipo, t.charAt(0));
                case BOOLEANO:
                    if (t.equals("verdadero")) {
                        return new Simbolo(tipo, true);
                    }
                    if (t.equals("falso")) {
                        return new Simbolo(tipo, false);
                    }
                    break;
                case TIEMPO:
                    return new Simbolo(tipo, tiempoASegundos(t.startsWith("[") ? t : "[" + t + "]"));
                case NULO:
                    if (t.equals("nulo")) {
                        return new Simbolo(tipo, null);
                    }
                    break;
                default:
                    throw new DenviException.NoSoportado(ctx, "leer datos de tipo " + tipo);
            }
        } catch (NumberFormatException e) {
            // cae al error de abajo
        }
        throw new DenviException.EntradaInvalida(ctx, "\"" + linea + "\" no es un valor valido de tipo " + tipo);
    }

    // lincod: linin CIER
    @Override
    public Simbolo visitLincod(LincodContext ctx) {
        if (Thread.currentThread().isInterrupted()) {
            throw new java.util.concurrent.CancellationException("Tiempo de ejecucion agotado");
        }
        return visit(ctx.linin());
    }

    // ==================================================================
    // Niveles, zonas, portales y mundo
    // ==================================================================

    // escnivel: solo se registra; se ejecuta con Viajar
    @Override
    public Simbolo visitEscnivel(EscnivelContext ctx) {
        String nombre = ctx.IDEEST().getText();
        if (tablaNiveles.containsKey(nombre)) {
            throw new DenviException.DeclaracionDuplicada(ctx, "el nivel", nombre);
        }
        tablaNiveles.put(nombre, ctx);
        if (ctx.enlace() != null) {
            agregarPortales(nombre, ctx.enlace());
        }
        return null;
    }

    // conexion: Nivel.Portal --> destino
    @Override
    public Simbolo visitConexion(ConexionContext ctx) {
        String origen = ctx.IDEEST().getText();
        if (!tablaNiveles.containsKey(origen)) {
            throw new DenviException.NivelInvalido(ctx,
                    "el nivel " + origen + " no existe (declaralo antes de conectarlo)");
        }
        agregarPortales(origen, ctx.enlace());
        return null;
    }

    // enlace: .Portal --> destino      destino: Nivel | (Nivel, Nivel...)
    private void agregarPortales(String origen, EnlaceContext e) {
        Set<String> salidas = portales.computeIfAbsent(origen, k -> new LinkedHashSet<>());
        for (TerminalNode d : e.destino().IDEEST()) {
            salidas.add(d.getText());
            portalesPendientes.add(new PortalPendiente(e, origen, d.getText()));
        }
    }

    /** Al terminar el programa, todo destino de un Portal debe ser un nivel declarado. */
    private void validarPortales() {
        for (PortalPendiente p : portalesPendientes) {
            if (!tablaNiveles.containsKey(p.destino)) {
                throw new DenviException.NivelInvalido(p.ctx,
                        "el nivel " + p.destino + " (destino del Portal de " + p.origen + ") no existe");
            }
        }
    }

    // propiedades: ( propiedad (, propiedad)* )
    @Override
    public Simbolo visitPropiedades(PropiedadesContext ctx) {
        for (PropiedadContext p : ctx.propiedad()) {
            visit(p);
        }
        return null;
    }

    // propiedad: declaracion | constante
    @Override
    public Simbolo visitPropiedad(PropiedadContext ctx) {
        return visit(ctx.getChild(0));
    }

    // cuerponivel: { IGNOR; | subzona (, subzona)* | lincod* }
    @Override
    public Simbolo visitCuerponivel(CuerponivelContext ctx) {
        if (!ctx.subzona().isEmpty()) {
            for (SubzonaContext z : ctx.subzona()) {
                visit(z);
            }
        } else {
            ejecutarBloque(ctx.lincod());
        }
        return null;
    }

    // subzona: Zona Nombre -> ( propiedades cuerponivel )
    @Override
    public Simbolo visitSubzona(SubzonaContext ctx) {
        ejecutarEscenario("ZONA", ctx.IDEEST().getText(), ctx.propiedades(), ctx.cuerponivel());
        return null;
    }

    /** Nivel o zona: ambito nuevo con sus propiedades, luego su cuerpo. */
    private void ejecutarEscenario(String tipo, String nombre, PropiedadesContext props, CuerponivelContext cuerpo) {
        Ambito anterior = ambito;
        String zonaAnterior = zonaActual;
        ambito = new Ambito(anterior);
        zonaActual = tipo.equals("ZONA") ? nombre : null;
        try {
            visit(props);
            visit(cuerpo);
        } finally {
            ambito = anterior;
            zonaActual = zonaAnterior;
        }
    }

    // viajar: Viajar(Nivel)
    @Override
    public Simbolo visitViajar(ViajarContext ctx) {
        String destino = ctx.IDEEST().getText();
        EscnivelContext n = tablaNiveles.get(destino);
        if (n == null) {
            throw new DenviException.NivelInvalido(ctx,
                    "el nivel " + destino + " no existe (declaralo antes de viajar)");
        }
        if (nivelActual != null) {
            Set<String> salidas = portales.getOrDefault(nivelActual, Collections.emptySet());
            if (!salidas.contains(destino)) {
                throw new DenviException.PortalInvalido(ctx,
                        "no hay un Portal de " + nivelActual + " hacia " + destino);
            }
        }
        nivelActual = destino;
        ejecutarEscenario("NIVEL", destino, n.propiedades(), n.cuerponivel());
        revisarSucesos();
        return null;
    }

    // situar: Situar(obj -> (x, y) (-> Nivel)?)
    @Override
    public Simbolo visitSituar(SituarContext ctx) {
        String nombre = ctx.IDEOBJ().getText();
        Objeto o = exigirObjeto(ctx, obtenerVariable(ctx, nombre));
        Simbolo x = visit(ctx.expresion(0));
        Simbolo y = visit(ctx.expresion(1));
        if (!esNumero(x) || !esNumero(y)) {
            throw new DenviException.TipoIncompatible(ctx, "Situar", "ENTERO o DECIMAL",
                    esNumero(x) ? y.tipo : x.tipo);
        }
        boolean explicito = ctx.IDEEST() != null;
        String nivel = explicito ? ctx.IDEEST().getText() : nivelActual;
        if (nivel == null) {
            throw new DenviException.NivelInvalido(ctx, "no hay nivel actual: usa Viajar o indica el nivel en Situar");
        }
        if (!tablaNiveles.containsKey(nivel)) {
            throw new DenviException.NivelInvalido(ctx, "el nivel " + nivel + " no existe");
        }
        o.nivel = nivel;
        o.zona = explicito ? null : zonaActual;
        o.x = aDouble(x);
        o.y = aDouble(y);
        enMundo.add(o);
        revisarSucesos();
        return null;
    }

    // retirar: Retirar(obj)
    @Override
    public Simbolo visitRetirar(RetirarContext ctx) {
        String nombre = ctx.IDEOBJ().getText();
        Objeto o = exigirObjeto(ctx, obtenerVariable(ctx, nombre));
        o.nivel = null;
        o.zona = null;
        enMundo.remove(o);
        revisarSucesos();
        return null;
    }

    private String ubicacionDe(Objeto o) {
        if (o.nivel == null) {
            return null;
        }
        return (o.zona == null) ? o.nivel : o.nivel + "." + o.zona;
    }

    // ==================================================================
    // Sucesos
    // ==================================================================

    // escsuceso: Suceso((obj, Tipo) -> {..})  |  Suceso((condicion) -> {..})
    @Override
    public Simbolo visitEscsuceso(EscsucesoContext ctx) {
        String tipoCorto = null;
        Objeto objetivo = null;
        if (ctx.IDEEST() != null) {
            tipoCorto = ctx.IDEEST().getText();
            if (!CATALOGO_SUCESOS.contains(tipoCorto)) {
                throw new DenviException.SucesoInvalido(ctx, tipoCorto, CATALOGO_SUCESOS);
            }
            String nombre = ctx.IDEOBJ().getText();
            Ambito a = ambito.duenio(nombre);
            if (a == null) {
                throw new DenviException.VariableNoDeclarada(ctx, nombre);
            }
            Simbolo s = a.vars.get(nombre);
            if (s.tipo != Simbolo.TipoDato.OBJETO && s.tipo != Simbolo.TipoDato.NULO) {
                throw new DenviException.TipoIncompatible(ctx, "Suceso", "OBJETO", s.tipo);
            }
            if (s.tipo == Simbolo.TipoDato.OBJETO) {
                objetivo = (Objeto) s.valor;
            }
        }

        Suceso nuevo = new Suceso(ctx, ambito, objetoActual, tipoCorto);
        // si el cuerpo de un nivel se ejecuta otra vez (Viajar), el suceso se reemplaza y no se duplica
        int existente = -1;
        for (int i = 0; i < sucesos.size(); i++) {
            Suceso s = sucesos.get(i);
            if (s.ctx == ctx && s.objeto == objetoActual) {
                existente = i;
                break;
            }
        }
        if (existente >= 0) {
            Suceso viejo = sucesos.get(existente);
            nuevo.activo = viejo.activo;
            nuevo.ubicacionPrevia = viejo.ubicacionPrevia;
            sucesos.set(existente, nuevo);
        } else {
            if (objetivo != null) {
                nuevo.ubicacionPrevia = ubicacionDe(objetivo);   // Ingreso/Egreso solo reaccionan a cambios
            }
            sucesos.add(nuevo);
        }
        revisarSucesos();
        return null;
    }

    /** Dispara los sucesos que se cumplen. Si un suceso cambia el mundo, se vuelve a revisar. */
    private void revisarSucesos() {
        if (revisandoSucesos) {
            revisionPendiente = true;   // se revisa otra vez al terminar la pasada actual
            return;
        }
        revisandoSucesos = true;
        try {
            int pasadas = 0;
            do {
                revisionPendiente = false;
                for (Suceso s : new ArrayList<>(sucesos)) {
                    if (debeDisparar(s)) {
                        disparar(s);
                    }
                }
                pasadas++;
            } while (revisionPendiente && pasadas < MAX_PASADAS);
        } finally {
            revisandoSucesos = false;
            revisionPendiente = false;
        }
    }

    /** true si el suceso ocurre ahora (condicion que pasa de falsa a verdadera, o ingreso/egreso). */
    private boolean debeDisparar(Suceso s) {
        Ambito ambAnt = ambito;
        Objeto objAnt = objetoActual;
        ambito = s.ambito;
        objetoActual = s.objeto;
        try {
            EscsucesoContext c = s.ctx;
            boolean ahora;

            if (s.tipoCorto == null) {
                // forma general: condicion libre
                Simbolo r = visit(c.expresion());
                exigirBooleano(c, r, "Suceso");
                ahora = (Boolean) r.valor;
            } else {
                // forma corta: objeto + tipo del catalogo
                Simbolo sim = obtenerVariable(c, c.IDEOBJ().getText());
                if (sim.tipo == Simbolo.TipoDato.NULO) {
                    s.activo = false;
                    return false;
                }
                Objeto o = exigirObjeto(c, sim);
                String ub = ubicacionDe(o);
                switch (s.tipoCorto) {
                    case "Ingreso": {
                        boolean entra = ub != null && !ub.equals(s.ubicacionPrevia);
                        s.ubicacionPrevia = ub;
                        return entra;
                    }
                    case "Egreso": {
                        boolean sale = s.ubicacionPrevia != null && !s.ubicacionPrevia.equals(ub);
                        s.ubicacionPrevia = ub;
                        return sale;
                    }
                    default:   // Choque o Toma
                        ahora = o.nivel != null && hayCoincidencia(c, o, s.tipoCorto.equals("Toma"));
                }
            }

            boolean dispara = ahora && !s.activo;
            s.activo = ahora;
            return dispara;
        } finally {
            ambito = ambAnt;
            objetoActual = objAnt;
        }
    }

    /** Choque: otro objeto (no recompensa) en la misma posicion. Toma: una recompensa en la misma posicion. */
    private boolean hayCoincidencia(ParserRuleContext ctx, Objeto o, boolean buscaRecompensa) {
        for (Objeto otro : enMundo) {
            if (otro != o && o.nivel.equals(otro.nivel) && o.x == otro.x && o.y == otro.y) {
                boolean esRecompensa = esSubclase(ctx, otro.clase, CLASE_RECOMPENSA);
                if (esRecompensa == buscaRecompensa) {
                    return true;
                }
            }
        }
        return false;
    }

    private void disparar(Suceso s) {
        Ambito ambAnt = ambito;
        Objeto objAnt = objetoActual;
        ambito = new Ambito(s.ambito);
        objetoActual = s.objeto;
        try {
            ejecutarBloque(s.ctx.cuerposuceso().lincod());
        } catch (Retorno r) {
            throw new DenviException.RetornoInvalido(s.ctx, "no se puede usar retornar dentro de un Suceso");
        } finally {
            ambito = ambAnt;
            objetoActual = objAnt;
        }
    }

    // ==================================================================
    // ev / rep
    // ==================================================================

    private void ejecutarBloque(List<LincodContext> lineas) {
        for (LincodContext l : lineas) {
            visit(l);
        }
    }

    private boolean evaluarCondicion(ExpresionContext e, String estructura) {
        Simbolo c = visit(e);
        exigirBooleano(e, c, estructura);
        return (Boolean) c.valor;
    }

    @Override
    public Simbolo visitEscond(EscondContext ctx) {
        if (evaluarCondicion(ctx.contev().expresion(), "ev")) {
            ejecutarBloqueLocal(ctx.contev().cuerpoev().lincod());
            return null;
        }
        for (ContevaltContext alt : ctx.contevalt()) {
            if (evaluarCondicion(alt.expresion(), "evalt")) {
                ejecutarBloqueLocal(alt.cuerpoevalt().lincod());
                return null;
            }
        }
        if (ctx.cuerpoalt() != null) {
            ejecutarBloqueLocal(ctx.cuerpoalt().lincod());
        }
        return null;
    }

    @Override
    public Simbolo visitRepDeclaracion(RepDeclaracionContext ctx) {
        Ambito anterior = ambito;
        ambito = new Ambito(anterior);               // la variable del rep solo vive en el ciclo
        try {
            visit(ctx.declaracion());
            String var = ctx.declaracion().getStart().getText();
            ejecutarCiclo(ctx.contrep(), () -> aplicarIncre(ctx.incre(), var));
        } finally {
            ambito = anterior;
        }
        return null;
    }

    @Override
    public Simbolo visitRepAsignacion(RepAsignacionContext ctx) {
        if (ctx.asignacion() != null) {
            visit(ctx.asignacion());
        } else {
            obtenerVariable(ctx, ctx.IDE().getText());
        }
        ejecutarCiclo(ctx.contrep(), () -> aplicarIncreesp(ctx.increesp()));
        return null;
    }

    private void ejecutarCiclo(ContrepContext c, Runnable incremento) {
        while (evaluarCondicion(c.expresion(), "rep")) {
            if (Thread.currentThread().isInterrupted()) {
                throw new java.util.concurrent.CancellationException("Tiempo de ejecucion agotado");
            }
            ejecutarBloqueLocal(c.cuerporep().lincod());
            incremento.run();
        }
    }

    private void aplicarIncre(IncreContext inc, String var) {
        if (inc.autoinc() != null) {
            aplicarAutoinc(inc.autoinc(), tablaDe(inc, var), var);
        } else {
            aplicarIncreesp(inc.increesp());
        }
    }

    private void aplicarAutoinc(AutoincContext a, HashMap<String, Simbolo> tabla, String var) {
        if (a instanceof AutoIncSimpleContext) {
            AutoIncSimpleContext s = (AutoIncSimpleContext) a;
            incrementar(a, tabla, var, s.INCS() != null, null);
        } else {
            AutoIncPasoContext p = (AutoIncPasoContext) a;
            incrementar(a, tabla, var, p.INCV() != null, p.paso());
        }
    }

    private void aplicarIncreesp(IncreespContext e) {
        String nombre = e.IDE().getText();
        boolean suma = e.INCS() != null || e.INCV() != null;
        incrementar(e, tablaDe(e, nombre), nombre, suma, e.paso());
    }

    private Simbolo evaluarPaso(PasoContext p) {
        if (p.valor() != null) {
            return visit(p.valor());
        }
        return obtenerVariable(p, p.getText());
    }

    private void incrementar(ParserRuleContext ctx, HashMap<String, Simbolo> tabla, String nombre,
                             boolean suma, PasoContext pasoCtx) {
        Simbolo actual = tabla.get(nombre);
        if (actual == null) {
            throw new DenviException.VariableNoDeclarada(ctx, nombre);
        }
        exigirModificable(ctx, actual, nombre);
        if (sinValor(actual)) {
            throw new DenviException.VariableNoInicializada(ctx, nombre);
        }
        Simbolo paso = (pasoCtx == null) ? new Simbolo(Simbolo.TipoDato.ENTERO, 1) : evaluarPaso(pasoCtx);
        String op = suma ? "+" : "-";

        if (!esNumero(actual) || !esNumero(paso)) {
            throw new DenviException.TipoIncompatible(ctx, op, actual.tipo, paso.tipo);
        }

        Simbolo nuevo;
        if (actual.tipo == Simbolo.TipoDato.DECIMAL) {
            double a = aDouble(actual), b = aDouble(paso);
            nuevo = new Simbolo(Simbolo.TipoDato.DECIMAL, suma ? a + b : a - b);
        } else {
            if (paso.tipo == Simbolo.TipoDato.DECIMAL) {
                throw new DenviException.TipoIncompatible(ctx, op, Simbolo.TipoDato.ENTERO, paso.tipo);
            }
            int a = (Integer) actual.valor, b = (Integer) paso.valor;
            try {
                nuevo = new Simbolo(Simbolo.TipoDato.ENTERO,
                        suma ? Math.addExact(a, b) : Math.subtractExact(a, b));
            } catch (ArithmeticException ex) {
                throw new DenviException.Desbordamiento(ctx, a + " " + op + " " + b);
            }
        }
        copiarMeta(actual, nuevo);
        tabla.put(nombre, nuevo);
    }

    // ==================================================================
    // Expresiones
    // ==================================================================

    @Override
    public Simbolo visitExpresion(ExpresionContext ctx) {
        return visit(ctx.logor());
    }

    @Override
    public Simbolo visitLogor(LogorContext ctx) {
        Simbolo resultado = visit(ctx.logand(0));
        if (ctx.logand().size() == 1) {
            return resultado;
        }
        exigirBooleano(ctx, resultado, "||");

        for (int i = 1; i < ctx.logand().size(); i++) {
            if ((Boolean) resultado.valor) {
                return new Simbolo(Simbolo.TipoDato.BOOLEANO, true);   // cortocircuito
            }
            Simbolo valorder = visit(ctx.logand(i));
            exigirBooleano(ctx, valorder, "||");
            resultado = new Simbolo(Simbolo.TipoDato.BOOLEANO, (boolean) valorder.valor);
        }
        return resultado;
    }

    @Override
    public Simbolo visitLogand(LogandContext ctx) {
        Simbolo resultado = visit(ctx.logig(0));
        if (ctx.logig().size() == 1) {
            return resultado;
        }
        exigirBooleano(ctx, resultado, "^");

        for (int i = 1; i < ctx.logig().size(); i++) {
            if (!(Boolean) resultado.valor) {
                return new Simbolo(Simbolo.TipoDato.BOOLEANO, false);   // cortocircuito
            }
            Simbolo valorder = visit(ctx.logig(i));
            exigirBooleano(ctx, valorder, "^");
            resultado = new Simbolo(Simbolo.TipoDato.BOOLEANO, (boolean) valorder.valor);
        }
        return resultado;
    }

    @Override
    public Simbolo visitLogig(LogigContext ctx) {
        Simbolo resultado = visit(ctx.logrel(0));

        for (int i = 1; i < ctx.logrel().size(); i++) {
            String op = ctx.getChild(i * 2 - 1).getText();
            Simbolo valorder = visit(ctx.logrel(i));
            boolean iguales;

            if (esNumero(resultado) && esNumero(valorder)) {
                iguales = aDouble(resultado) == aDouble(valorder);
            } else if (resultado.tipo == Simbolo.TipoDato.NULO || valorder.tipo == Simbolo.TipoDato.NULO) {
                iguales = resultado.tipo == valorder.tipo;
            } else if (resultado.tipo == valorder.tipo) {
                iguales = Objects.equals(resultado.valor, valorder.valor);
            } else {
                throw new DenviException.TipoIncompatible(ctx, op, resultado.tipo, valorder.tipo);
            }

            boolean r = op.equals("==") ? iguales : !iguales;
            resultado = new Simbolo(Simbolo.TipoDato.BOOLEANO, r);
        }
        return resultado;
    }

    @Override
    public Simbolo visitLogrel(LogrelContext ctx) {
        Simbolo resultado = visit(ctx.logar(0));

        for (int i = 1; i < ctx.logar().size(); i++) {
            String op = ctx.getChild(i * 2 - 1).getText();
            Simbolo valorder = visit(ctx.logar(i));

            if (!esComparable(resultado, valorder)) {
                throw new DenviException.TipoIncompatible(ctx, op, resultado.tipo, valorder.tipo);
            }

            double a = aDouble(resultado);
            double b = aDouble(valorder);
            boolean r;
            switch (op) {
                case "<":  r = a < b;  break;
                case ">":  r = a > b;  break;
                case "=<": r = a <= b; break;
                case "=>": r = a >= b; break;
                default:   throw new IllegalStateException("operador relacional desconocido: " + op);
            }
            resultado = new Simbolo(Simbolo.TipoDato.BOOLEANO, r);
        }
        return resultado;
    }

    @Override
    public Simbolo visitLogar(LogarContext ctx) {
        Simbolo resultado = visit(ctx.termino(0));

        for (int i = 1; i < ctx.termino().size(); i++) {
            String op = ctx.getChild(i * 2 - 1).getText();
            Simbolo valorder = visit(ctx.termino(i));

            // concatenacion
            if (op.equals("+") && (resultado.tipo == Simbolo.TipoDato.CADENA
                    || valorder.tipo == Simbolo.TipoDato.CADENA)) {
                resultado = new Simbolo(Simbolo.TipoDato.CADENA, texto(resultado) + texto(valorder));
                continue;
            }

            // tiempo +/- tiempo
            if (resultado.tipo == Simbolo.TipoDato.TIEMPO && valorder.tipo == Simbolo.TipoDato.TIEMPO) {
                int a = (Integer) resultado.valor, b = (Integer) valorder.valor;
                try {
                    int r = op.equals("+") ? Math.addExact(a, b) : Math.subtractExact(a, b);
                    resultado = new Simbolo(Simbolo.TipoDato.TIEMPO, r);
                } catch (ArithmeticException e) {
                    throw new DenviException.Desbordamiento(ctx, a + " " + op + " " + b);
                }
                continue;
            }

            if (!esNumero(resultado) || !esNumero(valorder)) {
                throw new DenviException.TipoIncompatible(ctx, op, resultado.tipo, valorder.tipo);
            }

            boolean esDecimal = resultado.tipo == Simbolo.TipoDato.DECIMAL
                    || valorder.tipo == Simbolo.TipoDato.DECIMAL;

            if (esDecimal) {
                double a = aDouble(resultado), b = aDouble(valorder);
                resultado = new Simbolo(Simbolo.TipoDato.DECIMAL, op.equals("+") ? a + b : a - b);
            } else {
                int a = (Integer) resultado.valor, b = (Integer) valorder.valor;
                try {
                    int r = op.equals("+") ? Math.addExact(a, b) : Math.subtractExact(a, b);
                    resultado = new Simbolo(Simbolo.TipoDato.ENTERO, r);
                } catch (ArithmeticException e) {
                    throw new DenviException.Desbordamiento(ctx, a + " " + op + " " + b);
                }
            }
        }
        return resultado;
    }

    @Override
    public Simbolo visitTermino(TerminoContext ctx) {
        Simbolo resultado = visit(ctx.simbun(0));

        for (int i = 1; i < ctx.simbun().size(); i++) {
            String op = ctx.getChild(i * 2 - 1).getText();
            Simbolo valorder = visit(ctx.simbun(i));

            if (!esNumero(resultado) || !esNumero(valorder)) {
                throw new DenviException.TipoIncompatible(ctx, op, resultado.tipo, valorder.tipo);
            }

            if ((op.equals("/") || op.equals("%")) && aDouble(valorder) == 0.0) {
                throw new DenviException.DivisionEntreCero(ctx, op);
            }

            boolean esDecimal = resultado.tipo == Simbolo.TipoDato.DECIMAL
                    || valorder.tipo == Simbolo.TipoDato.DECIMAL;

            if (esDecimal) {
                double a = aDouble(resultado), b = aDouble(valorder);
                double r;
                switch (op) {
                    case "*": r = a * b; break;
                    case "/": r = a / b; break;
                    default:  r = a % b; break;
                }
                resultado = new Simbolo(Simbolo.TipoDato.DECIMAL, r);
            } else {
                int a = (Integer) resultado.valor, b = (Integer) valorder.valor;
                try {
                    int r;
                    switch (op) {
                        case "*":
                            r = Math.multiplyExact(a, b);
                            break;
                        case "/":
                            if (a == Integer.MIN_VALUE && b == -1) {
                                throw new ArithmeticException("integer overflow");
                            }
                            r = a / b;
                            break;
                        default:
                            r = a % b;
                            break;
                    }
                    resultado = new Simbolo(Simbolo.TipoDato.ENTERO, r);
                } catch (ArithmeticException e) {
                    throw new DenviException.Desbordamiento(ctx, a + " " + op + " " + b);
                }
            }
        }
        return resultado;
    }

    @Override
    public Simbolo visitSimbun(SimbunContext ctx) {
        if (ctx.simbun() == null) {
            return visit(ctx.valp());
        }

        String op = ctx.getChild(0).getText();
        Simbolo val = visit(ctx.simbun());

        switch (op) {
            case "!":
                exigirBooleano(ctx, val, "!");
                return new Simbolo(Simbolo.TipoDato.BOOLEANO, !(Boolean) val.valor);

            case "-":
                if (!esNumero(val)) {
                    throw new DenviException.TipoIncompatible(ctx, "-", "ENTERO o DECIMAL", val.tipo);
                }
                if (val.tipo == Simbolo.TipoDato.ENTERO) {
                    int v = (Integer) val.valor;
                    if (v == Integer.MIN_VALUE) {
                        throw new DenviException.Desbordamiento(ctx, "-" + v);
                    }
                    return new Simbolo(Simbolo.TipoDato.ENTERO, -v);
                }
                return new Simbolo(Simbolo.TipoDato.DECIMAL, -(Double) val.valor);

            case "+":
                if (!esNumero(val)) {
                    throw new DenviException.TipoIncompatible(ctx, "+", "ENTERO o DECIMAL", val.tipo);
                }
                return val;

            default:
                throw new IllegalStateException("operador unario desconocido: " + op);
        }
    }

    // valp: base (.miembro)*   -> obj.&vida, obj.Metodo()
    @Override
    public Simbolo visitValp(ValpContext ctx) {
        Simbolo actual = visit(ctx.base());
        for (MiembroContext m : ctx.miembro()) {
            actual = aplicarMiembro(actual, m);
        }
        if (!ctx.miembro().isEmpty()) {
            exigirValor(ctx, actual, ctx.getText());
        }
        return actual;
    }

    @Override
    public Simbolo visitBase(BaseContext ctx) {
        if (ctx.valsimple() != null) {
            return visit(ctx.valsimple());
        }
        return visit(ctx.expresion());
    }

    // valsimple: valor | IDE | IDECON | IDEOBJ | ESTO | llamfun
    @Override
    public Simbolo visitValsimple(ValsimpleContext ctx) {
        if (ctx.valor() != null) {
            return visit(ctx.valor());
        }
        if (ctx.IDE() != null || ctx.IDECON() != null || ctx.IDEOBJ() != null) {
            return obtenerVariable(ctx, ctx.getStart().getText());
        }
        if (ctx.ESTO() != null) {
            return esto(ctx);
        }
        if (ctx.llamfun() != null) {
            Simbolo r = visit(ctx.llamfun());
            exigirValor(ctx, r, ctx.llamfun().IDEEST().getText());
            return r;
        }
        return null;
    }

    // ==================================================================
    // Literales
    // ==================================================================

    @Override
    public Simbolo visitValor(ValorContext ctx) {
        return crearValor(ctx, ctx.getText());
    }

    private Simbolo crearValor(ValorContext ctx, String t) {
        if (ctx.VAL_ENT() != null) {
            try {
                return new Simbolo(Simbolo.TipoDato.ENTERO, Integer.parseInt(t));
            } catch (NumberFormatException e) {
                throw new DenviException.LiteralFueraDeRango(ctx, t);
            }
        }
        if (ctx.VAL_DEC() != null) {
            return new Simbolo(Simbolo.TipoDato.DECIMAL, Double.parseDouble(t));
        }
        if (ctx.VAL_BOO() != null) {
            return new Simbolo(Simbolo.TipoDato.BOOLEANO, t.equals("verdadero"));
        }
        if (ctx.VAL_CAD() != null) {
            return new Simbolo(Simbolo.TipoDato.CADENA, desescapar(t.substring(1, t.length() - 1)));
        }
        if (ctx.VAL_CAR() != null) {
            String interior = desescapar(t.substring(1, t.length() - 1));
            if (interior.length() != 1) {
                throw new DenviException.LiteralFueraDeRango(ctx, t);
            }
            return new Simbolo(Simbolo.TipoDato.CARACTER, interior.charAt(0));
        }
        if (ctx.VAL_NL() != null) {
            return new Simbolo(Simbolo.TipoDato.NULO, null);
        }
        if (ctx.VAL_TM() != null) {
            try {
                return new Simbolo(Simbolo.TipoDato.TIEMPO, tiempoASegundos(t));
            } catch (NumberFormatException e) {
                throw new DenviException.LiteralFueraDeRango(ctx, t);
            }
        }
        return null;
    }

    private String desescapar(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '\\' && i + 1 < s.length()) {
                char n = s.charAt(++i);
                switch (n) {
                    case 'n': sb.append('\n'); break;
                    case 't': sb.append('\t'); break;
                    case 'r': sb.append('\r'); break;
                    default:  sb.append(n);    break;
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private Integer tiempoASegundos(String t) {
        String limpio = t.substring(1, t.length() - 1).replaceAll("\\s+", "");
        String[] partes = limpio.split(":", -1);
        if (partes.length != 2 && partes.length != 3) {
            throw new NumberFormatException("formato de tiempo invalido: " + t);
        }
        int[] n = new int[partes.length];
        for (int i = 0; i < partes.length; i++) {
            n[i] = partes[i].isEmpty() ? 0 : Integer.parseInt(partes[i]);
        }
        try {
            if (n.length == 2) {
                return Math.addExact(Math.multiplyExact(n[0], 60), n[1]);
            }
            return Math.addExact(
                    Math.addExact(Math.multiplyExact(n[0], 3600), Math.multiplyExact(n[1], 60)),
                    n[2]);
        } catch (ArithmeticException e) {
            throw new NumberFormatException("tiempo fuera de rango: " + t);
        }
    }
}