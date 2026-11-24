grammar denvi;

/* ---------------------------------------------------------
   REGLAS SINTACTICAS
   --------------------------------------------------------- */

// Regla de entrada: acepta ambos tipos de archivo
archivo: archprin | archclase;

// Archivo ejecutable: imports opcionales + una clase principal
archprin: importar* clasprin EOF;
// Archivo de clases: imports opcionales + una o mas clases
archclase: importar* escclase+ EOF;

// -- Importaciones --
importar: (importext | importint) CIER;
importext: IMPORTAR VAL_CAD;
importint: IMPORTAR IMPORTINT;

// -- Clases, metodos y funciones --
// Clase principal: metodos opcionales y luego el programa
clasprin: ESQUELETO PRINCIPAL CONEE LLA_A escmetodo* prog LLA_C CIER;

// Programa: IGNOR; solo, o instrucciones y funciones (no vacio)
prog: IGNOR CIER | (lincod | escfuncion)+;

// Clase normal; los parametros son sus atributos
escclase: ESQUELETO IDEEST (CONEE OBTIENEDE IDEEST)? CONEE PAR_A decparam? PAR_C esccuerpo CIER;

// Cuerpo de clase: solo metodos, o solo IGNOR;
esccuerpo: LLA_A (IGNOR CIER | escmetodo+) LLA_C;

// Metodo: puede contener funciones
escmetodo: METAACCION IDEEST CONEE PAR_A decparam? PAR_C cuerpometodo CIER;
cuerpometodo: LLA_A (IGNOR CIER | (lincod | escfuncion)+) LLA_C;

// Funcion: solo instrucciones (no anida funciones)
escfuncion: ACCION IDEEST CONEE PAR_A decparam? PAR_C cuerpofuncion CIER;
cuerpofuncion: LLA_A (IGNOR CIER | lincod+) LLA_C;

// Retorno: (valor).retornar
escretor: PAR_A dato? PAR_C PUNTO RETORNAR;

// Parametros (sin valor inicial, sin constantes)
parametro: IDE PAR_A tipo PAR_C | AR IDE PAR_A tipo PAR_C | LT IDE PAR_A tipo PAR_C | IDEEST IDEOBJ; // parametro de tipo objeto
decparam: parametro (COMA parametro)*;
recparam: dato (COMA dato)*; // argumentos de una llamada

// -- Objetos y llamadas --
declaobj: IDEEST IDEOBJ ASIG INICIAR PAR_A recparam? PAR_C;
llamfun: IDEEST PAR_A recparam? PAR_C;
accmiem: (IDEOBJ | ESTO) (PUNTO IDE)+; // destino de asignacion
accmet: (IDEOBJ | ESTO | llamfun) (PUNTO miembro)* PUNTO IDEEST PAR_A recparam? PAR_C;
miembro: IDE | IDECON | IDEEST PAR_A recparam? PAR_C;
llamada: llamfun | accmet;

// -- Instrucciones --
// linin: instruccion SIN ';' (para usarse dentro de otras estructuras)
linin: declaracion | asignacion | constante | decar | declt | declaobj | decla_glob | asig_glob | impcons | impconssl | obtdatos | llamada | escretor | escond | esrep | escsuceso | escnivel | conexion | situar | retirar | viajar;

// lincod: instruccion completa, siempre termina en ';'
lincod: linin CIER;

// -- Declaraciones y asignaciones --
declaracion
    : IDE PAR_A tipo PAR_C                       #DeclaracionSimple
    | IDE PAR_A tipo PAR_C ASIG expresion        #DeclaracionAsig
    ;

asignacion
    : IDE ASIG (dato | autoinc)                  #AsigVar
    | accmiem ASIG (dato | autoinc)              #AsigMiembro
    ;

decla_glob: MUNDO (declaracion | constante | decar | declt | declaobj);
asig_glob: MUNDO asignacion;
constante: IDECON PAR_A tipo PAR_C ASIG expresion;

tipo: ENT | DEC | CAD | CAR | BOO | TM | NL;
valor: VAL_ENT | VAL_DEC | VAL_CAD | VAL_CAR | VAL_BOO | VAL_TM | VAL_NL;
dato: arreglo | lista | expresion;

// Arreglo: corchetes, puede anidarse
decar: AR ( IDE PAR_A tipo PAR_C (ASIG arreglo)? | IDECON PAR_A tipo PAR_C ASIG arreglo );
arreglo: COR_A (cont_arr (COMA cont_arr)*)? COR_C;
cont_arr: valor | IDE | IDECON | arreglo;

