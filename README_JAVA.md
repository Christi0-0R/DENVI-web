# Cómo funciona DENVI por dentro: guía de los archivos Java

## 1. Lo primero: ¿qué es DENVI?

DENVI es un **lenguaje de programación propio**. Tiene sus palabras clave en español (`Esqueleto Principal`, `MetaAccion`, `Nivel`, `Suceso`, `ev`, `rep`...) y, como cualquier lenguaje, necesita **algo que lo entienda y lo ejecute**. Ese "algo" es lo que está en estos archivos Java: un **intérprete**.

Un intérprete hace tres cosas, siempre en este orden:

1. **Leer** el texto del programa y revisar que esté bien escrito (¿falta un `;`? ¿hay un símbolo raro?). Esto lo hace **ANTLR** con la gramática del lenguaje.
2. **Entenderlo**, es decir, convertir el texto en un **árbol** que representa su estructura.
3. **Ejecutarlo**, recorriendo ese árbol y haciendo lo que cada instrucción pide. Esto lo hace `denviCustomVisitor`.

Y encima de ese intérprete, el proyecto le agrega una **capa web** (Spring Boot) para que alguien pueda escribir código DENVI en un editor en el navegador, darle "Ejecutar" y ver el resultado, como en un playground en línea.

Entonces el proyecto tiene en realidad **dos mitades**:

| Partes | Qué contiene | Para qué sirve |
|---|---|---|
| **El motor del lenguaje** | `denviCustomVisitor`, `Simbolo`, `DenviException`, `DenviErrorListener` (+ lexer/parser que ANTLR genera) | Entender y ejecutar código DENVI |
| **La capa web** | `DenviApiApplication`, `DenviController`, `EjecutorService`, `EjecucionHandler`, `WebSocketConfig`, `EntradaInteractiva`, y los `record` (`EjecutarRequest`, `RespuestaEjecucion`, `ErrorDto`) | Exponer el motor a un navegador |

---

## 2. ¿Cómo arranca todo? La historia que empieza en `DenviApiApplication`

Esta es la pregunta clave: *"si lo único que se ejecuta es `DenviApiApplication`, ¿cómo es que de pronto existe una API que ejecuta el lenguaje?"*

### 2.1 El `main` y la magia de Spring

```java
@SpringBootApplication
public class DenviApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(DenviApiApplication.class, args);
    }
}
```

Parece que no hace nada, pero esa línea hace mucho. Al llamar a `SpringApplication.run(...)`, Spring Boot:

1. **Levanta un servidor web** (Tomcat, que ya viene incluido). A partir de ahí, la aplicación escucha en un puerto (por defecto el 8080).
2. **Escanea el paquete `com.denvi`** buscando clases con anotaciones especiales (`@RestController`, `@Service`, `@Component`, `@Configuration`). Esto lo activa `@SpringBootApplication`.
3. **Crea una instancia de cada una** (a esas instancias Spring las llama *beans*) y las guarda en su "contenedor".
4. **Las conecta entre sí**: si una clase pide otra en su constructor, Spring se la entrega ya construida. A esto se le llama **inyección de dependencias**.

En el código nunca aparece `new EjecutorService()`: Spring lo crea y lo entrega donde hace falta.

### 2.2 El orden en que Spring arma las piezas

El orden sale de lo que pide cada constructor:

```
EjecutorService        → no pide nada               → se crea primero
DenviController        → pide EjecutorService        → se crea con el anterior
EjecucionHandler       → pide EjecutorService        → igual
WebSocketConfig        → pide EjecucionHandler
                          + la propiedad "denvi.origenes-permitidos"
```

Visualmente:

```
                    ┌──────────────────────┐
                    │ DenviApiApplication  │   ← se ejecuta con "Run"
                    └──────────┬───────────┘
                               │ Spring escanea com.denvi y crea:
        ┌──────────────────────┼───────────────────────┐
        ▼                      ▼                       ▼
 ┌──────────────┐      ┌───────────────┐      ┌────────────────┐
 │EjecutorService│◄─────│DenviController│      │EjecucionHandler│
 │  (@Service)   │◄─────┤ (@RestController)    │  (@Component)  │
 └──────────────┘      └───────────────┘      └───────┬────────┘
        ▲                                              │
        └──────────────────────────────────────────────┘
                                                       ▼
                                              ┌────────────────┐
                                              │ WebSocketConfig │
                                              │ (@Configuration)│
                                              └────────────────┘
```

