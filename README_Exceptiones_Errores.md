# Manejo de errores en DENVI: `DenviErrorListener` y `DenviException`

Estos dos archivos forman el **sistema de errores** del lenguaje. Su objetivo es que cualquier problema (carácter inválido, falta un `;`, variable sin declarar, división entre cero...) se reporte con:

- un **mensaje de error** con,
- la **línea y columna**,
- el **fragmento de código** con `^^^` bajo el problema,
- una **ayuda** para corregirlo,
- y una **traza estilo Java** (`at Clase.metodo(archivo:línea)`).

---

## 1. Visión general

```
 Código fuente
      │
      ▼
 denviLexer ──► error léxico ───┐
      │                         │   (ANTLR llama a syntaxError)
      ▼                         ▼
 denviParser ─► error sintáctico ──► DenviErrorListener ──► throw DenviException.ErrorLexico / ErrorSintactico
      │
      ▼
 denviCustomVisitor ──► error semántico ──► throw DenviException.<Subclase>
                                                    │
                                                    ▼
                        EjecutorService / EjecucionHandler / Main
                           └─► ErrorDto.de(e)  (JSON)   o   e.getMessage() (consola)
```

Todos los errores comparten la misma clase base, así que quien los atrapa solo necesita un `catch (DenviException e)`.

---

## 2. `DenviErrorListener`

```java
public class DenviErrorListener extends BaseErrorListener {
    public void syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine, String msg, RecognitionException e)
```

### Función principal
Reemplazar el comportamiento por defecto de ANTLR (imprimir el error en consola y seguir) por uno que **lanza una excepción** y detiene el análisis en el primer error.

### Cómo se usa
En todos los lugares donde se crea un lexer o parser (`EjecutorService.parsear`, `Main`, `cargarArchivo` del visitor):

```java
lexer.removeErrorListeners();
lexer.addErrorListener(new DenviErrorListener());
parser.removeErrorListeners();
parser.addErrorListener(new DenviErrorListener());
```

### Qué hace en cada caso

| Quién reportó | Qué lanza | Cómo obtiene el archivo y el código |
|---|---|---|
| **Lexer** | `ErrorLexico` | `cs = lexer.getInputStream()`; el archivo sale de `cs.getSourceName()`. |
| **Parser** | `ErrorSintactico` | `cs = parser.getInputStream().getTokenSource().getInputStream()`; el archivo sale del `TokenStream`. |

En ambos casos se encadena `.conCodigo(cs)`, que guarda el texto de la línea con el error para mostrarlo después con el `^`.

> Si el archivo no tiene nombre (código enviado como texto por la API), se muestra `<entrada>`.

---

## 3. `DenviException`

### 3.1 Qué es
Una `RuntimeException` (no obligatoria de declarar con `throws`) que es **la raíz de todos los errores del lenguaje**. Tiene tres familias de subclases: léxicos, sintácticos y semánticos.

### 3.2 Campos principales

| Campo | Contenido |
|---|---|
| `categoria` | Tipo de error en texto (`"Variable no declarada"`, `"Error sintactico"`...). |
| `detalle` | Descripción concreta del problema. |
| `linea`, `columna` | Posición del error. |
| `archivo` | Nombre del archivo (o `<entrada>`). |
| `lineaTexto` | Texto de la línea con el error (puede ser `null`). |
| `ancho` | Cuántos caracteres se subrayan con `^`. |
| `ayuda` | Sugerencia para corregir. |
| `pila` / `framesTotales` | Traza de llamadas (máximo `MAX_FRAMES = 12`). |
| `lineaSiguiente`, `archivoSiguiente` | Siguiente posición a registrar al subir por la pila. |

### 3.3 Constructores
- `(categoria, detalle, linea, columna, archivo)`: el básico. Arma el mensaje y **desactiva la traza de Java** (`super(msg, null, false, false)`), porque la traza relevante es la del lenguaje DENVI, no la de Java.
- `(categoria, detalle, linea, columna)`: usa `<entrada>` como archivo.
- `(categoria, detalle, ParserRuleContext ctx)`: **el que usan los errores semánticos**. Obtiene automáticamente línea, columna, archivo, texto de la línea y el ancho del subrayado a partir del contexto del árbol.