// Lista: llaves, no se anida
declt: LT ( IDE PAR_A tipo PAR_C (ASIG lista)? | IDECON PAR_A tipo PAR_C ASIG lista );
lista: LLA_A ((valor | IDE | IDECON) (COMA (valor | IDE | IDECON))*)? LLA_C;

// Condicion + cuerpo, una por estructura (antes "contcon")
contev:    PAR_A expresion PAR_C OP_COND cuerpoev;
contevalt: PAR_A expresion PAR_C OP_COND cuerpoevalt;
contrep:   PAR_A expresion PAR_C OP_COND cuerporep;

// -- Decision (3 caminos) y repeticion --
cuerpo: LLA_A (IGNOR CIER | lincod*) LLA_C;
contcon: PAR_A expresion PAR_C OP_COND cuerpo;

// -- Cuerpos: uno por estructura (antes todos usaban "cuerpo") --
cuerpoev:      LLA_A (IGNOR CIER | lincod*) LLA_C;   // ev
cuerpoevalt:   LLA_A (IGNOR CIER | lincod*) LLA_C;   // evalt
cuerpoalt:     LLA_A (IGNOR CIER | lincod*) LLA_C;   // alt
cuerporep:     LLA_A (IGNOR CIER | lincod*) LLA_C;   // rep
cuerposuceso:  LLA_A (IGNOR CIER | lincod*) LLA_C;   // Suceso

// ev, evalt, alt
escond: EVALUAR PAR_A contev (CONEG ALTERNO contevalt)* (CONEG ALTERNATIVA cuerpoalt)? PAR_C;

// rep: con declaracion el incremento puede omitir la variable
esrep
    : REPETICION PAR_A PAR_A declaracion PAR_C CONEG contrep DOB_P incre PAR_C                    #RepDeclaracion
    | REPETICION PAR_A PAR_A (asignacion | IDE) PAR_C CONEG contrep DOB_P increesp PAR_C          #RepAsignacion
    ;
autoinc
    : (INCS | DECS)                              #AutoIncSimple
    | (INCV | DECV) PAR_A paso PAR_C             #AutoIncPaso
    ;
incre: autoinc | increesp;
increesp: (INCS | DECS) PAR_A IDE PAR_C | (INCV | DECV) PAR_A paso COMA IDE PAR_C;
paso: valor | IDE | IDECON;

// -- Entrada / Salida --
impcons: IMPCONS PAR_A imprimible (CONEG imprimible)* PAR_C;
impconssl: IMPCONSSL PAR_A imprimible (CONEG imprimible)* PAR_C;
imprimible: dato;
obtdatos: OBTDATOS PAR_A tipo DOB_P IDE PAR_C;

// -- Eventos y escenarios --
// Forma corta (objeto, Tipo) o forma general (condicion)
// Suceso: solo cambia "cuerpo" por "cuerposuceso"
escsuceso: SUCESO PAR_A PAR_A (IDEOBJ COMA IDEEST | expresion) PAR_C CONEG cuerposuceso PAR_C;

escnivel: NIVEL IDEEST CONEG PAR_A propiedades cuerponivel PAR_C enlace?;
propiedades: PAR_A (propiedad (COMA propiedad)*)? PAR_C;
propiedad: declaracion | constante;
cuerponivel: LLA_A (IGNOR CIER | subzona (COMA subzona)* | lincod*) LLA_C;
subzona: ZONA IDEEST CONEG PAR_A propiedades cuerponivel PAR_C;
enlace: PUNTO PORTAL CONEE destino;
conexion: IDEEST enlace;
destino: IDEEST | PAR_A IDEEST (COMA IDEEST)* PAR_C;

situar: SITUAR PAR_A IDEOBJ CONEG PAR_A expresion COMA expresion PAR_C (CONEG IDEEST)? PAR_C;
retirar: RETIRAR PAR_A IDEOBJ PAR_C;
viajar: VIAJAR PAR_A IDEEST PAR_C;

