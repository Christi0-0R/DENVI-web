# Denvi: adiciones a la documentación (imprimir, declaraciones, trazas)


| Bloque | Qué hacer en tu documento |
|---|---|
| A. Imports nuevos | Agregar al final de la tabla de la sección 4.9.1 |
| B. `tablaSimbolos` | Reemplazar la fila de `tablaSimbolos` en la tabla de la sección 4.2 |
| C. `desdeToken` | Reemplazar el último párrafo de la sección 2.3 («Todavía no se usa…») |
| D. Variable sin valor | Agregar al final de la sección 2.6 |
| E. Secciones 4.9.24, 4.9.25 y 4.9.26 | Insertar **antes** de la actual 4.9.24 |
| F. Secciones 4.9.27 y 4.9.28 | Reemplazan a las actuales 4.9.24 (reglas no sobrescritas) y 4.9.25 (mapa de llamadas), que pasan a ser 4.9.27 y 4.9.28 |
| G. Ejemplos nuevos | Agregar filas a la tabla de la sección 4.10 |
| H. Sección 4.11 y 4.12 | Insertar después de la sección 4.10 (trazas y cómo se ejecuta) |
| I. Tabla de la sección 5 | Agregar filas |
| J. Tabla de la sección 6 | Reemplazar completa |

---

## A. Imports nuevos (sección 4.9.1)

Agregar estas filas a la tabla de imports:

| Import | Para qué se usa |
|---|---|
| `java.util.List` | `construirSalida` recibe la lista de argumentos de un `ImpCons` o `ImpConsSl`. |
| `denviParser.ImpconsContext` | Parámetro de `visitImpcons`. |
| `denviParser.ImpconsslContext` | Parámetro de `visitImpconssl`. |
| `denviParser.ImprimibleContext` | Parámetro de `visitImprimible` y tipo de los elementos de la lista de `construirSalida`. |
| `denviParser.DeclaracionSimpleContext` | Parámetro de `visitDeclaracionSimple`. |
| `denviParser.DeclaracionAsigContext` | Parámetro de `visitDeclaracionAsig`. |

---

## B. `tablaSimbolos` (sección 4.2)

Nueva fila para la tabla:

| Elemento | Qué guarda | Por qué así |
|---|---|---|
| Tabla de símbolos | Variables, constantes y objetos. La clave es el texto exacto con su prefijo (`&x`, `#pi`). | Es una sola tabla plana, sin ámbitos todavía. Que la clave incluya el prefijo evita choques: `&x` y `#x` son cosas distintas. **Se llena en `visitDeclaracionSimple` y `visitDeclaracionAsig` y se lee en `visitValsimple`.** |

---

## C. `desdeToken` (sección 2.3)

Reemplazar el párrafo «Todavía no se usa en ningún lado» por:

> **Ahora lo usan las declaraciones.** `visitDeclaracionSimple` y `visitDeclaracionAsig` toman el texto de la regla `tipo` (por ejemplo `ent`), se lo pasan a `desdeToken` y obtienen el tipo con el que crear el símbolo. Como la regla `tipo` de la gramática solo admite `ent`, `dec`, `cad`, `car`, `boo`, `tm` y `nl`, en este punto `desdeToken` nunca devuelve «nada».

---

## D. Variable sin valor (sección 2.6)

Agregar al final:

> Esta situación ya se puede producir desde código Denvi: `&x(ent);` ejecuta `visitDeclaracionSimple`, que guarda `&x` con tipo ENTERO y valor vacío. Si después se escribe `ImpConsSl(&x);`, `visitValsimple` detecta la combinación y lanza «variable no inicializada». En cambio `&n(nl);` sí se puede leer, porque su tipo es NULO.

---

## E. Secciones nuevas (insertar antes de 4.9.24)

### 4.9.24 `visitLincod`

- **Regla:** `lincod : linin CIER`
- **Quién lo llama:** `visitProg`, en el segundo bucle, una vez por cada instrucción del programa.
- **Entra con:** el nodo de una instrucción completa, es decir, la instrucción más su `;`.
- **Llama a:** `visit(ctx.linin())`, que a su vez despacha a la instrucción concreta (imprimir, declaración, etc.).
- **Devuelve:** el resultado de la instrucción (hoy casi siempre `null`).