### 3.4 Código fuente con subrayado (`bloqueCodigo`)
Genera algo como:

```
    5 | &x(ent) := verdadero;
      |            ^^^^^^^^^
```

- Conserva los tabuladores al calcular el relleno, para que el `^` quede alineado.
- Limita el subrayado al largo real de la línea.

### 3.5 Traza estilo Java (`agregarFrame` y `traza`)
Cada vez que la excepción **sale** de una función o método, `ejecutarCuerpo` llama a `agregarFrame(nombre, ctxDeLaLlamada)`. Así se construye una pila como la de Java:

```
denvi.lang.TipoIncompatibleException: ...

  Error  : Tipos incompatibles
  Archivo: prueba.dnv
  Lugar  : linea 12, columna 4

    12 | ...
       | ^^^

  Causa  : ...
  Ayuda  : ...

	at Calculadora.sumar(prueba.dnv:12:4)
	at Principal.Main(prueba.dnv:30)
```

- Solo el **primer frame** muestra la columna.
- Si hay más de 12 frames, se muestra `... N more`.
- `traza()` arma todo el texto. `getMessage()` devuelve `Exception in thread "main" ` + la traza, por lo que `Main` solo necesita imprimir `e.getMessage()`.
- `printStackTrace(...)` también se sobrescribe para imprimir esa traza.
- `nombreJava()` genera el nombre simulado (`denvi.lang.XxxException`); `ErrorDenvi` lo sobrescribe como `denvi.lang.SemanticoException`.

### 3.6 Traducción de mensajes de ANTLR (inglés → DENVI)
ANTLR genera mensajes en inglés con nombres técnicos de tokens (`mismatched input 'x' expecting {CIER, PAR_A}`). La clase los convierte para el usuario:

| ANTLR | DENVI |
|---|---|
| `mismatched input X expecting Y` | `se encontro X, se esperaba Y` |
| `extraneous input X expecting Y` | `sobra X, se esperaba Y` |
| `missing X at Y` | `falta X antes de Y` |
| `no viable alternative at input X` | `no se reconoce la instruccion cerca de X` |
| `token recognition error at: X` | `caracter o texto no reconocido: X` |
| `<EOF>` | `el fin del archivo` |

- El mapa **`SIMBOLOS`** convierte los nombres internos de tokens a algo legible: `CIER` → `';'`, `IDE` → `variable (&nombre)`, `IDEEST` → `nombre con mayuscula inicial`, `VAL_ENT` → `entero`, etc.
- **Importante:** si agregas tokens nuevos a la gramática, añádelos a esta tabla para que los mensajes sigan siendo legibles. Si un token no está en el mapa, se muestra con su nombre interno.

---

## 4. Jerarquía de errores

```
RuntimeException
└── DenviException
    ├── ErrorLexico
    ├── ErrorSintactico
    └── Semantico
        ├── VariableNoDeclarada        
        ├── VariableNoInicializada     
        ├── ConstanteInmodificable     ├── ObjetoNulo
        ├── TipoIncompatible           ├── EstoInvalido
        ├── ClaseIncompatible          ├── RetornoInvalido
        ├── DivisionEntreCero          ├── SinValorDeRetorno
        ├── Desbordamiento             ├── DesbordamientoDePila
        ├── LiteralFueraDeRango        ├── ColeccionInvalida
        ├── NoSoportado                ├── EntradaInvalida
        ├── DeclaracionDuplicada       ├── ImportacionInvalida
        ├── SimboloNoEncontrado        ├── HerenciaInvalida
        ├── ClaseNoEncontrada          ├── NivelInvalido
        ├── MiembroNoEncontrado        ├── PortalInvalido
        ├── MiembroNoEncontrado        └── SucesoInvalido
```

Además, `denviCustomVisitor.ErrorDenvi` es un error semántico genérico.

### 4.1 Errores léxicos y sintácticos
| Clase | Cuándo ocurre |
|---|---|
| `ErrorLexico` | Símbolo inválido, cadena o carácter sin cerrar. |
| `ErrorSintactico` | Falta un `;`, un paréntesis o una llave; estructura mal formada. |