### 2.3 Qué queda "escuchando" cuando termina de arrancar

| Puerta | Quién la atiende | Para qué |
|---|---|---|
| `POST /api/ejecutar` | `DenviController` | Ejecutar un programa de una sola vez |
| `POST /api/analizar` | `DenviController` | Solo revisar si el código está bien escrito |
| `GET /api/salud` | `DenviController` | Preguntar "¿estás vivo?" |
| `ws://.../ws/ejecutar` | `EjecucionHandler` (registrado por `WebSocketConfig`) | Ejecución interactiva en vivo |

Y a partir de aquí la aplicación se queda esperando. **No hay nada más "corriendo"** hasta que llega una petición.

---

## 3. Una petición de punta a punta

### 3.1 Camino REST: `POST /api/ejecutar`

Cuando el usuario escribe un programa, presiona "Ejecutar" y el front manda esto:

```json
{ "codigo": "...programa DENVI...", "entradas": ["5", "10"] }
```

Esto es lo que pasa, paso a paso:

```
Navegador
   │  POST /api/ejecutar  { codigo, entradas }
   ▼
DenviController.ejecutar(req)           ← Spring convierte el JSON en un EjecutarRequest
   │  servicio.ejecutar(codigo, entradas)
   ▼
EjecutorService.ejecutar(...)
   │  1) Lanza una TAREA en otro hilo (con límite de 5 segundos)
   │  2) Dentro de esa tarea:
   │       parsear(codigo)  ───►  denviLexer + denviParser (con DenviErrorListener)
   │                              └─ si hay error léxico/sintáctico → DenviException
   │       new denviCustomVisitor(out, new Scanner(entradas))
   │       visitor.visit(arbol)  ───► ¡aquí se ejecuta el programa!
   │                                   ImpCons  → escribe en "out" (un buffer)
   │                                   ObtDatos → lee del Scanner (las "entradas")
   │  3) Espera a que termine (máx. 5 s)
   ▼
Arma un RespuestaEjecucion:
   • todo bien → exito(salida)
   • DenviException → fallo(salida, ErrorDto.de(e))
   • tardó mucho → fallo(salida, ErrorDto.simple("Tiempo agotado", ...))
   ▼
DenviController devuelve el RespuestaEjecucion → Spring lo convierte a JSON
   ▼
Navegador recibe { ok, salida, error }
```

**Idea importante:** en este modo, las respuestas a `ObtDatos` **tienen que venir ya escritas** en la lista `entradas`. El programa no puede "preguntar" a mitad de camino, porque la petición HTTP es de una sola ida y vuelta.

### 3.2 Camino WebSocket: ejecución interactiva

Un WebSocket es una conexión que se queda **abierta** en los dos sentidos. Eso permite que el servidor le diga al navegador "necesito que escribas algo" **mientras el programa sigue corriendo**.

```
Navegador                                   Servidor
   │  abre ws://.../ws/ejecutar                │
   │──────────────────────────────────────────►│ EjecucionHandler (una conexión = una sesión)
   │  {"tipo":"ejecutar","codigo":"..."}       │
   │──────────────────────────────────────────►│ iniciar(): crea Sesion + EntradaInteractiva
   │                                           │ lanza correr() en otro hilo + temporizador de 120 s
   │  {"tipo":"salida","texto":"Hola\n"}       │ ← el programa hizo ImpCons
   │◄──────────────────────────────────────────│
   │  {"tipo":"entrada"}                       │ ← el programa llegó a ObtDatos y se quedó esperando
   │◄──────────────────────────────────────────│
   │  (el usuario escribe "25" y da Enter)     │
   │  {"tipo":"entrada","texto":"25"}          │
   │──────────────────────────────────────────►│ s.entrada.enviarLinea("25") → el programa despierta
   │  {"tipo":"salida","texto":"Tienes 25\n"}  │
   │◄──────────────────────────────────────────│
   │  {"tipo":"fin"}                           │ ← terminó
   │◄──────────────────────────────────────────│
```