```java
@Override
public Simbolo visitLincod(LincodContext ctx) {
    return visit(ctx.linin());
}
```

1. `ctx.linin()` es el hijo que contiene la instrucción sin el punto y coma. En la gramática, `linin` es una lista de alternativas (`declaracion | asignacion | ... | impcons | impconssl | ...`).
2. `visit` sobre ese hijo ejecuta `visitLinin`, que **no está sobrescrito**: ANTLR usa el comportamiento por defecto y visita a su único hijo, que es el nodo de la instrucción real. Por eso, para una instrucción `ImpCons(...)`, la cadena de llamadas es `visitLincod → visitLinin (por defecto) → visitImpcons`.

*Por qué se sobrescribe:* sin este método, ANTLR visitaría **los dos hijos** de `lincod` (la instrucción y el token `;`) y se quedaría con el resultado del último, que es el del `;`, o sea `null`. El valor de la instrucción se perdería. Con la sobrescritura se visita solo `linin` y se conserva su resultado, de modo que `visitProg` puede devolver el resultado de la última instrucción tal como describe la sección 4.9.3.

### 4.9.25 Imprimir: `visitImpcons`, `visitImpconssl`, `construirSalida` y `visitImprimible`

Las dos instrucciones de salida comparten casi todo, así que se explican juntas.

- **Reglas:**
  - `impcons : IMPCONS PAR_A imprimible (CONEG imprimible)* PAR_C`
  - `impconssl : IMPCONSSL PAR_A imprimible (CONEG imprimible)* PAR_C`
  - `imprimible : dato`
  - `dato : arreglo | lista | expresion`
- **Palabras reservadas:** `ImpCons` (imprime **sin** salto de línea) e `ImpConsSl` (imprime **con** salto de línea; la «Sl» es «salto de línea»).
- **Separador de argumentos:** `->` (el token `CONEG`). Se puede imprimir más de un valor en la misma instrucción: `ImpConsSl("a" -> "b" -> "c")` imprime `abc`.

#### `visitImpcons`

- **Quién lo llama:** `visitLinin` por defecto, cuando la instrucción es `ImpCons(...)`.
- **Entra con:** el nodo de la instrucción, con su lista de argumentos.
- **Llama a:** `construirSalida(ctx.imprimible())`.
- **Devuelve:** `null`, porque imprimir no produce ningún valor.

```java
@Override
public Simbolo visitImpcons(ImpconsContext ctx) {
    System.out.print(construirSalida(ctx.imprimible()));
    return null;
}
```

1. `ctx.imprimible()` es la **lista** de todos los argumentos (uno por cada `imprimible` entre los paréntesis).
2. `construirSalida` los evalúa y devuelve un único texto con todos pegados.
3. `System.out.print` escribe ese texto **sin** agregar salto de línea, así que la siguiente salida continúa en la misma línea. Por eso varias instrucciones `ImpCons` seguidas salen pegadas (`15550220…`), y para probar conviene usar `ImpConsSl`.

#### `visitImpconssl`

Idéntico al anterior, con una sola diferencia:

```java
@Override
public Simbolo visitImpconssl(ImpconsslContext ctx) {
    System.out.println(construirSalida(ctx.imprimible()));
    return null;
}
```

`System.out.println` agrega el salto de línea al final. Si quisieras que `ImpCons` y `ImpConsSl` tuvieran el comportamiento contrario, bastaría intercambiar `print` y `println`.

#### `construirSalida`

- **Quién lo llama:** `visitImpcons` y `visitImpconssl`.
- **Entra con:** la lista de argumentos (`List<ImprimibleContext>`).
- **Llama a:** `visit(item)` por cada argumento (→ `visitImprimible`) y `texto(...)` para convertir cada resultado en texto.
- **Devuelve:** un `String` con todos los argumentos concatenados, sin separador entre ellos.

```java
private String construirSalida(List<ImprimibleContext> items) {
    StringBuilder sb = new StringBuilder();
    for (ImprimibleContext item : items) {
        sb.append(texto(visit(item)));
    }
    return sb.toString();
}
```