// -- Expresiones (menor a mayor precedencia) --
expresion: logor; // punto de entrada
logor: logand (OR logand)*; // nivel 1: ||
logand: logig (AND logig)*; // nivel 2: ^
logig: logrel ((COMP | DIF) logrel)*; // nivel 3: == !=
logrel: logar ((MEN_Q | MA_Q | MEN_IG | MA_IG) logar)*; // nivel 4: < > =< =>
logar: termino ((OP_SUM | OP_REST) termino)*; // nivel 5: + -
termino: simbun ((OP_MULT | OP_DIV | OP_MOD) simbun)*; // nivel 6: * / %
simbun: (NOT | OP_REST | OP_SUM) simbun | valp; // nivel 7: unarios
valp: base (PUNTO miembro)*; // nivel 8: accesos con punto
base: valsimple | PAR_A expresion PAR_C;
valsimple: valor | IDE | IDECON | IDEOBJ | ESTO | llamfun;


/* ---------------------------------------------------------
   REGLAS LEXICAS
   --------------------------------------------------------- */

// -- Palabras reservadas --
MUNDO: 'Mundo';
ACCION: 'Accion';
METAACCION: 'MetaAccion';
PRINCIPAL: 'Principal';
ESQUELETO: 'Esqueleto';
RETORNAR: 'retornar';
IGNOR: 'IGNOR';
OBTIENEDE: 'ObtieneDe';
INICIAR: 'iniciar';
ESTO: '@esto';
SUCESO: 'Suceso';
NIVEL: 'Nivel';
ZONA: 'Zona';
PORTAL: 'Portal';
SITUAR: 'Situar';
RETIRAR: 'Retirar';
VIAJAR: 'Viajar';
IMPORTAR: 'Import';
IMPCONS: 'ImpCons';
IMPCONSSL: 'ImpConsSl';
OBTDATOS: 'ObtDatos';

// -- Tipos y estructuras de datos --
ENT: 'ent';
DEC: 'dec';
CAD: 'cad';
CAR: 'car';
BOO: 'boo';
TM: 'tm';
NL: 'nl';
LT: 'lt';
AR: 'ar';

// -- Decision y repeticion --
EVALUAR: 'ev';
ALTERNO: 'evalt';
ALTERNATIVA: 'alt';
REPETICION: 'rep';

// -- Valores (literales) --
VAL_BOO: 'verdadero' | 'falso';
VAL_NL: 'nulo';
VAL_DEC: ('0' | [1-9][0-9]*) '.' [0-9]+;
VAL_ENT: '0' | [1-9][0-9]*;
VAL_CAD: '"' ( '\\' . | ~["\\] )* '"';
VAL_CAR: '\'' ~['\\\r\n] '\'';

// Tiempo: [min:seg] | [h:min:seg] | [::seg] | [min:] ... (siempre entre corchetes)
VAL_TM: '[' E ( MS E ':' E MS?
            | ':' E MS
            | H E ':' E MS E ':' E MS?
            | H E ':' E ':' E MS?
            | ':' E MS E ':' E MS?
            | ':' E ':' E MS
            ) E ']';
fragment E: [ \t]*; // espacios opcionales
fragment MS: '0' | [1-5][0-9] | [1-9]; // 0 a 59 sin ceros a la izquierda
fragment H: '0' | [1-9][0-9]*; // horas sin limite

// -- Importacion interna --
IMPORTINT: [A-Za-z_][A-Za-z0-9_]* '.clase.dnv';

// -- Operadores y conectores --
CONEE: '-->';
CONEG: '->';
INCS: '++';
DECS: '--';
INCV: '+?';
DECV: '-?';
ASIG: ':=';
MA_IG: '=>';
MEN_IG: '=<';
COMP: '==';
DIF: '!=';
OR: '||';
AND: '^';
NOT: '!';
MA_Q: '>';
MEN_Q: '<';
OP_SUM: '+';
OP_REST: '-';
OP_MULT: '*';
OP_DIV: '/';
OP_MOD: '%';
OP_COND: '?';

// -- Delimitadores --
PAR_A: '(';
PAR_C: ')';
COR_A: '[';
COR_C: ']';
LLA_A: '{';
LLA_C: '}';
CIER: ';';
COMA: ',';
PUNTO: '.';
DOB_P: ':';

// -- Identificadores --
IDE: '&' [a-z][a-zA-Z0-9]*; // variable o atributo
IDECON: '#' [a-z][a-zA-Z0-9]*; // constante
IDEEST: [A-Z][a-zA-Z0-9]*; // clase, metodo, funcion, nivel, tipo de suceso
IDEOBJ: [a-z][a-z0-9]*; // objeto

// ---- Comentarios y espacios (se ignoran) ----
COM_BLO: '::*' .*? '*::' -> skip;
COM_SIM: ':::' ~[\r\n]* -> skip;
WS: [ \t\r\n\f]+ -> skip;