La pieza que hace posible el "se queda esperando" es **`EntradaInteractiva`**. Es un `InputStream` especial: cuando el intérprete le pide una línea y no hay ninguna, **bloquea el hilo** (con una cola `BlockingQueue.take()`) y antes de dormirse avisa al navegador. Cuando el usuario manda su texto, `enviarLinea` lo mete a la cola y el hilo despierta como si nada. Para el intérprete es un `Scanner` normal; no sabe que detrás hay una persona al otro lado de internet.

### 3.3 Camino consola: `Main`

`Main` se salta toda la parte web. Lee un archivo `.dnv` de `src/test/resources/`, arma el lexer y el parser, crea el `denviCustomVisitor` con `System.out` y `System.in`, y lo ejecuta. Si hay un error, imprime `e.getMessage()` por `System.err`. Es la forma rápida de probar el lenguaje sin levantar un servidor ni un front, y es el punto de entrada que usa el comando instalable `denvi archivo.dnv` (ver sección 5).

---

## 4. Las piezas, una por una

Explicadas en lenguaje sencillo, una por una.

### 4.1 `DenviApiApplication`: el interruptor
Es solo el botón de encendido. No contiene lógica. Su trabajo es decirle a Spring "arranca y encuentra todo lo que haya en este paquete".

### 4.2 `DenviController`: la recepcionista
Atiende las peticiones HTTP, pero **no resuelve nada por sí misma**. Recibe el JSON, se lo pasa a `EjecutorService` y devuelve lo que este le conteste. Tiene tres puertas (`/ejecutar`, `/analizar`, `/salud`) y una anotación `@CrossOrigin` que le da permiso al front que corre en `http://localhost:5173` para hablarle (más sobre esto en la sección 6).

### 4.3 `EjecutorService`: el jefe de operaciones
Es el que de verdad sabe cómo correr un programa DENVI con seguridad:

- **`parsear`**: arma el lexer y el parser de ANTLR y les pone `DenviErrorListener`, para que cualquier error de escritura se convierta en una excepción nuestra y no en un texto perdido en la consola.
- **`analizar`**: solo parsea. Sirve para que el editor pueda marcar errores sin ejecutar nada.
- **`ejecutar`**: parsea, crea el visitor y lo corre **en otro hilo con tiempo máximo de 5 segundos**. Si el programa tiene un ciclo infinito, lo cancela y avisa. También recorta la salida a 100 000 caracteres para que nadie reviente la memoria imprimiendo sin parar.

Los hilos de este servicio tienen **16 MB de pila** (lo normal es mucho menos). Esto es porque el intérprete es **recursivo**: cada función de DENVI que llama a otra se convierte en llamadas Java anidadas, y con la pila normal un programa recursivo medio profundo se caería.

### 4.4 `EjecucionHandler`: el operador de la línea en vivo
Es el equivalente de `DenviController`, pero para el WebSocket. En lugar de una petición y una respuesta, mantiene una **conversación**:

- Entiende tres mensajes del navegador: `ejecutar`, `entrada` y `detener`.
- Manda cuatro tipos de mensaje de vuelta: `salida`, `entrada`, `error` y `fin`.
- Guarda un objeto **`Sesion`** por conexión, con la entrada interactiva, el temporizador y una bandera de "detenida".
- Pone un **límite de 120 segundos** (más generoso que el REST porque incluye el tiempo que el usuario tarda en escribir).
- Si la salida pasa de 100 000 caracteres, interrumpe el hilo. El intérprete revisa esa interrupción en cada línea (`visitLincod`) y en cada vuelta de `rep`, y se detiene solo.
- Si el usuario cierra la pestaña, `afterConnectionClosed` cancela la ejecución para no dejar hilos huérfanos.
- Su método `enviar` está sincronizado, porque el WebSocket no permite que dos hilos escriban al mismo tiempo (el hilo del programa y el del reloj podrían chocar).