1. `StringBuilder` acumula el texto de forma eficiente.
2. Por cada argumento, `visit(item)` lo evalúa y devuelve un `Simbolo`. `texto(...)` (sección 4.9.8) lo convierte a su forma escrita: `verdadero`/`falso` para booleanos, `nulo` para el nulo y el valor tal cual para el resto.
3. Se anexa al acumulado y al final se devuelve todo junto.

*Detalles de formato al imprimir:* un tiempo sale como su total de segundos (`[1:30]` imprime `90`), un carácter sale como la letra, y un decimal sale con el formato de Java (`3.5`, y `1.0E10` para números muy grandes).

#### `visitImprimible`

- **Quién lo llama:** `construirSalida`, mediante `visit(item)`.
- **Entra con:** el nodo de un argumento.
- **Llama a:** `visit(ctx.dato().expresion())`, el punto de entrada de las expresiones.
- **Devuelve:** el `Simbolo` resultante de la expresión.

```java
@Override
public Simbolo visitImprimible(ImprimibleContext ctx) {
    if (ctx.dato().expresion() == null) {
        throw new DenviException.NoSoportado(ctx, "imprimir arreglos o listas");
    }
    return visit(ctx.dato().expresion());
}
```

1. `ctx.dato()` es el nodo de la regla `dato`. Esa regla tiene tres alternativas y `ctx.dato().expresion()` solo es distinto de `null` cuando se usó la tercera.
2. Si es `null`, el argumento era un arreglo (`[...]`) o una lista (`{...}`), que todavía no existen en el intérprete: lanza «no soportado».
3. Si es una expresión, se visita. De ahí en adelante todo funciona como en las secciones 4.9.10 a 4.9.21: la expresión baja por la escalera de precedencia y regresa un símbolo.

*Por qué se sobrescribe:* sin este método, la visita por defecto devolvería el resultado de `dato`, que a su vez visitaría a `expresion`; funcionaría para expresiones, pero un arreglo o una lista darían un resultado confuso en lugar de un error claro.

### 4.9.26 Declaraciones: `visitDeclaracionSimple` y `visitDeclaracionAsig`

- **Regla (con etiquetas):**

```
declaracion
    : IDE PAR_A tipo PAR_C                       #DeclaracionSimple
    | IDE PAR_A tipo PAR_C ASIG expresion        #DeclaracionAsig
    ;
```

- **Por qué hay dos métodos:** las etiquetas `#DeclaracionSimple` y `#DeclaracionAsig` hacen que ANTLR genere **un nodo y un método de visita por cada alternativa**, y que **no** genere `visitDeclaracion`. Por eso se sobrescriben `visitDeclaracionSimple` y `visitDeclaracionAsig`, y los parámetros son `DeclaracionSimpleContext` y `DeclaracionAsigContext`.
- **Ejemplos en Denvi:** `&a(ent);` (sin valor) y `&a(ent) := 10;` (con valor).
- **Quién los llama:** `visitLinin` por defecto, cuando la instrucción es una declaración.

#### `visitDeclaracionSimple`

- **Entra con:** el nodo de una declaración sin valor inicial.
- **Llama a:** `Simbolo.desdeToken` para traducir el tipo.
- **Devuelve:** `null` (declarar no produce un valor).

```java
@Override
public Simbolo visitDeclaracionSimple(DeclaracionSimpleContext ctx) {
    String nombre = ctx.IDE().getText();
    Simbolo.TipoDato tipo = Simbolo.desdeToken(ctx.tipo().getText());
    tablaSimbolos.put(nombre, new Simbolo(tipo, null));
    return null;
}
```

1. `ctx.IDE().getText()` es el nombre **con prefijo** (`&a`), que es la clave de la tabla.
2. `ctx.tipo().getText()` es la palabra del tipo (`ent`, `dec`…). `desdeToken` la convierte al enumerado `TipoDato` (sección 2.3).
3. `new Simbolo(tipo, null)` crea el símbolo con el tipo pedido y **valor vacío**. Esta es justo la situación de la sección 2.6: declarada pero sin valor. Si alguien la lee antes de asignarle algo, `visitValsimple` lanza «variable no inicializada».
4. `put` la guarda en la tabla. Si el nombre ya existía, **se sobrescribe sin avisar** (todavía no se comprueba la redeclaración).

