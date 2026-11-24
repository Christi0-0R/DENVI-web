// Un nivel por tema (id = id del tema en temas.js). El orden de esta lista es el orden del mapa.
//
// Tipos de paso:
//   info      -> explicación corta, con código opcional que se puede probar
//               (probar:false oculta el botón "Probar código" cuando el código no corre solo;
//                entradas: ['25'] muestra qué escribir cuando la terminal pida un dato)
//   opcion    -> pregunta de opción múltiple (correcta = índice)
//   completar -> código con un hueco ___ y fichas para elegir (correcta = índice)
//   armar     -> se forma una línea de código tocando fichas (tokens = orden correcto)
//
// Estructura de cada nivel: se explica un concepto (info) y enseguida se practica.
// El texto de info admite saltos de línea (\n\n) y viñetas con "•".

const info = (titulo, texto, codigo, probar = true, entradas = []) =>
  ({ tipo: 'info', titulo, texto, codigo, probar, entradas })
const opcion = (pregunta, opciones, correcta, explicacion, codigo) =>
  ({ tipo: 'opcion', pregunta, opciones, correcta, explicacion, codigo })
const completar = (pregunta, codigo, opciones, correcta, explicacion) =>
  ({ tipo: 'completar', pregunta, codigo, opciones, correcta, explicacion })
const armar = (pregunta, tokens, extras, explicacion) =>
  ({ tipo: 'armar', pregunta, tokens, extras, explicacion })