### 4.5 `WebSocketConfig`: el letrero en la puerta
Le dice a Spring: "el handler `EjecucionHandler` atiende en la ruta `/ws/ejecutar`, y solo se aceptan conexiones de estos orígenes". Los orígenes vienen de la propiedad `denvi.origenes-permitidos` (si no se define, vale `*`, o sea, cualquiera). Así se puede restringir en producción cambiando solo la configuración. La versión comentada al inicio del archivo es la anterior (orígenes fijos de localhost) y se puede borrar.

### 4.6 `EntradaInteractiva`: el teléfono que suena y espera
Ya la vimos en el flujo: es un `InputStream` que **se duerme hasta que el usuario escribe**. Tiene dos métodos importantes: `enviarLinea` (lo llama el handler cuando llega un mensaje `entrada`) y `read` (lo llama el `Scanner` del intérprete). Antes de dormir, avisa con el `Runnable alEsperar`, que el handler usa para mandar `{"tipo":"entrada"}` al navegador. Si el hilo es interrumpido, lanza `InterruptedIOException` y la ejecución termina limpiamente.

### 4.7 Los tres `record`: los sobres
Son clases mínimas para **transportar datos** (Java genera constructor, getters, `equals`, etc.). Spring los convierte solos de/hacia JSON.

| Record | Contenido | Quién lo usa |
|---|---|---|
| `EjecutarRequest` | `codigo`, `entradas` | Lo que **llega** del navegador (REST) |
| `RespuestaEjecucion` | `ok`, `salida`, `error` | Lo que **sale** hacia el navegador (REST) |
| `ErrorDto` | `categoria`, `detalle`, `ayuda`, `linea`, `columna`, `archivo`, `traza` | El error ya "empacado" para JSON (REST y WebSocket) |

`ErrorDto` tiene dos fábricas: `de(DenviException)` para errores del lenguaje y `simple(...)` para cosas que no son del lenguaje (tiempo agotado, error interno).

### 4.8 `Simbolo`: la caja con etiqueta
Cada valor que maneja el intérprete (un entero, una cadena, un objeto...) viaja dentro de un `Simbolo`. Es una cajita con:

- **`tipo`** (de un enum `TipoDato`: `ENTERO`, `DECIMAL`, `CADENA`, `OBJETO`, `ARREGLO`, `VACIO`...),
- **`valor`** (el dato real, como `Object`),
- y unas banderas extra: si es **constante**, si es **global**, de qué clase es (si es un objeto) y de qué tipo son sus elementos (si es colección).

El tipo `VACIO` es especial: representa "esta función terminó sin devolver nada". Gracias a él, el intérprete puede avisar si alguien intenta usar como valor una función que no retorna.

### 4.9 `DenviErrorListener` y `DenviException`: el sistema de quejas
- ANTLR, cuando encuentra un error, por defecto lo imprime y sigue. `DenviErrorListener` cambia eso: **lanza una excepción** en el primer error.
- `DenviException` es la base de **todos** los errores del lenguaje (léxicos, sintácticos y semánticos), con mensaje en español, fragmento de código subrayado, ayuda y traza.

Esta pareja tiene su propio documento: `03_excepciones_y_error_listener.md`.

### 4.10 `denviCustomVisitor`: el cerebro
Aquí vive la ejecución real del lenguaje. Se explica en `02_denvi_custom_visitor.md`.

### 4.11 `Main`: el atajo
Ya descrito arriba. Útil para depurar el lenguaje sin web.

### 4.12 Lo que no aparece en el código fuente pero existe: archivos generados por ANTLR
`denviLexer`, `denviParser` (con todos los `XxxContext`) y `denviBaseVisitor` los genera ANTLR a partir del archivo de gramática `.g4` al compilar. No se editan a mano. `denviCustomVisitor` hereda de `denviBaseVisitor` y sobrescribe el método de cada regla.

---

## 5. Empaquetado y distribución: el comando `denvi`

Además de ejecutarse desde el IDE, el proyecto se puede **empaquetar e instalar** en Windows para usarlo como un comando de consola, igual que `python script.py` o `node archivo.js`:

```
denvi prueba.dnv
```

### 5.1 Qué pasa al escribir ese comando