#### `visitDeclaracionAsig`

- **Entra con:** el nodo de una declaración con valor inicial.
- **Llama a:** `Simbolo.desdeToken`, `visit(ctx.expresion())` y `texto`.
- **Devuelve:** `null`.

```java
@Override
public Simbolo visitDeclaracionAsig(DeclaracionAsigContext ctx) {
    String nombre = ctx.IDE().getText();
    Simbolo.TipoDato tipo = Simbolo.desdeToken(ctx.tipo().getText());

    Simbolo val = visit(ctx.expresion());

    // un entero se puede guardar en un decimal
    if (tipo == Simbolo.TipoDato.DECIMAL && val.tipo == Simbolo.TipoDato.ENTERO) {
        val = new Simbolo(Simbolo.TipoDato.DECIMAL, ((Integer) val.valor).doubleValue());
    }
    if (val.tipo != tipo) {
        throw new DenviException.TipoIncompatible(ctx, ":=", tipo, val.tipo);
    }

    tablaSimbolos.put(nombre, new Simbolo(tipo, val.valor));
    return null;
}
```

1. Lee el nombre y el tipo igual que la versión simple.
2. **Evalúa la expresión antes de guardar nada.** `visit(ctx.expresion())` resuelve el lado derecho. Esto tiene una consecuencia útil: en `&a(ent) := &a + 1;`, cuando se evalúa `&a + 1` la variable todavía no existe en la tabla, así que se lanza «variable no declarada», que es lo correcto.
3. **Promoción de entero a decimal.** Si se declara `dec` y el valor es un entero, se convierte a decimal (`&d(dec) := 5;` guarda `5.0`). La conversión inversa no existe: `&e(ent) := 5.0;` es un error.
4. **Validación de tipo.** Si el tipo del valor no coincide con el declarado, lanza `TipoIncompatible` con la primera forma (dos tipos que chocan); el mensaje queda `ENTERO := DECIMAL`. Esto también cubre `&c(cad) := 5;` y `&b(boo) := 1;`.
5. **Se guarda una copia nueva.** `new Simbolo(tipo, val.valor)` crea un símbolo propio en lugar de guardar el que devolvió la expresión. Así, si la expresión era solo otra variable (`&b(ent) := &a;`), `&a` y `&b` no comparten el mismo objeto y una futura asignación a una no modificaría a la otra.
6. `&n(nl) := nulo;` también funciona: el tipo del valor es NULO, coincide con el declarado y se guarda con valor vacío, lo cual es legítimo para ese tipo.

Con estos dos métodos se cierra el ciclo que antes estaba incompleto: la declaración **escribe** en `tablaSimbolos` y `visitValsimple` la **lee**.


### 4.9.28 Mapa de llamadas

```
visit(arbol)
└── visitArchivo → visitArchprin → visitClasprin      (por defecto)
    └── visitProg
        ├── visitEscfuncion                           (1ª pasada)
        └── visitLincod                               (2ª pasada, una por instrucción)
            └── visitLinin                            (por defecto)
                ├── visitDeclaracionSimple
                ├── visitDeclaracionAsig ───────────┐
                └── visitImpcons / visitImpconssl   │
                    └── construirSalida             │
                        └── visitImprimible         │
                            └── visitExpresion  ◄───┘  (entrada de toda expresión)
                                └── visitLogor
                                    └── visitLogand
                                        └── visitLogig
                                            └── visitLogrel
                                                └── visitLogar
                                                    └── visitTermino
                                                        └── visitSimbun  ⟲ (cada unario)
                                                            └── visitValp
                                                                └── visitBase
                                                                    ├── visitValsimple
                                                                    │   ├── visitValor
                                                                    │   │   ├── desescapar
                                                                    │   │   └── tiempoASegundos
                                                                    │   └── tablaSimbolos.get(...)
                                                                    └── visitExpresion  ⟲ (paréntesis)
```

## H. Secciones nuevas 4.11 y 4.12

### 4.11 Mensajes de seguimiento (trazas)

Para entender qué ocurre durante la ejecución, el visitor puede imprimir una línea cada vez que entra a una parte importante. Son `System.out.println` simples, cada uno con una **etiqueta entre corchetes** que indica de qué parte viene:

| Etiqueta | Dónde se imprime | Qué dice |
|---|---|---|
| `[PROG]` | `visitProg` | Inicia y termina el programa. |
| `[FUNCION]` | `visitEscfuncion` | Qué función se registra. |
| `[INSTRUCCION]` | `visitLincod` | El texto de la instrucción que se va a ejecutar. |
| `[DECLARACION]` | `visitDeclaracionSimple`, `visitDeclaracionAsig` | Qué variable se declara, su tipo y el valor guardado. |
| `[IMPRIMIR]` | `visitImpcons`, `visitImpconssl` | Que se entró a imprimir y de qué tipo. |
| `[EXPRESION]` | `visitExpresion` | El texto de la expresión que se evalúa. |
| `[OR]`, `[AND]` | `visitLogor`, `visitLogand` | Operandos, resultado y si hubo cortocircuito. |
| `[IGUALDAD]` | `visitLogig` | La comparación `==` o `!=` y su resultado. |
| `[RELACIONAL]` | `visitLogrel` | La comparación `<`, `>`, `=<`, `=>` y su resultado. |
| `[SUMA]`, `[RESTA]` | `visitLogar` | La operación con sus operandos y el resultado, indicando si fue entera o decimal. |
| `[CONCATENACION]` | `visitLogar` | Las dos partes unidas y el texto resultante. |
| `[MULTIPLICACION]`, `[DIVISION]`, `[MODULO]` | `visitTermino` | La operación, el resultado, y el aviso si el divisor es cero. |
| `[UNARIO]` | `visitSimbun` | El operador unario aplicado y su resultado. |
| `[PARENTESIS]` | `visitBase` | Que se entró a una expresión entre paréntesis. |
| `[VARIABLE]` | `visitValsimple` | Qué variable se recupera de la tabla y cuánto vale. |
| `[VALOR]` | `visitValor` | Qué literal se leyó y de qué tipo. |


```
[INSTRUCCION] Se ejecuta: ImpConsSl("2 + 3 * 4 = "+(2+3*4))
[IMPRIMIR] Se entro a ImpConsSl (con salto de linea)
[EXPRESION] Se evalua: "2 + 3 * 4 = "+(2+3*4)
[VALOR] Se lee el literal "2 + 3 * 4 = " (tipo CADENA)
[PARENTESIS] Se entro a una expresion entre parentesis: (2+3*4)
[EXPRESION] Se evalua: 2+3*4
[VALOR] Se lee el literal 2 (tipo ENTERO)
[VALOR] Se lee el literal 3 (tipo ENTERO)
[VALOR] Se lee el literal 4 (tipo ENTERO)
[MULTIPLICACION] Se entro a una operacion de multiplicacion (*)
[MULTIPLICACION] (entero) 3 * 4 -> el resultado es: 12
[SUMA] Se entro a una suma (+)
[SUMA] (entero) 2 + 12 -> el resultado es: 14
[CONCATENACION] Se entro a una concatenacion: "2 + 3 * 4 = " + "14" -> el resultado es: "2 + 3 * 4 = 14"
2 + 3 * 4 = 14
```

Se lee de arriba hacia abajo siguiendo el recorrido de la sección 4.3: primero se entra, luego se leen los literales y las operaciones suben el resultado, y la última línea (sin etiqueta) es la salida real del programa.


## I. Tabla de la sección 5 (filas nuevas)

| Pieza | Razón de ser |
|---|---|
| `visitLincod` sobrescrito | Conservar el resultado de la instrucción en lugar de perderlo con el del `;`. |
| `visitImpcons` / `visitImpconssl` | Dar salida por consola al lenguaje, con y sin salto de línea. |
| `construirSalida` | Evaluar y concatenar los argumentos separados por `->` una sola vez, para ambas instrucciones. |
| `visitImprimible` | Aceptar solo expresiones y dar un error claro con arreglos y listas, que aún no existen. |
| `visitDeclaracionSimple` | Crear variables sin valor, que luego dan «no inicializada» al leerse. |
| `visitDeclaracionAsig` | Crear variables con valor, validando el tipo y permitiendo entero a decimal. |
| Trazas con etiqueta | Ver en consola qué parte del intérprete se ejecuta y con qué valores. |

---
