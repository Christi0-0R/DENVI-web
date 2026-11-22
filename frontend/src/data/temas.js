import { BookOpen, Box, Equal, Calculator, GitBranch, Repeat, Keyboard, Braces, Shapes, Gamepad2 } from 'lucide-vue-next'

export const temas = [
  { id: 'intro', titulo: 'Introducción y sintaxis básica', icono: BookOpen, color: 'text-pri bg-crema',
    texto: `DENVI significa «Desarrollo de Niveles de Videojuegos». Es un lenguaje de dominio específico (DSL): no busca resolver cualquier problema, sino describir niveles de videojuegos, colocar obstáculos y recompensas, crear eventos y definir cómo se comportan los elementos del juego.

Archivos
Los programas se guardan con la extensión .dnv. Hay dos tipos de archivo:
• nombre.dnv: el archivo ejecutable. Contiene la clase principal, Esqueleto Principal, y dentro de ella el programa.
• nombre.clase.dnv: un archivo de clases. Solo contiene clases y se trae a otro archivo con Import nombre.clase.dnv;

Estructura mínima
Todo programa vive dentro de Esqueleto Principal. El programa más pequeño posible es:
Esqueleto Principal --> { IGNOR; };
Un cuerpo nunca puede quedar vacío; si todavía no tiene código se escribe IGNOR; (y nada más en ese bloque).

Reglas que siempre se cumplen
• Toda instrucción completa termina en ; (incluyendo clases, métodos, funciones, ev, rep, niveles y sucesos).
• Los bloques se abren y cierran con llaves { }, los argumentos y condiciones van entre paréntesis ( ) y los arreglos entre corchetes [ ].
• Los espacios, tabuladores y saltos de línea se ignoran entre elementos, así que puedes acomodar tu código como quieras.

Cómo se escribe cada cosa (se distingue a simple vista)
• Variables y atributos: empiezan con &, por ejemplo &vida.
• Constantes: empiezan con #, por ejemplo #max.
• Clases, métodos, funciones, niveles y tipos de suceso: empiezan con mayúscula, por ejemplo Jugador o Bosque.
• Objetos: todo en minúsculas y sin símbolo, por ejemplo heroe o roca1.
Los nombres distinguen mayúsculas de minúsculas, no aceptan ñ, acentos ni guion bajo, y se recomienda camelCase.

Comentarios
• De una línea: empiezan con ::: y todo lo que sigue en esa línea se ignora (incluido un ; que quede ahí).
• De varias líneas: van entre ::* y *::
Los comentarios nunca llevan ; y dentro de una cadena ::: no cuenta como comentario.`,
    ejemplos: [
      { nombre: 'Hola mundo', codigo: '// Hola mundo en DENVI\n' },
      { nombre: 'Comentarios', codigo: '// Esto es un comentario\n' },
    ] },

  { id: 'tipos', titulo: 'Tipos de datos y variables', icono: Box, color: 'text-mor bg-mor/15',
    texto: `DENVI tiene siete tipos básicos, cada uno con una palabra corta:
• ent (entero): números sin decimales, como 0, 7 o 250. No llevan ceros a la izquierda; los negativos se escriben con el signo -, por ejemplo -25.
• dec (decimal): usan punto, como 3.14 o 0.5. Siempre debe haber un número antes y después del punto.
• cad (cadena): texto entre comillas dobles, como "hola". Acepta los escapes \\n, \\t, \\" y \\\\.
• car (carácter): un solo carácter entre comillas simples, como 'a' o '7'.
• boo (booleano): verdadero o falso, siempre en minúsculas.
• tm (tiempo): un valor de tiempo entre corchetes. Con dos partes es minuto:segundo ([1:30]) y con tres es hora:minuto:segundo ([2:15:40]). También puedes omitir partes: [5:] son 5 minutos y [::5] son 5 segundos. Minutos y segundos van de 0 a 59.
• nl (nulo): variables que solo guardan nulo, la ausencia de valor.

Declarar una variable
Se escribe el nombre con &, el tipo entre paréntesis y, si quieres, un valor inicial con :=
&vida(ent):=10;
&nombre(cad);
La variable empieza con minúscula después del & y puede tener letras y números (&x1, &edadMaxima).

Constantes
Usan # en lugar de & y siempre necesitan tipo y valor. Una vez creadas no se pueden cambiar:
#max(ent):=100;

Arreglos y listas
• Arreglo: se declara con ar y sus valores van entre corchetes. Se puede anidar: ar &pos(ent):=[1, [2, 3]];
• Lista: se declara con lt y sus valores van entre llaves. No se anida: lt &letras(car):={'a', 'b'};
Ambos pueden empezar vacíos ([] o {}).

Variables globales
Si pones Mundo antes de una declaración, la variable es global y se puede usar en todo el programa:
Mundo &total(ent):=0;

Ojo: que el valor coincida con el tipo (por ejemplo, no meter "hola" en un ent) lo revisa el análisis semántico.`,
    ejemplos: [{ nombre: 'Ejemplo 1', codigo: '' }] },

  { id: 'asignacion', titulo: 'Asignación y operadores', icono: Equal, color: 'text-azu bg-aqu/25',
    texto: `Asignar
Para darle un valor nuevo a una variable que ya existe se usa := (no el = de otros lenguajes). En la asignación ya no se escribe el tipo:
&vida:=5;
&vida:=&vida + 1;
También puedes asignar a los atributos de un objeto con un punto: heroe.&vida:=3;
Con Mundo delante, la asignación es sobre la variable global: Mundo &total:=5;

Incrementos rápidos
DENVI tiene cuatro atajos que se usan como valor completo de una asignación:
• &a:=++; suma 1 (igual que &a:=&a + 1;)
• &a:=--; resta 1
• &a:=+?(3); suma la cantidad indicada (igual que &a:=&a + 3;)
• &a:=-?(2); resta la cantidad indicada
No se pueden mezclar con otras operaciones (&a:=++ + 1; es inválido) y solo sirven sobre variables que ya existen, no en una declaración.

Operadores aritméticos
+ suma, - resta, * multiplicación, / división y % residuo. No existen la potencia (**) ni la división entera (//).

Operadores de comparación
> mayor que, < menor que, == igual, != diferente.
Ojo con estos dos, que se escriben al revés de otros lenguajes:
• => mayor o igual (no >=)
• =< menor o igual (no <=)

Operadores lógicos
• ^ es el Y lógico (en DENVI no es potencia)
• || es el O lógico
• ! es la negación

Signos de un solo operando
Solo +, - y ! pueden ir antes de un valor (-&a, !&activo). Como -- es un atajo, para restar un negativo se escribe con espacio: &a - -&b. Igual para sumar un positivo: &a + +&b.`,
    ejemplos: [{ nombre: 'Ejemplo 1', codigo: '' }] },

  { id: 'expresiones', titulo: 'Expresiones aritméticas y lógicas', icono: Calculator, color: 'text-pri bg-crema',
    texto: `Una expresión es cualquier combinación de valores, variables, constantes, atributos, llamadas y operadores que produce un resultado. Por ejemplo: &a + 3 * 2 o heroe.&vida =< 0.

Orden en que se resuelven los operadores (de mayor a menor prioridad)
1. Accesos con punto: heroe.&vida, heroe.Curar(2)
2. Signos de un operando: !, - y +
3. Multiplicación, división y residuo: * / %
4. Suma y resta: + -
5. Comparaciones: < > =< =>
6. Igualdad: == !=
7. Y lógico: ^
8. O lógico: ||

Lo que tiene más prioridad se calcula primero. Por eso:
• 2 + 3 * 4 da 14, porque la multiplicación va antes.
• !&a ^ &b || &c se lee ((!&a) ^ &b) || &c.
• -heroe.&vida se lee -(heroe.&vida), porque el punto pega más fuerte que todo.

Asociatividad
Cuando hay varios operadores del mismo nivel, se resuelven de izquierda a derecha: 10 - 4 - 3 da 3 y 8 / 4 / 2 da 1. Los signos de un solo operando van de derecha a izquierda y se pueden repetir (!!&a o - -&a).

Paréntesis
Si quieres otro orden, usa paréntesis: (2 + 3) * 4 da 20. Se pueden anidar todo lo que necesites.

Detalles importantes
• !&a > 3 se lee (!&a) > 3, porque la negación pega más fuerte que la comparación.
• Una llamada a función también es un valor: -Doble(4) es válido.
• Los arreglos y las listas no forman parte de las expresiones: no se pueden sumar ni comparar.`,
    ejemplos: [{ nombre: 'Ejemplo 1', codigo: '' }] },

  { id: 'decision', titulo: 'Estructuras de decisión', icono: GitBranch, color: 'text-mor bg-mor/15',
    texto: `Para tomar decisiones DENVI usa ev (evaluar). Tiene hasta tres caminos:
• ev: la condición principal (como un if).
• evalt: otra condición que se revisa si las anteriores fallaron (como un else if). Puedes poner las que quieras.
• alt: lo que pasa si nada se cumplió (como un else). Va al final, solo una vez y sin condición.

Forma de escribirlo
Cada condición va entre sus propios paréntesis, seguida de ? y del bloque entre llaves. Los caminos se unen con ->, y todo va dentro de ev( ... ); con su ; al final:
ev( (&vida > 5) ? { ImpConsSl("bien"); }
    -> evalt (&vida > 0) ? { ImpConsSl("cuidado"); }
    -> alt { ImpConsSl("sin vida"); } );

Cómo funciona
Se revisan las condiciones en orden, de arriba a abajo. En cuanto una se cumple se ejecuta su bloque y se ignora el resto. Si ninguna se cumple y hay un alt, se ejecuta el alt.

Reglas a recordar
• La condición siempre lleva paréntesis propios: (&a > 3) ? { }
• evalt y alt no pueden ir solos, siempre necesitan un ev antes.
• Las instrucciones dentro del bloque llevan su ; normal.
• En ev el bloque puede quedar vacío { } o con { IGNOR; }, por si todavía no sabes qué poner.
• Puedes meter un ev dentro de otro (anidar) las veces que necesites.`,
    ejemplos: [{ nombre: 'Ejemplo 1', codigo: '' }] },

  { id: 'repeticion', titulo: 'Estructuras de repetición', icono: Repeat, color: 'text-azu bg-aqu/25',
    texto: `Para repetir instrucciones DENVI usa rep. En un solo encabezado junta tres cosas: el inicio, la condición y el incremento.

Forma de escribirlo
rep( (&i(ent):=0) -> (&i < 5) ? { ImpCons(&i); } : ++ );
• (&i(ent):=0): el inicio. Aquí no lleva ; porque está dentro de otra estructura.
• -> (&i < 5) ?: la condición. Se revisa antes de cada vuelta; mientras sea verdadera, el ciclo sigue.
• { ... }: el bloque que se repite.
• : ++: lo que se le hace a la variable al terminar cada vuelta.

Incrementos disponibles
• ++ suma 1 y -- resta 1.
• +?(n) suma n y -?(n) resta n, por ejemplo +?(2) o -?(3).

¿Hay que nombrar la variable en el incremento?
• Si el encabezado declara la variable (&i(ent):=0), no hace falta: el incremento actúa sobre ella. Aun así puedes nombrarla: ++(&i) o +?(2, &i).
• Si el encabezado solo asigna una variable que ya existe (&j:=0) o solo la nombra (&k), siempre debes indicarla: ++(&j) o +?(2, &k).

Reglas a recordar
• rep es un solo tipo de ciclo y cubre lo que en otros lenguajes harían for y while.
• Siempre termina en ; después del paréntesis final.
• El bloque puede estar vacío { } o con { IGNOR; }.
• Dentro puedes usar cualquier instrucción, incluso otros rep o ev.`,
    ejemplos: [{ nombre: 'Ejemplo 1', codigo: '' }] },

  { id: 'entrada', titulo: 'Entradas y salidas', icono: Keyboard, color: 'text-pri bg-crema',
    texto: `Mostrar resultados
• ImpCons( ... ); imprime en consola sin salto de línea.
• ImpConsSl( ... ); imprime y agrega un salto de línea al final.
Para juntar varias partes en una sola impresión se usa el conector -> (no la coma ni el +):
ImpConsSl("vida: " -> heroe.&vida -> " puntos: " -> &puntos);
Puedes imprimir cadenas, variables, constantes, atributos, resultados de operaciones, arreglos y listas. Siempre debe haber algo que imprimir: ImpCons(); no es válido.

Recibir datos
ObtDatos lee un dato del teclado y lo guarda en una variable. Se indica el tipo, dos puntos y la variable:
ObtDatos(ent:&edad);
ObtDatos(cad:&nombre);
El dato solo se puede guardar en una variable con &, no en una constante ni directamente en un atributo de un objeto.

Importar archivos
Import trae otros archivos a tu programa y solo puede ir al inicio del archivo, antes de Esqueleto.
• Archivos de clases: se escriben por nombre, sin comillas: Import jugador.clase.dnv;
• Archivos externos (imágenes, textos, etc.): se escribe su ruta entre comillas dobles: Import "datos.txt";

Ojo con las mayúsculas: se escribe exactamente ImpCons, ImpConsSl, ObtDatos e Import.`,
    ejemplos: [{ nombre: 'Ejemplo 1', codigo: '' }] },

  { id: 'funciones', titulo: 'Métodos y funciones', icono: Braces, color: 'text-mor bg-mor/15',
    texto: `DENVI tiene dos formas de agrupar código para reutilizarlo:
• Accion: una función. Se declara en el programa principal o dentro de un método.
• MetaAccion: un método. Vive dentro de una clase (Esqueleto) y trabaja con ese objeto.

Cómo se declaran
Nombre con mayúscula inicial, el conector -->, los parámetros entre paréntesis y el cuerpo entre llaves, con ; al final:
Accion Doble --> (&n(ent)) {
    (&n * 2).retornar;
};
MetaAccion Curar --> (&cantidad(ent)) {
    @esto.&vida := @esto.&vida + &cantidad;
};
Si no recibe nada, los paréntesis van vacíos: ().

Parámetros
Se escriben como variables con su tipo, sin valor inicial y separados por coma: (&x(ent), &y(ent)). También pueden ser arreglos (ar &v(ent)), listas (lt &l(ent)) u objetos (Obstaculo otro). Las constantes no pueden ser parámetros.

Devolver un valor
El retorno se escribe al revés que en otros lenguajes: el valor entre paréntesis, punto y retornar.
(&n * 2).retornar;
Para salir sin devolver nada: ().retornar;
Puede haber varios retornos y pueden ir en cualquier parte, incluso dentro de ev o rep. No hace falta declarar qué tipo se devuelve.

Llamar
• Una función: Doble(5);
• Un método de un objeto: heroe.Curar(5);
Las llamadas también se pueden usar dentro de expresiones: &r(ent):=Doble(&a) + 1;

Qué puede ir dónde
• Un método puede tener instrucciones y funciones dentro, pero no otro método.
• Una función solo tiene instrucciones: no puede declarar otra función, aunque sí puede llamarse a sí misma o a otras.
• Si el cuerpo no tiene código se escribe { IGNOR; }, nunca { } vacío.`,
    ejemplos: [{ nombre: 'Ejemplo 1', codigo: '' }] },

  { id: 'clases', titulo: 'Clases', icono: Shapes, color: 'text-azu bg-aqu/25',
    texto: `En DENVI las clases se declaran con Esqueleto. Con ellas creas tus propios elementos del juego: jugadores, obstáculos, recompensas, enemigos, etc.

Declarar una clase
Nombre con mayúscula, el conector --> y entre paréntesis sus atributos con tipo. Luego, entre llaves, sus métodos:
Esqueleto Jugador --> (&vida(ent), &puntos(ent)) {
    MetaAccion Curar --> (&cantidad(ent)) {
        @esto.&vida := @esto.&vida + &cantidad;
    };
};
Los parámetros de la clase son sus atributos. Una clase solo puede contener métodos (MetaAccion); si no tiene ninguno se escribe { IGNOR; }.

Crear objetos
Un objeto se crea con iniciar, pasando los valores de los atributos en orden. El nombre del objeto va en minúsculas:
Jugador heroe := iniciar(10, 0);

Usar atributos y métodos
• Desde fuera: heroe.&vida para el atributo y heroe.Curar(5) para el método.
• Dentro de un método: @esto representa al objeto actual, por ejemplo @esto.&vida. @esto solo tiene sentido dentro de un método.
También se pueden encadenar puntos, como a.&b.Metodo().&c. Para asignar solo se permiten atributos: heroe.&vida := 3;

Herencia
Una clase puede heredar de otra con ObtieneDe:
Esqueleto Mago --> ObtieneDe Jugador --> (&mana(ent)) { ... };
La clase hija recibe sus propios atributos y puede agregar métodos nuevos.

La clase principal
Esqueleto Principal es especial: no lleva parámetros, es el punto de entrada del programa y solo hay una por archivo .dnv. Primero van sus métodos (opcionales) y después el programa.

Archivos de clases
Puedes guardar tus clases en un archivo nombre.clase.dnv y traerlas con Import nombre.clase.dnv; al inicio de tu programa.`,
    ejemplos: [{ nombre: 'Ejemplo 1', codigo: '' }] },

  { id: 'escenarios', titulo: 'Escenarios y eventos', icono: Gamepad2, color: 'text-pri bg-crema',
    texto: `Esta es la parte que hace especial a DENVI: describir niveles, colocar cosas en ellos y decidir qué pasa cuando algo ocurre.

Niveles
Un Nivel es un escenario del juego. Lleva sus propiedades entre paréntesis (pueden ser ()) y su código entre llaves:
Nivel Cueva -> ((&oscuro(boo):=verdadero) {
    ImpConsSl("hace frio");
});
Declarar un nivel no lo activa; para entrar a él se usa Viajar.

Zonas
Una Zona es un subescenario dentro de un nivel. Se separan con comas y no llevan ; propio. Un nivel tiene código o zonas, pero no ambos a la vez:
Nivel Entorno -> (() {
    Zona Entrada -> (() { IGNOR; }),
    Zona Fondo -> (() { IGNOR; })
});

Portales
Un Portal conecta un nivel con uno o varios destinos. Puede ir al final de la declaración o escribirse aparte:
Nivel Bosque -> (() { IGNOR; }).Portal --> Cueva;
Bosque.Portal --> (Cueva, Salida);

Colocar, quitar y viajar
• Situar(roca -> (2, 3)); coloca un objeto en la posición (x, y). Las posiciones pueden ser operaciones. Fuera de un nivel, se indica cuál al final: Situar(llave -> (1, 1) -> Cueva);
• Retirar(moneda); quita un objeto del juego; ya no participa en sucesos.
• Viajar(Cueva); cambia el nivel activo.
Los obstáculos y recompensas son objetos de tus propias clases, creados con iniciar.

Sucesos (eventos)
Suceso registra una regla: cuando pasa algo, se ejecuta su bloque. Tiene dos formas:
• Forma corta, con un objeto y un tipo de suceso:
Suceso((heroe, Toma) -> { Retirar(moneda); });
• Forma general, con una condición libre que se activa cada vez que pasa de falsa a verdadera:
Suceso((heroe.&vida =< 0) -> { Viajar(Salida); });

Tipos de suceso disponibles
• Choque: el objeto ocupa la misma posición que otro objeto (por ejemplo, un obstáculo).
• Toma: el objeto coincide en posición con una recompensa.
• Ingreso: el objeto entra a un nivel o zona.
• Egreso: el objeto sale de un nivel o zona.

Reglas a recordar
• Nombres de niveles, zonas y tipos de suceso con mayúscula inicial; objetos en minúsculas.
• Todo termina en ;, y los bloques de niveles y sucesos pueden quedar vacíos { }.
• Puedes conectar un nivel con otro que declares más abajo.`,
    ejemplos: [{ nombre: 'Ejemplo 1', codigo: '' }] },
]