```
denvi prueba.dnv
   │
   ▼
denvi.bat / denvi.exe        ← está en una carpeta del PATH, por eso Windows lo encuentra
   │  ejecuta: java -jar denvi.jar prueba.dnv
   ▼
Main.main(args)              ← args[0] = "prueba.dnv"
   │  lexer + parser (ANTLR) + denviCustomVisitor
   ▼
Muestra el resultado en la consola (por ejemplo, "hola mundo")
```

- La palabra `denvi` funciona como comando porque el instalador copia el `.bat` o `.exe` a una carpeta y la agrega al **PATH** de Windows.
- El nombre del archivo llega a `Main` como `args[0]`.
- En este modo **no interviene Spring ni la API**: no se levanta ningún servidor en `localhost:8080`. El programa corre, imprime y termina.

### 5.2 Qué es cada pieza del empaque

| Pieza | Qué es | Qué hace |
|---|---|---|
| **`.jar`** | Aplicación Java que contiene el intérprete ya compilado a bytecode | Es el programa real |
| **`.exe`** | Ejecutable de Windows. Puede ser un *wrapper* (tipo Launch4j, que lanza el `.jar` con el Java instalado) o un paquete con Java incluido (tipo jpackage) | Arranca el `.jar` |
| **`.bat`** | Script por lotes de Windows | Automatiza pasos: copiar archivos, verificar Java, lanzar el programa |

El `.exe` y el `.bat` **no interpretan ni compilan nada**: solo arrancan el motor. El que entiende DENVI es el intérprete que está dentro del `.jar`.


### 5.3 Las capas, de abajo hacia arriba

```
Código DENVI (.dnv)           ← lo escribe el usuario
        │  lo interpreta
        ▼
Intérprete (Java)             ← denviCustomVisitor, parser, etc.
        │  javac lo compiló a bytecode (.class / .jar)
        ▼
JVM (Java)                    ← ejecuta ese bytecode
        │  la lanza
        ▼
.exe / .bat                   ← solo arranca todo y lo instala; no traduce nada
```

### 5.4 Cómo describir el proyecto con precisión

> **DENVI es un lenguaje de programación interpretado. Su intérprete está desarrollado en Java con ANTLR4 y se distribuye como un comando instalable para Windows (`denvi archivo.dnv`), además de ofrecer ejecución mediante una API web (REST y WebSocket).**

| Parte | Cómo llamarla |
|---|---|
| El lenguaje DENVI | Lenguaje interpretado |
| `denviCustomVisitor` + ANTLR | Intérprete de tipo *tree-walking* |
| El `.jar` | Aplicación Java que contiene el intérprete |
| El `.exe` / `.bat` | Lanzador e instalador (empaquetado) |
| `denvi prueba.dnv` | Comando de consola (CLI) del intérprete |
| La API con Spring Boot | Servicio web que expone el intérprete a un editor en el navegador |

En la documentación conviene decir que el intérprete **interpreta** o **ejecuta**, y evitar "compila", porque no se genera ningún archivo traducido.

---

## 6. Tabla resumen

| Archivo | Rol (en una frase) |
|---|---|
| `DenviApiApplication` | Botón de encendido; arranca Spring y todo lo demás |
| `DenviController` | Recepcionista REST: `/ejecutar`, `/analizar`, `/salud` |
| `EjecutorService` | Parsea y ejecuta con hilo aparte, timeout y límite de salida |
| `EjecucionHandler` | Conversación en vivo por WebSocket |
| `WebSocketConfig` | Registra la ruta `/ws/ejecutar` y los orígenes permitidos |
| `EntradaInteractiva` | `InputStream` que espera a que el usuario escriba |
| `EjecutarRequest` | Sobre de entrada (código + entradas) |
| `RespuestaEjecucion` | Sobre de salida (ok + salida + error) |
| `ErrorDto` | Error listo para JSON |
| `Main` | Ejecución por consola (base del comando `denvi archivo.dnv`) |
| `Simbolo` | Caja con valor y tipo de cada dato |
| `DenviErrorListener` | Convierte los errores de ANTLR en excepciones propias |
| `DenviException` | Jerarquía de errores con mensaje, ayuda y traza |
| `denviCustomVisitor` | El intérprete: recorre el árbol y ejecuta |