export const niveles = [
  // 1 ───────────────────────────────────────────────
  { id: 'intro', pasos: [
    info('Qué es DENVI',
      'DENVI significa «Desarrollo de Niveles de Videojuegos». Es un lenguaje hecho para describir niveles: colocar obstáculos y recompensas, crear eventos y definir cómo se comporta cada elemento del juego.\n\nHay dos tipos de archivo:\n• nombre.dnv: el programa que se ejecuta.\n• nombre.clase.dnv: un archivo que solo contiene clases y se trae a otro programa.'),
    opcion('¿Qué extensión tiene un archivo ejecutable de DENVI?',
      ['.denvi', '.dnv', '.java', '.den'], 1,
      'Los programas se guardan como .dnv. Los archivos de clases terminan en .clase.dnv.'),

    info('Tu primer programa',
      'Todo programa vive dentro de Esqueleto Principal. El símbolo --> abre el cuerpo, que va entre llaves { }.\n\nDentro escribes instrucciones. ImpConsSl("texto") muestra un mensaje y salta de línea. Fíjate en el ; al final de cada instrucción, y también al final de todo el programa.\n\nPulsa «Probar código» para verlo funcionar.',
      `Esqueleto Principal --> {
  ImpConsSl("Hola mundo");
};`),
    completar('Completa para imprimir con salto de línea',
      `Esqueleto Principal --> {
  ___("Hola");
};`,
      ['ImpCons', 'ImpConsSl', 'Imprimir', 'print'], 1,
      'ImpConsSl imprime y agrega un salto de línea. ImpCons imprime sin salto.'),

    info('Comentarios',
      'Un comentario es una nota para ti: DENVI la ignora.\n• De una línea: empieza con ::: y llega hasta el final de la línea.\n• De varias líneas: va entre ::* y *::\n\nLos comentarios nunca llevan ; y dentro de una cadena los ::: no cuentan como comentario.',
      `::: Mi primer programa
::* Este comentario
   ocupa varias líneas *::
Esqueleto Principal --> {
  ImpConsSl("Los comentarios se ignoran");
  ImpConsSl("::: esto SI se imprime");
};`),
    opcion('¿Cómo se escribe un comentario de una línea?',
      ['// comentario', '# comentario', '::: comentario', '-- comentario'], 2,
      'Los comentarios de una línea empiezan con :::. Los de varias líneas van entre ::* y *::.'),

    info('El cuerpo nunca queda vacío',
      'Un programa, una función, un método o una clase no pueden tener las llaves vacías. Si todavía no sabes qué poner, escribe IGNOR; (y nada más en ese bloque).\n\nPor eso el programa más pequeño posible es:\nEsqueleto Principal --> { IGNOR; };',
      `Esqueleto Principal --> { IGNOR; };`),
    armar('Forma el programa más pequeño posible',
      ['Esqueleto', 'Principal', '-->', '{', 'IGNOR', ';', '}', ';'], ['ev', '::'],
      'Un cuerpo nunca queda vacío: si no hay código se escribe IGNOR;'),
  ] },

  // 2 ───────────────────────────────────────────────
  { id: 'tipos', pasos: [
    info('Declarar una variable',
      'Una variable es una cajita con nombre que guarda un valor. Se escribe así:\n&nombre(tipo):=valor;\n\n• & va pegado al nombre y indica que es variable.\n• El tipo va entre paréntesis.\n• := le da el valor inicial (es opcional: &puntos(ent); también vale).\n\nPara mostrar varias cosas juntas, ImpConsSl las une con ->.',
      `Esqueleto Principal --> {
  &vida(ent):=10;
  &nombre(cad):="Heroe";
  ImpConsSl(&nombre -> " tiene " -> &vida -> " de vida");
};`),
    armar('Declara una variable entera vida con valor 10',
      ['&vida', '(', 'ent', ')', ':=', '10', ';'], ['=', 'int'],
      'Nombre con &, tipo entre paréntesis y := para el valor inicial.'),

    info('Siete tipos básicos',
      '• ent: entero (7, 250, -25)\n• dec: decimal con punto (3.14, 0.5; siempre hay un número antes y otro después del punto)\n• cad: texto entre comillas dobles ("hola")\n• car: un solo carácter entre comillas simples (\'a\')\n• boo: verdadero o falso, en minúsculas\n• tm: tiempo entre corchetes\n• nl: nulo, la ausencia de valor\n\nEl valor debe coincidir con el tipo: no se puede guardar "hola" en un ent.',
      `Esqueleto Principal --> {
  &a(ent):=7;
  &pi(dec):=3.14;
  &saludo(cad):="hola";
  &letra(car):='a';
  &activo(boo):=verdadero;
  &duracion(tm):=[1:30];
  ImpConsSl(&a -> " " -> &pi -> " " -> &saludo);
  ImpConsSl(&letra -> " " -> &activo -> " " -> &duracion);
};`),
    opcion('¿Qué tipo usarías para guardar 3.14?',
      ['ent', 'dec', 'cad', 'tm'], 1,
      'dec guarda decimales y usa punto, con un número antes y otro después.'),
    completar('Declara una variable de texto',
      '&nombre(___):="Ana";',
      ['cad', 'car', 'ent', 'boo'], 0,
      'cad es una cadena de texto entre comillas dobles. car es un solo carácter entre comillas simples.'),

    info('El tipo tiempo (tm)',
      'Un tiempo va entre corchetes y se lee de derecha a izquierda:\n• [1:30] = minuto:segundo\n• [2:15:40] = hora:minuto:segundo\n• [5:] = 5 minutos\n• [::5] = 5 segundos\n\nMinutos y segundos van de 0 a 59.',
      `Esqueleto Principal --> {
  &corto(tm):=[1:30];
  &largo(tm):=[2:15:40];
  &minutos(tm):=[5:];
  &segundos(tm):=[::5];
  ImpConsSl(&corto);
  ImpConsSl(&largo);
  ImpConsSl(&minutos);
  ImpConsSl(&segundos);
};`),
    opcion('¿Cómo se escribe un tiempo de 1 minuto y 30 segundos?',
      ['[1:30]', '"1:30"', '1.30', '(1:30)'], 0,
      'Un valor tm va entre corchetes: [1:30] es minuto:segundo y [2:15:40] es hora:minuto:segundo.'),

    info('Constantes',
      'Una constante es un valor que no cambia nunca. Usa # en lugar de & y siempre necesita tipo y valor.\n\n#max(ent):=100;\n\nSi intentas cambiarla después, el programa dará error.',
      `Esqueleto Principal --> {
  #max(ent):=100;
  #titulo(cad):="Mi juego";
  ImpConsSl(#titulo -> ": maximo " -> #max);
};`),
    opcion('¿Cuál es una constante válida?',
      ['&max(ent):=100;', '#max(ent):=100;', '#max(ent);', 'const max=100;'], 1,
      'Las constantes llevan #, tipo y valor obligatorio.'),
  ] },

  // 3 ───────────────────────────────────────────────
  { id: 'asignacion', pasos: [
    info('Asignar con :=',
      'Cuando la variable ya existe y quieres darle un valor nuevo, usas := sin escribir el tipo otra vez.\n\n&vida:=5;\n&vida:=&vida + 1;\n\nEn DENVI el = solo no sirve para asignar, y == sirve para comparar.',
      `Esqueleto Principal --> {
  &vida(ent):=5;
  ImpConsSl("antes: " -> &vida);
  &vida:=&vida + 1;
  ImpConsSl("despues: " -> &vida);
};`),
    opcion('¿Qué operador asigna un valor nuevo a una variable?',
      ['=', ':=', '==', '->'], 1,
      'En DENVI la asignación es :=. El == compara.'),

    info('Atajos para sumar y restar',
      'Hay cuatro atajos, y se usan como valor completo de la asignación:\n• &a:=++; suma 1\n• &a:=--; resta 1\n• &a:=+?(3); suma 3 (el número que pongas)\n• &a:=-?(2); resta 2\n\nNo se pueden mezclar con otras operaciones (&a:=++ + 1; es inválido).',
      `Esqueleto Principal --> {
  &a(ent):=10;
  &a:=++;
  ImpConsSl("++ : " -> &a);
  &a:=+?(3);
  ImpConsSl("+?(3) : " -> &a);
  &a:=--;
  ImpConsSl("-- : " -> &a);
  &a:=-?(2);
  ImpConsSl("-?(2) : " -> &a);
};`),
    completar('Suma 1 con el atajo',
      `&a(ent):=5;
&a:=___;`,
      ['++', '+1', '++a', '+=1'], 0,
      '&a:=++; equivale a &a:=&a + 1;'),
    opcion('¿Qué hace &a:=+?(3);?',
      ['Suma 3 a a', 'Resta 3 a a', 'Asigna 3 a a', 'Da error'], 0,
      '+?(n) suma n a la variable. -?(n) resta n.'),

    info('Operadores aritméticos y de comparación',
      'Aritméticos: + suma, - resta, * multiplicación, / división, % residuo. No existen la potencia ni la división entera.\n\nComparación: > mayor, < menor, == igual, != diferente.\n\nOjo, estos dos se escriben al revés que en otros lenguajes:\n• => mayor o igual (no >=)\n• =< menor o igual (no <=)',
      `Esqueleto Principal --> {
  &a(ent):=17;
  &b(ent):=5;
  ImpConsSl("suma: " -> &a + &b);
  ImpConsSl("residuo: " -> &a % &b);
  ImpConsSl("a => 17 ? " -> &a => 17);
  ImpConsSl("a =< 10 ? " -> &a =< 10);
};`),
    opcion('¿Cómo se escribe "mayor o igual"?',
      ['>=', '=>', '=<', '>>'], 1,
      'Se escribe al revés que en otros lenguajes: => es mayor o igual y =< es menor o igual.'),

    info('Operadores lógicos',
      'Sirven para combinar condiciones:\n• ^ es el Y lógico (verdadero solo si las dos partes lo son)\n• || es el O lógico (verdadero si al menos una lo es)\n• ! es la negación (invierte verdadero y falso)\n\nCuidado: ^ NO es potencia en DENVI.',
      `Esqueleto Principal --> {
  &edad(ent):=15;
  ImpConsSl("entre 12 y 17? " -> (&edad => 12) ^ (&edad =< 17));
  ImpConsSl("menor de 10 o mayor de 60? " -> (&edad < 10) || (&edad > 60));
  ImpConsSl("no es adulto? " -> !(&edad => 18));
};`),
    opcion('¿Qué significa ^ en DENVI?',
      ['Potencia', 'Y lógico', 'O lógico', 'Negación'], 1,
      '^ es el Y lógico, || es el O lógico y ! es la negación. No existe la potencia.'),
  ] },

  // 4 ───────────────────────────────────────────────
  { id: 'expresiones', pasos: [
    info('Qué es una expresión',
      'Una expresión es cualquier combinación de valores, variables, constantes, atributos, llamadas y operadores que produce un resultado: &a + 3 * 2 o heroe.&vida =< 0.\n\nCuando hay varios operadores, DENVI sigue un orden de prioridad (de mayor a menor):\n1. Acceso con punto (heroe.&vida)\n2. Signos de un operando: ! - +\n3. * / %\n4. + -\n5. < > =< =>\n6. == !=\n7. ^ (Y lógico)\n8. || (O lógico)\n\nLo de mayor prioridad se calcula primero.',
      `Esqueleto Principal --> {
  ImpConsSl(2 + 3 * 4);
  ImpConsSl((2 + 3) * 4);
};`),
    opcion('¿Cuánto da 2 + 3 * 4?',
      ['20', '14', '24', '10'], 1,
      'La multiplicación se resuelve antes que la suma: 3 * 4 = 12 y 2 + 12 = 14.'),
    opcion('¿Qué se calcula antes que cualquier otro operador?',
      ['La suma', 'El acceso con punto (heroe.&vida)', 'El Y lógico ^', 'Las comparaciones'], 1,
      'Por eso -heroe.&vida se lee -(heroe.&vida).'),

    info('Asociatividad y paréntesis',
      'Si hay varios operadores del mismo nivel, se resuelven de izquierda a derecha:\n• 10 - 4 - 3 = (10 - 4) - 3 = 3\n• 8 / 4 / 2 = (8 / 4) / 2 = 1\n\nSi quieres otro orden, usa paréntesis. Se pueden anidar todo lo que necesites: (2 + 3) * 4 da 20.',
      `Esqueleto Principal --> {
  ImpConsSl(10 - 4 - 3);
  ImpConsSl(8 / 4 / 2);
  ImpConsSl(((2 + 3) * (4 - 1)) / 5);
};`),
    opcion('¿Cuánto da 10 - 4 - 3?',
      ['3', '9', '-3', '7'], 0,
      'Los operadores del mismo nivel se resuelven de izquierda a derecha: (10 - 4) - 3 = 3.'),
    armar('Forma la expresión que da 20',
      ['(', '2', '+', '3', ')', '*', '4'], ['[', ']'],
      '(2 + 3) * 4 = 20 porque el paréntesis se calcula primero.'),

    info('Negación, ^ y ||',
      'La negación ! pega más fuerte que la comparación: !&a > 3 se lee (!&a) > 3.\n\nEntre los lógicos, ^ se calcula antes que ||. Por eso:\n!&a ^ &b || &c  se lee  ((!&a) ^ &b) || &c\n\nUna llamada a función también es un valor, así que -Doble(4) es válido. Los arreglos y listas NO forman parte de las expresiones.',
      `Esqueleto Principal --> {
  &a(boo):=falso;
  &b(boo):=verdadero;
  &c(boo):=falso;
  ImpConsSl("!a ^ b || c = " -> !&a ^ &b || &c);
  ImpConsSl("((!a) ^ b) || c = " -> ((!&a) ^ &b) || &c);
  ImpConsSl("!(a || b) = " -> !(&a || &b));
};`),
    opcion('¿Cómo se lee !&a ^ &b || &c?',
      ['!(a ^ (b || c))', '((!a) ^ b) || c', '(!a) ^ (b || c)', '!((a ^ b) || c)'], 1,
      'La negación pega primero, luego ^ y al final ||.'),
  ] },

  // 5 ───────────────────────────────────────────────
  { id: 'decision', pasos: [
    info('Decidir con ev',
      'ev (evaluar) ejecuta un bloque solo si se cumple una condición, como un «si».\n\nev( (condición) ? { bloque } );\n\n• La condición lleva SUS PROPIOS paréntesis.\n• Después va ? y el bloque entre llaves.\n• Todo el ev va entre paréntesis y termina en ;\n• El bloque puede quedar vacío { } o con { IGNOR; }.',
      `Esqueleto Principal --> {
  &vida(ent):=3;
  ev( (&vida > 0) ? { ImpConsSl("sigues vivo"); } );
};`),
    opcion('¿Cuál condición está bien escrita?',
      ['ev( &a > 3 ? { } );', 'ev( (&a > 3) ? { } );', 'ev( (&a > 3) { } );', 'ev ((&a > 3) -> { })'], 1,
      'La condición lleva sus propios paréntesis, seguida de ? y del bloque.'),
    armar('Arma un ev con el bloque vacío',
      ['ev', '(', '(', '&a', '>', '3', ')', '?', '{', '}', ')', ';'], ['if', 'else'],
      'En ev el bloque puede quedar vacío { } o con { IGNOR; }.'),

    info('Más caminos: evalt y alt',
      'Los caminos se unen con ->:\n• evalt: otra condición que se revisa si las anteriores fallaron (como «si no, y si…»). Puedes poner las que quieras.\n• alt: lo que pasa si nada se cumplió. No lleva condición, va al final y solo una vez.\n\nevalt y alt no pueden ir solos: siempre necesitan un ev antes.',
      `Esqueleto Principal --> {
  &vida(ent):=3;
  ev( (&vida > 5) ? { ImpConsSl("bien"); }
    -> evalt (&vida > 0) ? { ImpConsSl("cuidado"); }
    -> alt { ImpConsSl("sin vida"); } );
};`),
    opcion('¿Qué palabra funciona como "else if"?',
      ['alt', 'evalt', 'sino', 'ev2'], 1,
      'evalt es otra condición que se revisa si las anteriores fallaron. Puedes poner varias.'),
    completar('Falta el camino final',
      `ev( (&a > 3) ? { ImpConsSl("si"); }
  -> ___ { ImpConsSl("no"); } );`,
      ['alt', 'evalt', 'else', 'ev'], 0,
      'alt es el camino sin condición. Va al final y solo una vez.'),

    info('Cómo se revisan las condiciones',
      'Se revisan en orden, de arriba hacia abajo. En cuanto una se cumple, se ejecuta su bloque y se ignora todo lo demás. Si ninguna se cumple y existe alt, se ejecuta alt.\n\nPuedes meter un ev dentro de otro (anidar) cuantas veces necesites.',
      `Esqueleto Principal --> {
  &nota(ent):=85;
  ev( (&nota => 90) ? { ImpConsSl("A"); }
    -> evalt (&nota => 80) ? { ImpConsSl("B"); }
    -> evalt (&nota => 70) ? { ImpConsSl("C"); }
    -> alt { ImpConsSl("reprobado"); } );
};`),
    opcion('Si una condición se cumple, ¿qué pasa con las demás?',
      ['Se evalúan igual', 'Se ejecuta su bloque y se ignora el resto', 'Da error', 'Solo se ejecuta alt'], 1,
      'Las condiciones se revisan en orden y se ejecuta solo la primera que se cumple.'),
  ] },

  // 6 ───────────────────────────────────────────────
  { id: 'repeticion', pasos: [
    info('Las partes de rep',
      'rep es el único ciclo de DENVI: hace lo que for y while hacen en otros lenguajes. Junta tres cosas en un solo encabezado:\n\nrep( (&i(ent):=0) -> (&i < 5) ? { ... } : ++ );\n\n• (&i(ent):=0) → el inicio: crea la variable (sin ; aquí).\n• (&i < 5) → la condición: se revisa ANTES de cada vuelta; mientras sea verdadera, sigue.\n• { ... } → el bloque que se repite.\n• : ++ → lo que se le hace a la variable al terminar cada vuelta.\n\nTermina siempre con ; después del paréntesis final.',
      `Esqueleto Principal --> {
  rep( (&i(ent):=0) -> (&i < 5) ? { ImpConsSl(&i); } : ++ );
};`),
    opcion('¿Qué estructura cubre lo que for y while hacen en otros lenguajes?',
      ['loop', 'rep', 'ciclo', 'mientras'], 1,
      'rep es el único ciclo de DENVI.'),
    opcion('¿Cuántas veces se ejecuta el bloque en rep( (&i(ent):=0) -> (&i < 3) ? { ... } : ++ );?',
      ['2', '3', '4', 'Infinitas'], 1,
      'i vale 0, 1 y 2. Cuando llega a 3 la condición es falsa.'),

    info('Incrementos de rep',
      'Después de los dos puntos va el incremento:\n• ++ suma 1 y -- resta 1.\n• +?(n) suma n y -?(n) resta n.\n\nPara contar hacia atrás, empieza en un número alto, usa una condición como (&i > 0) y el incremento --.',
      `Esqueleto Principal --> {
  rep( (&i(ent):=5) -> (&i > 0) ? { ImpConsSl(&i); } : -- );
  ImpConsSl("despegue!");
  rep( (&j(ent):=0) -> (&j =< 10) ? { ImpCons(&j -> " "); } : +?(2) );
  ImpConsSl("");
};`),
    completar('Completa el incremento',
      'rep( (&i(ent):=0) -> (&i < 5) ? { ImpConsSl(&i); } : ___ );',
      ['++', 'i++', '+1', 'siguiente'], 0,
      'Después de los dos puntos va el incremento: ++, --, +?(n) o -?(n).'),
    armar('Forma el incremento "de 2 en 2"',
      [':', '+?', '(', '2', ')'], ['++', '-'],
      '+?(2) suma 2 en cada vuelta.'),

    info('Variables que ya existen',
      'Si el encabezado DECLARA la variable (&i(ent):=0), el incremento actúa sobre ella y no hace falta nombrarla.\n\nPero si el encabezado solo asigna una variable que ya existe (&j:=0), debes indicarla en el incremento: ++(&j) o +?(2, &j).\n\nDentro de un rep puedes usar cualquier instrucción, incluso otros rep o ev.',
      `Esqueleto Principal --> {
  &j(ent):=9;
  rep( (&j:=0) -> (&j < 3) ? { ImpConsSl("vuelta " -> &j); } : ++(&j) );
  ImpConsSl("al salir j vale " -> &j);
};`),
    opcion('Si el encabezado solo asigna una variable que ya existe (&j:=0), el incremento...',
      ['No hace nada', 'Debe nombrar la variable: ++(&j)', 'Se omite', 'Siempre es ++'], 1,
      'Solo cuando el encabezado declara la variable se puede omitir su nombre.'),
  ] },

  // 7 ───────────────────────────────────────────────
  { id: 'entrada', pasos: [
    info('Mostrar datos',
      'ImpCons imprime sin salto de línea; ImpConsSl imprime y salta de línea.\n\nPara juntar varias partes en una sola impresión se usa el conector -> (no la coma ni el +). Puedes imprimir cadenas, variables, constantes, atributos, resultados de operaciones, arreglos y listas. Siempre debe haber algo que imprimir: ImpCons(); no es válido.',
      `Esqueleto Principal --> {
  &vida(ent):=10;
  &puntos(ent):=250;
  ImpCons("vida: ");
  ImpCons(&vida);
  ImpConsSl("");
  ImpConsSl("vida: " -> &vida -> " puntos: " -> &puntos);
  ImpConsSl("total: " -> &vida + &puntos);
};`),
    opcion('¿Con qué se unen las partes de una impresión?',
      ['+', ',', '->', '&'], 2,
      'El conector -> une cadenas, variables y operaciones en un solo ImpCons.'),
    opcion('¿Cuál de estas NO agrega un salto de línea?',
      ['ImpConsSl', 'ImpCons', 'Ambas lo agregan', 'Ninguna lo agrega'], 1,
      'ImpCons imprime sin salto. ImpConsSl sí lo agrega.'),
    armar('Imprime "Hola " seguido del valor de &nombre',
      ['ImpConsSl', '(', '"Hola "', '->', '&nombre', ')', ';'], [',', '+'],
      'Las partes se unen con ->, no con coma ni con +.'),

    info('Recibir datos del teclado',
      'ObtDatos lee un dato y lo guarda en una variable. Se indica el tipo, dos puntos y la variable:\n\nObtDatos(ent:&edad);\nObtDatos(cad:&nombre);\n\nCuando la terminal te lo pida, escribe el dato y pulsa Enter. El dato solo se puede guardar en una variable con & (no en una constante).',
      `Esqueleto Principal --> {
  ImpCons("Cuantos años tienes? ");
  ObtDatos(ent:&edad);
  ImpConsSl("Tienes " -> &edad -> " años");
};`, true, ['25']),
    completar('Lee un número entero',
      'ObtDatos(___:&edad);',
      ['ent', '&', 'int', 'num'], 0,
      'Se escribe el tipo, dos puntos y la variable con &.'),

    info('Dónde va Import',
      'Import trae archivos a tu programa y solo puede ir AL INICIO del archivo, antes de Esqueleto. Lo verás con más detalle en el nivel «Importar archivos».',
      `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(10, 0);
  ImpConsSl("vida: " -> heroe.&vida);
};`),
    opcion('¿Dónde debe ir Import?',
      ['En cualquier parte', 'Al inicio, antes de Esqueleto', 'Dentro de un ev', 'Al final'], 1,
      'Import solo puede ir al inicio del archivo.'),
  ] },

  // 8 ───────────────────────────────────────────────
  { id: 'funciones', pasos: [
    info('Dos formas de agrupar código',
      'Para reutilizar código hay dos opciones:\n• Accion: una función. Se declara en el programa principal.\n• MetaAccion: un método. Vive dentro de una clase y trabaja con ese objeto.\n\nSe declaran con: Nombre con mayúscula, el conector -->, los parámetros entre paréntesis y el cuerpo entre llaves, con ; al final. Si no recibe nada, los paréntesis van vacíos: ().',
      `Esqueleto Principal --> {
  Accion Saludar --> () {
    ImpConsSl("Hola desde una funcion");
  };
  Saludar();
  Saludar();
};`),
    opcion('¿Qué diferencia hay entre Accion y MetaAccion?',
      ['Ninguna', 'Accion es una función y MetaAccion un método de una clase', 'Accion es solo para clases', 'MetaAccion no recibe parámetros'], 1,
      'Una MetaAccion vive dentro de una clase y trabaja con ese objeto.'),
    opcion('Una función sin código, ¿cómo se escribe?',
      ['{ }', '{ IGNOR; }', '{ nada }', 'No se puede'], 1,
      'En funciones, métodos, clases y programa el cuerpo vacío se escribe { IGNOR; }.'),

    info('Parámetros y retorno',
      'Los parámetros se escriben como variables con su tipo, sin valor inicial y separados por coma: (&a(ent), &b(ent)).\n\nPara devolver un valor, DENVI lo escribe al revés que otros lenguajes: el valor entre paréntesis, punto y retornar.\n(&a + &b).retornar;\n\nPara salir sin devolver nada: ().retornar;\nNo hace falta declarar qué tipo se devuelve.',
      `Esqueleto Principal --> {
  Accion Sumar --> (&a(ent), &b(ent)) {
    (&a + &b).retornar;
  };
  ImpConsSl("3 + 4 = " -> Sumar(3, 4));
  ImpConsSl("10 + 25 = " -> Sumar(10, 25));
};`),
    opcion('¿Cómo se devuelve un valor?',
      ['retornar &a;', 'return(&a);', '(&a).retornar;', '&a.retornar();'], 2,
      'El valor va entre paréntesis, luego punto y retornar.'),
    completar('Completa el retorno',
      `Accion Doble --> (&n(ent)) {
  (&n * 2).___;
};`,
      ['retornar', 'return', 'salir', 'dar'], 0,
      'La palabra reservada es retornar.'),
    opcion('¿Cómo sales de una función sin devolver nada?',
      ['().retornar;', 'retornar;', 'salir;', 'IGNOR;'], 0,
      '().retornar; sale sin devolver ningún valor.'),

    info('Llamar y combinar funciones',
      'Una llamada a función también es un valor, así que puede ir dentro de otra instrucción o de una expresión: ImpConsSl(Doble(5)); o Doble(&x) + 1.\n\nUna función puede llamarse a sí misma (recursión) o llamar a otras. Los retornos pueden ir en cualquier parte, incluso dentro de ev o rep.',
      `Esqueleto Principal --> {
  Accion Doble --> (&n(ent)) {
    (&n * 2).retornar;
  };
  Accion Factorial --> (&n(ent)) {
    ev( (&n =< 1) ? { (1).retornar; } );
    (&n * Factorial(&n - 1)).retornar;
  };
  ImpConsSl(Doble(5));
  ImpConsSl("5! = " -> Factorial(5));
};`),
    armar('Imprime el resultado de llamar a Doble con 5',
      ['ImpConsSl', '(', 'Doble', '(', '5', ')', ')', ';'], ['Accion', 'retornar'],
      'Una llamada a función también es un valor, así que puede ir dentro de otra instrucción.'),
  ] },

  // 9 ───────────────────────────────────────────────
  { id: 'clases', pasos: [
    info('Declarar una clase',
      'Una clase es el molde de un elemento del juego (un jugador, un obstáculo…). Se declara con Esqueleto, un nombre con mayúscula, --> y entre paréntesis sus atributos con tipo. Entre llaves van sus métodos (MetaAccion).\n\nEsqueleto Jugador --> (&vida(ent), &puntos(ent)) { MetaAccion Curar --> (&cantidad(ent)) { @esto.&vida := @esto.&vida + &cantidad; }; };\n\nDentro de un método, @esto es el objeto actual. Una clase solo contiene métodos; si no tiene, se escribe { IGNOR; }.\n\nEsqueleto Principal también es una clase, pero especial: es el punto de entrada y solo hay una por archivo .dnv.',
      `Esqueleto Jugador --> (&vida(ent), &puntos(ent)) {
  MetaAccion Curar --> (&cantidad(ent)) {
    @esto.&vida := @esto.&vida + &cantidad;
  };
};`, false),
    opcion('¿Con qué palabra se declara una clase?',
      ['class', 'Esqueleto', 'Clase', 'Objeto'], 1,
      'Esqueleto declara una clase. Esqueleto Principal es el punto de entrada del programa.'),
    opcion('¿Qué representa @esto?',
      ['La clase padre', 'El objeto actual, dentro de un método', 'Un archivo', 'Una constante'], 1,
      '@esto solo tiene sentido dentro de un método: @esto.&vida es el atributo del objeto actual.'),

    info('Crear y usar objetos',
      'Un objeto se crea con iniciar, pasando los valores de los atributos en orden. El nombre del objeto va en minúsculas y sin símbolo:\nJugador heroe := iniciar(10, 0);\n\nDesde fuera se usa el punto:\n• heroe.&vida → atributo\n• heroe.Curar(5) → método\n• heroe.&vida := 3; → asignar un atributo\n\nCada objeto es independiente: curar a uno no cambia a otro.\n\nEstos ejemplos usan las clases de juego.clase.dnv (Jugador, Mago, Obstaculo y Recompensa).',
      `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador ana := iniciar(10, 0);
  Jugador luis := iniciar(20, 5);
  ana.Curar(5);
  ImpConsSl("ana -> vida " -> ana.&vida);
  ImpConsSl("luis -> vida " -> luis.&vida);
};`),
    completar('Crea un objeto',
      'Jugador heroe := ___(10, 0);',
      ['iniciar', 'new', 'crear', 'Jugador'], 0,
      'iniciar recibe los valores de los atributos, en orden.'),
    armar('Imprime la vida del objeto heroe',
      ['ImpConsSl', '(', 'heroe', '.', '&vida', ')', ';'], ['->', '@esto'],
      'Desde fuera se accede con objeto.&atributo.'),
    opcion('¿Cómo se escribe el nombre de un objeto?',
      ['Heroe', 'heroe', '&heroe', '#heroe'], 1,
      'Los objetos van en minúsculas y sin símbolo.'),

    info('Herencia',
      'Una clase puede heredar de otra con ObtieneDe. La clase hija recibe los atributos y métodos de la padre y puede agregar los suyos:\n\nEsqueleto Mago --> ObtieneDe Jugador --> (&mana(ent)) { ... };\n\nPor eso un Mago puede usar Curar (de Jugador) y Lanzar (propio).',
      `Import juego.clase.dnv;
Esqueleto Principal --> {
  Mago gandalf := iniciar(30, 0, 50);
  gandalf.Lanzar(20);
  gandalf.Curar(5);
  ImpConsSl("vida: " -> gandalf.&vida -> " mana: " -> gandalf.&mana);
};`),
    completar('Completa la herencia',
      'Esqueleto Mago --> ___ Jugador --> (&mana(ent)) { IGNOR; };',
      ['ObtieneDe', 'extends', 'hereda', 'Import'], 0,
      'ObtieneDe indica la clase padre.'),
  ] },

  // 10 ──────────────────────────────────────────────
  { id: 'escenarios', pasos: [
    info('Niveles y Viajar',
      'Un Nivel es un escenario del juego. Lleva sus propiedades entre paréntesis (pueden ser vacías) y su código entre llaves:\n\nNivel Cueva -> (() { ... });\n\nDeclarar un nivel NO lo activa. Para entrar a él se usa Viajar(Cueva);\nLos nombres de niveles llevan mayúscula inicial.',
      `Esqueleto Principal --> {
  Nivel Pradera -> (() {
    ImpConsSl("entraste a la pradera");
  });
  Nivel Desierto -> (() {
    ImpConsSl("entraste al desierto");
  });
  ImpConsSl("niveles declarados, aun no viajas");
  Viajar(Desierto);
};`),
    opcion('¿Qué hace declarar un Nivel?',
      ['Lo activa', 'Solo lo declara; para entrar se usa Viajar', 'Lo elimina', 'Crea una zona'], 1,
      'El nivel activo solo cambia con Viajar.'),
    completar('Entra al nivel',
      `Nivel Cueva -> (() { IGNOR; });
___(Cueva);`,
      ['Viajar', 'Situar', 'Retirar', 'Portal'], 0,
      'Viajar cambia el nivel activo.'),

    info('Portales y zonas',
      '• Portal: conecta un nivel con uno o varios destinos. Puede ir al final de la declaración o escribirse aparte: Bosque.Portal --> (Cueva, Salida);\n• Zona: un subescenario dentro de un nivel. Se separan con comas y no llevan ; propio.\n\nUn nivel lleva código normal O zonas, pero no ambos a la vez. Puedes conectar un nivel con otro que declares más abajo.',
      `Esqueleto Principal --> {
  Nivel Bosque -> (() {
    ImpConsSl("Estas en el bosque");
  }).Portal --> Cueva;
  Nivel Cueva -> (() {
    ImpConsSl("Estas en la cueva");
  });
  Viajar(Bosque);
  Viajar(Cueva);
};`),
    opcion('¿Qué conecta un nivel con otro?',
      ['Zona', 'Portal', 'Suceso', 'Situar'], 1,
      'Portal registra una conexión hacia uno o varios destinos.'),
    opcion('¿Puede un nivel tener a la vez código y zonas?',
      ['Sí', 'No: lleva código o zonas, no ambos', 'Solo si tiene Portal', 'Solo sin propiedades'], 1,
      'Un nivel trae código normal o zonas separadas por comas.'),

    info('Situar y Retirar',
      '• Situar(roca -> (2, 3)); coloca un objeto en la posición (x, y). Las posiciones pueden ser operaciones, como (1 + 1, 2 * 2).\n• Si lo haces fuera de un nivel, indicas cuál al final: Situar(llave -> (1, 1) -> Cueva);\n• Retirar(moneda); quita un objeto del juego; ya no participa en sucesos.\n\nLos obstáculos y recompensas son objetos de tus propias clases, creados con iniciar.',
      `Import juego.clase.dnv;
Esqueleto Principal --> {
  Obstaculo roca := iniciar(3);
  Nivel Cueva -> (() {
    ImpConsSl("Entras a la cueva");
  });
  Viajar(Cueva);
  Situar(roca -> (1 + 1, 2 * 2));
  ImpConsSl("roca colocada en (2, 4)");
  Retirar(roca);
  ImpConsSl("roca retirada");
};`),
    opcion('¿Cuál coloca la roca en la posición (2, 3)?',
      ['Situar(roca -> (2, 3));', 'Situar(roca, 2, 3);', 'Situar(roca -> 2, 3);', 'Situar(roca (2, 3));'], 0,
      'La posición va entre paréntesis y unida al objeto con ->.'),
    armar('Quita la moneda del juego',
      ['Retirar', '(', 'moneda', ')', ';'], ['Quitar', 'Situar'],
      'Retirar saca un objeto del juego. Ya no participa en sucesos.'),
  ] },

  // 11 ──────────────────────────────────────────────
  { id: 'arreglos', pasos: [
    info('Arreglos y listas',
      'Sirven para guardar varios valores del MISMO tipo.\n• Arreglo: se declara con ar y sus valores van entre corchetes [ ]. Se puede anidar.\n• Lista: se declara con lt y sus valores van entre llaves { }. No se anida.\n\nSi cambias los signos (llaves en un arreglo o corchetes en una lista) hay error.',
      `Esqueleto Principal --> {
  ar &pos(ent):=[1, 2, 3];
  ar &m(ent):=[1, [2, 3]];
  lt &letras(car):={'a', 'b'};
  ImpConsSl("arreglo: " -> &pos);
  ImpConsSl("anidado: " -> &m);
  ImpConsSl("lista: " -> &letras);
};`),
    opcion('¿Qué signos usa un arreglo?',
      ['[ ]', '{ }', '( )', '< >'], 0,
      'Arreglos con corchetes y listas con llaves.'),
    opcion('¿Cuál de las dos se puede anidar?',
      ['La lista', 'El arreglo', 'Las dos', 'Ninguna'], 1,
      'Un arreglo puede contener otros arreglos. Una lista no.'),
    completar('Declara una lista de caracteres',
      "___ &letras(car):={'a', 'b'};",
      ['lt', 'ar', 'list', 'arr'], 0,
      'lt declara una lista.'),
    armar('Declara el arreglo [1, 2, 3]',
      ['ar', '&pos', '(', 'ent', ')', ':=', '[', '1', ',', '2', ',', '3', ']', ';'], ['{', '}'],
      'ar, nombre con &, tipo, := y los valores entre corchetes.'),

    info('Qué pueden contener y cómo se usan',
      'Pueden contener valores literales, variables (&a) y constantes (#k), siempre del tipo declarado. También pueden empezar vacíos: ar &v(ent):=[]; o lt &l(ent):={};\n\nSe pueden reasignar, imprimir, retornar y pasar como parámetro (ar &v(ent)) o (lt &l(ent)). Con Mundo delante son globales.\n\nReglas: no se permite coma final ([1, 2,]) ni elementos vacíos ([1,,2]). Y NO forman parte de las expresiones: no se pueden sumar ni comparar.',
      `Esqueleto Principal --> {
  &a(ent):=7;
  #k(ent):=9;
  ar &mezcla(ent):=[&a, 2, #k];
  ar &vacio(ent):=[];
  ImpConsSl("mezcla: " -> &mezcla);
  &mezcla:=[7, 8, 9];
  ImpConsSl("reasignado: " -> &mezcla);
  Accion Mostrar --> (ar &v(ent)) {
    ImpConsSl("recibi: " -> &v);
  };
  Mostrar(&mezcla);
};`),
    opcion('¿Se pueden sumar dos arreglos con +?',
      ['Sí', 'No: no forman parte de las expresiones', 'Solo las listas', 'Solo con Mundo'], 1,
      'Los arreglos y las listas se asignan, imprimen y pasan, pero no se operan con +, - ni comparaciones.'),
  ] },

  // 12 ──────────────────────────────────────────────
  { id: 'sucesos', pasos: [
    info('Qué es un Suceso',
      'Un Suceso registra una regla: «cuando pase esto, ejecuta este bloque». Con ellos el juego reacciona a lo que hacen los objetos.\n\nHay dos formas:\n• Forma corta: un objeto y un tipo de suceso → Suceso((heroe, Toma) -> { ... });\n• Forma general: una condición libre → Suceso((heroe.&vida =< 0) -> { ... });\n\nLleva doble paréntesis al inicio y termina en ;',
      `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(10, 0);
  Suceso((heroe.&vida =< 0) -> {
    ImpConsSl("sin vida");
  });
  heroe.&vida := 0;
};`),
    opcion('En la forma general, ¿cuándo se ejecuta el bloque?',
      ['Siempre', 'Cada vez que la condición pasa de falsa a verdadera', 'Una sola vez en todo el programa', 'Cada segundo'], 1,
      'No se repite mientras la condición siga siendo verdadera.'),
    armar('Suceso que se activa cuando la vida llega a 0 o menos',
      ['Suceso', '(', '(', 'heroe', '.', '&vida', '=<', '0', ')', '->', '{', '}', ')', ';'], ['<=', '=>'],
      'Doble paréntesis, condición, -> y el bloque. Termina en ;'),

    info('Los tipos de suceso',
      'En la forma corta eliges un tipo del catálogo:\n• Choque: el objeto ocupa la misma posición que otro objeto (un obstáculo).\n• Toma: el objeto coincide en posición con una recompensa.\n• Ingreso: el objeto entra a un nivel o zona.\n• Egreso: el objeto sale de un nivel o zona.\n\nEl objeto va en minúsculas y debe estar declarado. Dentro del bloque puedes usar cualquier instrucción: imprimir, ev, rep, Retirar, Viajar…',
      `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(10, 0);
  Recompensa moneda := iniciar(5);
  Nivel Pradera -> (() {
    ImpConsSl("Bienvenido a la pradera");
  });
  Viajar(Pradera);
  Situar(moneda -> (2, 3));
  Suceso((heroe, Toma) -> {
    ImpConsSl("el heroe tomo la moneda");
    Retirar(moneda);
  });
  Situar(heroe -> (0, 0));
  Situar(heroe -> (2, 3));
};`),
    completar('El héroe toma una recompensa',
      'Suceso((heroe, ___) -> { Retirar(moneda); });',
      ['Toma', 'Choque', 'toma', 'Egreso'], 0,
      'Toma ocurre cuando el objeto coincide en posición con una recompensa.'),
    opcion('¿Cuál NO está en el catálogo de tipos de suceso?',
      ['Choque', 'Toma', 'Salto', 'Egreso'], 2,
      'Los tipos son Choque, Toma, Ingreso y Egreso. Agregar uno nuevo solo requiere ampliar el catálogo.'),

    info('Errores típicos con sucesos',
      'El tipo se escribe con mayúscula inicial:\n• (heroe, choque) con minúscula → error sintáctico.\n• (heroe, Chocar) con mayúscula pero fuera del catálogo → error semántico.\n\nEn la forma general la condición debe dar un valor booleano. Y un objeto retirado con Retirar ya no participa en sucesos.',
      `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(2, 0);
  Obstaculo roca := iniciar(3);
  Nivel Cueva -> (() {
    ImpConsSl("Entras a la cueva");
  });
  Viajar(Cueva);
  Situar(roca -> (1, 1));
  Suceso((heroe, Choque) -> {
    heroe.&vida := heroe.&vida - roca.&dano;
    ImpConsSl("choque! vida: " -> heroe.&vida);
    Retirar(roca);
  });
  Situar(heroe -> (1, 1));
};`),
    opcion('Escribir el tipo en minúscula, (heroe, choque), es...',
      ['Válido', 'Un error sintáctico', 'Un error semántico', 'Solo un aviso'], 1,
      'Los tipos llevan mayúscula inicial. Uno con mayúscula pero fuera del catálogo (Chocar) es error semántico.'),
  ] },

  // 13 ──────────────────────────────────────────────
  { id: 'importar', pasos: [
    info('Por qué existen los archivos de clases',
      'Un ejecutable .dnv tiene una sola clase: Esqueleto Principal. Las clases propias (Jugador, Obstaculo…) se guardan en archivos .clase.dnv y se importan con Import.\n\nUn archivo de clases contiene SOLO clases y nunca Esqueleto Principal. Se importa por su nombre, sin comillas ni ruta:\nImport juego.clase.dnv;',
      `Import juego.clase.dnv;
Esqueleto Principal --> {
  Obstaculo roca := iniciar(3);
  ImpConsSl("dano: " -> roca.&dano);
};`),
    opcion('Un archivo de clases importable termina en...',
      ['.dnv', '.clase.dnv', '.class', '.cls'], 1,
      'jugador.dnv no se puede importar. Debe ser jugador.clase.dnv.'),
    completar('Importa el archivo de clases',
      '___ juego.clase.dnv;',
      ['Import', 'Importar', 'using', 'include'], 0,
      'La palabra reservada es Import, con la I mayúscula.'),
    opcion('¿Puede un archivo .clase.dnv contener Esqueleto Principal?',
      ['Sí', 'No: solo contiene clases', 'Solo si importa otro archivo', 'Solo una vez'], 1,
      'Principal es palabra reservada y no es un nombre de clase válido en un archivo de clases.'),

    info('Archivos externos y varios imports',
      'Imágenes, textos u otros archivos se importan con su ruta ENTRE COMILLAS DOBLES: Import "datos.txt";\n\nPuedes escribir varios Import, uno por línea, todos al inicio. Reglas:\n• Termina en ;\n• No se puede importar dentro de un bloque.\n• El archivo de clases debe existir; si no, aparece un error de importación inválida.\n• Nombre inválido: mi-mundo.clase.dnv (el guion medio no está permitido).',
      `Import juego.clase.dnv;
Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(1, 1);
  ImpConsSl("puntos: " -> heroe.&puntos);
};`),
    opcion('¿Cómo se importa un archivo externo, como un texto o una imagen?',
      ['Sin comillas', 'Con su ruta entre comillas dobles', 'Con comillas simples', 'No se puede'], 1,
      'Import "datos.txt"; Los archivos de clases, en cambio, se escriben por nombre y sin comillas.'),
    armar('Importa el archivo externo "datos.txt"',
      ['Import', '"datos.txt"', ';'], ['Importar', "'datos.txt'"],
      'La ruta va entre comillas dobles y la instrucción termina en ;'),
  ] },

  // 14 ──────────────────────────────────────────────
  { id: 'nombres', pasos: [
    info('Cada nombre se ve distinto',
      'DENVI quiere que reconozcas qué es cada cosa a simple vista:\n• Variables y atributos: & y minúscula inicial (&vida)\n• Constantes: # y minúscula inicial (#max)\n• Clases, métodos, funciones, niveles, zonas y tipos de suceso: mayúscula inicial (Jugador, Curar, Bosque)\n• Objetos: todo en minúsculas y sin símbolo (heroe, roca1)',
      `Import juego.clase.dnv;
Esqueleto Principal --> {
  &vida(ent):=10;
  #max(ent):=100;
  Accion Saludar --> () {
    ImpConsSl("Hola desde una funcion");
  };
  Jugador heroe := iniciar(&vida, 0);
  Saludar();
  ImpConsSl("variable &vida: " -> &vida);
  ImpConsSl("constante #max: " -> #max);
  ImpConsSl("objeto heroe: " -> heroe.&vida);
};`),
    opcion('¿Con qué símbolo empieza una constante?',
      ['&', '#', '@', '$'], 1,
      '# para constantes y & para variables y atributos.'),
    opcion('¿Cómo se escribe el nombre de un objeto?',
      ['Heroe', 'heroe', '&heroe', 'HEROE'], 1,
      'Los objetos van en minúsculas y sin símbolo.'),
    completar('Completa el prefijo de una variable',
      '___vida(ent):=10;',
      ['&', '#', '@', '$'], 0,
      'El & es parte del nombre de la variable.'),

    info('Caracteres permitidos',
      'Los nombres usan letras de la a a la z (sin ñ ni acentos) y dígitos. No llevan espacios, guion medio ni guion bajo, y no pueden empezar con número. Se recomienda camelCase: &edadMaxima.\n\nDentro de cadenas y comentarios SÍ puedes usar acentos, ñ y cualquier símbolo.\n\nLas mayúsculas importan: &Color no es válido (una variable empieza con minúscula) e ImpConsSL no existe, se escribe ImpConsSl.',
      `Esqueleto Principal --> {
  &edadMaxima(ent):=90;
  &x1(ent):=1;
  &mensaje(cad):="Ñandú, canción y más";
  ::: los comentarios también aceptan acentos
  ImpConsSl(&mensaje -> " " -> &edadMaxima -> " " -> &x1);
};`),
    opcion('¿Cuál es un nombre de variable válido?',
      ['&edad_max', '&Edad', '&edadMax', 'edad'], 2,
      'Debe llevar &, empezar con minúscula y no tener guion bajo.'),

    info('Palabras reservadas',
      'Algunas palabras son parte fija del lenguaje y no se pueden usar como nombre de clase, método, función, nivel o zona:\nMundo, Esqueleto, Principal, MetaAccion, Accion, ObtieneDe, Suceso, Nivel, Zona, Portal, Situar, Retirar, Viajar, Import, ImpCons, ImpConsSl, ObtDatos.\n\nTampoco se pueden usar como nombre de objeto: ent, dec, cad, car, boo, tm, nl, lt, ar, ev, evalt, alt, rep, iniciar, retornar, verdadero, falso, nulo.\n\nIGNOR y @esto también son fijas.'),
    opcion('¿Puedes llamar Nivel a una clase?',
      ['Sí', 'No: es palabra reservada', 'Solo en minúsculas', 'Solo dentro de Principal'], 1,
      'Las palabras reservadas no se pueden usar como nombre de clase, método, función, nivel o zona.'),
  ] },

  // 15 ──────────────────────────────────────────────
  { id: 'errores', pasos: [
    info('Cómo leer un error',
      'Cuando algo sale mal, DENVI muestra un mensaje con esta forma:\n• Error: el tipo de error\n• Archivo: dónde ocurrió\n• Lugar: la línea y la columna\n• Causa: qué pasó\n• Ayuda: cómo arreglarlo\n\nEmpieza leyendo Lugar, luego Causa y Ayuda. A veces el problema real está en la línea ANTERIOR a la señalada.\n\nPulsa «Probar código» para ver un error real: a este programa le falta un ;',
      `Esqueleto Principal --> {
  ImpConsSl("hola")
};`),
    opcion('¿Qué error tiene ImpConsSl("hola") sin nada más al final?',
      ['Falta el ;', 'Faltan los paréntesis', 'No tiene error', 'Sobran las comillas'], 0,
      'Toda instrucción completa termina en ;'),

    info('Cuatro tipos de error',
      '• Léxico: hay algo que DENVI no reconoce, como >= en lugar de =>.\n• Sintáctico: la estructura está mal escrita (falta un ;, o una condición sin paréntesis).\n• Semántico: está bien escrito pero no tiene sentido (guardar "hola" en un ent, usar una variable que no existe).\n• De importación: el archivo de clases no se encuentra.',
      `Esqueleto Principal --> {
  &a(ent):="hola";
  ImpConsSl(&a);
};`),
    opcion('&a(ent):="hola"; es un error...',
      ['Léxico', 'Semántico: el valor no coincide con el tipo', 'Sintáctico', 'No es error'], 1,
      'Está bien escrito, pero no tiene sentido: un ent no guarda texto.'),

    info('Los errores más comunes',
      '1. Olvidar el ; al final de una instrucción.\n2. Escribir = en vez de := para asignar.\n3. Escribir >= o <= en vez de => y =<.\n4. Usar && o and en lugar de ^, y | en lugar de ||.\n5. Dejar { } vacío en una clase, método, función o programa (se escribe { IGNOR; }).\n6. Escribir la condición de ev sin sus paréntesis.\n7. Usar return en lugar de (valor).retornar;\n8. Olvidar el & de una variable o el # de una constante.\n9. Confundir comillas: "hola" es cadena y \'a\' es carácter.\n10. Poner evalt o alt sin un ev antes.\n\nLa mejor forma de aprender es romper el código a propósito y leer el mensaje.'),
    opcion('¿Qué error tiene &a(ent) = 5;?',
      ['Falta el ;', 'La asignación es :=', 'ent no existe', 'No tiene error'], 1,
      'En DENVI se asigna con :=.'),
    opcion('¿Qué error tiene &r(boo):=&a >= 3;?',
      ['Se escribe =>', 'Falta el ;', '>= es válido', 'boo no existe'], 0,
      'Mayor o igual es =>, y menor o igual es =<.'),
    opcion('¿Qué error tiene Accion F --> () { };?',
      ['El cuerpo vacío debe ser IGNOR;', 'Falta retornar', 'El nombre va en minúscula', 'No tiene error'], 0,
      'En funciones, métodos, clases y programa nunca se deja { } vacío.'),
    armar('Escribe la función vacía correctamente',
      ['Accion', 'F', '-->', '(', ')', '{', 'IGNOR', ';', '}', ';'], ['retornar', '=>'],
      'Cuerpo con IGNOR; y el ; final de la función.'),
  ] },
]