Ambos reciben el mensaje crudo de ANTLR y lo pasan por `traducir(...)`.

### 4.2 Errores semánticos (en ejecución)

| Clase | Se lanza cuando... |
|---|---|
| `VariableNoDeclarada` | Se usa una variable que no existe. |
| `VariableNoInicializada` | Se lee una variable declarada sin valor. | 
| `ConstanteInmodificable` | Se intenta cambiar una constante (`#x`). | assign to `final` |
| `TipoIncompatible` | Operación o asignación con tipos distintos (dos constructores: binario y "requiere tipo"). |
| `ClaseIncompatible` | Se pasa un objeto de una clase que no es la esperada ni hereda de ella. | 
| `DivisionEntreCero` | `/` o `%` con divisor 0. |
| `Desbordamiento` | Un `ent` sale del rango de 32 bits. | overflow |
| `LiteralFueraDeRango` | Literal que no cabe en su tipo (`ent` enorme, `car` con más de 1 carácter...). | 
| `NoSoportado` | Función aún no implementada. | 
| `DeclaracionDuplicada` | Variable, función, clase, método, nivel o parámetro repetido en el mismo ámbito. | 
| `SimboloNoEncontrado` | Se llama a una función o método inexistente. | 
| `ClaseNoEncontrada` | La clase no existe (¿falta el `Import`?). | 
| `MiembroNoEncontrado` | La clase no tiene ese atributo o método. | 
| `ArgumentosInvalidos` | Cantidad de argumentos incorrecta. | 
| `ObjetoNulo` | Se usa un objeto `nulo`. |
| `EstoInvalido` | `@esto` fuera de un método de clase. | 
| `RetornoInvalido` | `retornar` fuera de función/método o dentro de un `Suceso`. | 
| `SinValorDeRetorno` | Se usa como valor una llamada que no retorna nada. | 
| `DesbordamientoDePila` | Recursión mayor a 300 niveles. | 
| `ColeccionInvalida` | Una lista contiene otra colección. | 
| `EntradaInvalida` | El valor leído por `ObtDatos` no corresponde al tipo, o no hay más entrada. |
| `ImportacionInvalida` | Archivo no encontrado, ilegible o que no es de clases. | 
| `HerenciaInvalida` | Herencia circular. | 
| `NivelInvalido` | Nivel inexistente o sin nivel actual. | 
| `PortalInvalido` | `Viajar` sin portal entre los niveles. | 
| `SucesoInvalido` | Tipo de suceso fuera del catálogo (`Choque`, `Toma`, `Ingreso`, `Egreso`). | 

Cada clase llama a `ayuda(...)` en su constructor con una sugerencia concreta de cómo corregirlo.

---

## 5. Qué hace cada capa con el error

| Capa | Qué hace con la `DenviException` |
|---|---|
| `denviCustomVisitor.ejecutarCuerpo` | Agrega un frame a la traza (`agregarFrame`) y la relanza. |
| `denviCustomVisitor.visitProg` | Agrega el frame `Principal.Main`. |
| `EjecutorService.ejecutar` | La atrapa y devuelve `RespuestaEjecucion.fallo(salida, ErrorDto.de(e))`. |
| `EjecucionHandler.correr` | La manda por WebSocket como `{"tipo":"error","error":{...}}`. |
| `Main` | Imprime `e.getMessage()` en `System.err`. |

`ErrorDto.de(e)` copia: `categoria`, `detalle`, `ayuda`, `linea`, `columna`, `archivo` y `traza()`, que es justo lo que el front necesita para mostrar el error y resaltar la línea.

---

## 6. Cómo agregar un nuevo error semántico

1. Crea una subclase dentro de `DenviException`:

```java
public static class MiNuevoError extends Semantico {
    public MiNuevoError(ParserRuleContext ctx, String detalle) {
        super("Mi categoria", detalle, ctx);
        ayuda("Cómo se corrige.");
    }
}
```

2. Lánzala desde el visitor: `throw new DenviException.MiNuevoError(ctx, "...");`
3. No necesitas tocar el controlador, el servicio ni el WebSocket: ya manejan cualquier `DenviException`.

---
