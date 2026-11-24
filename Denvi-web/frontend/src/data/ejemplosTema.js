// Ejemplos ejecutables por tema (clave = id en temas.js).
// nivel: 'Básico' | 'Intermedio' | 'Avanzado'
// entradas: lo que se le "teclea" a ObtDatos, una por línea.
// Ojo: dentro de las plantillas ` ` los escapes de DENVI se escriben con doble barra (\\n, \\").
// Los ejemplos que empiezan con Import juego.clase.dnv necesitan ese archivo en el backend.
export const ejemplosTema = {
  intro: [
    { nombre: 'Hola mundo', nivel: 'Básico', codigo: `::: Mi primer programa
Esqueleto Principal --> {
  ImpConsSl("Hola mundo");
};` },
    { nombre: 'Comentarios', nivel: 'Básico', codigo: `::: comentario de una línea
::* comentario
   de varias líneas *::
Esqueleto Principal --> {
  ImpConsSl("Los comentarios se ignoran");
};` },
    { nombre: 'Varias líneas de salida', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  ImpConsSl("Linea 1");
  ImpConsSl("Linea 2");
  ImpConsSl("Linea 3");
};` },
    { nombre: 'Con y sin salto', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  ImpCons("Hola ");
  ImpCons("sin ");
  ImpConsSl("salto");
  ImpConsSl("Ahora si hay salto");
};` },
    { nombre: 'Código en una sola línea', nivel: 'Intermedio', codigo: `Esqueleto Principal --> { ImpConsSl("Los espacios y saltos se ignoran"); ImpConsSl("puedes acomodar el codigo como quieras"); };` },
    { nombre: 'Comentario dentro de una cadena', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  ::: este comentario no se imprime
  ImpConsSl("::: esto SI se imprime");
};` },
    { nombre: 'Escapes en cadenas', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  ImpConsSl("Linea 1\\nLinea 2");
  ImpConsSl("Col 1\\tCol 2");
  ImpConsSl("Dijo \\"hola\\"");
  ImpConsSl("Barra: \\\\");
};` },
  ],

  tipos: [
    { nombre: 'Variables y constantes', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  &vida(ent):=10;
  &nombre(cad):="Heroe";
  #max(ent):=100;
  ImpConsSl(&nombre -> " tiene " -> &vida -> " de " -> #max);
};` },
    { nombre: 'Enteros y decimales', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  &positivo(ent):=250;
  &negativo(ent):=-25;
  &pi(dec):=3.14;
  &medio(dec):=0.5;
  ImpConsSl("positivo: " -> &positivo);
  ImpConsSl("negativo: " -> &negativo);
  ImpConsSl("pi: " -> &pi);
  ImpConsSl("medio: " -> &medio);
};` },
    { nombre: 'Constantes', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  #gravedad(dec):=9.8;
  #titulo(cad):="Mi juego";
  #maxVidas(ent):=3;
  ImpConsSl(#titulo);
  ImpConsSl("gravedad: " -> #gravedad);
  ImpConsSl("vidas maximas: " -> #maxVidas);
};` },
    { nombre: 'Los tipos básicos', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  &a(ent):=7;
  &pi(dec):=3.14;
  &saludo(cad):="hola";
  &letra(car):='a';
  &activo(boo):=verdadero;
  &duracion(tm):=[1:30];
  ImpConsSl("ent: " -> &a);
  ImpConsSl("dec: " -> &pi);
  ImpConsSl("cad: " -> &saludo);
  ImpConsSl("car: " -> &letra);
  ImpConsSl("boo: " -> &activo);
  ImpConsSl("tm: " -> &duracion);
};` },
    { nombre: 'Declarar sin valor', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  &nombre(cad);
  &puntos(ent);
  &nombre:="Ana";
  &puntos:=40;
  ImpConsSl(&nombre -> " tiene " -> &puntos -> " puntos");
};` },
    { nombre: 'Valores de tiempo (tm)', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  &corto(tm):=[1:30];
  &largo(tm):=[2:15:40];
  &minutos(tm):=[5:];
  &segundos(tm):=[::5];
  ImpConsSl("minuto:segundo -> " -> &corto);
  ImpConsSl("hora:minuto:segundo -> " -> &largo);
  ImpConsSl("5 minutos -> " -> &minutos);
  ImpConsSl("5 segundos -> " -> &segundos);
};` },
    { nombre: 'Arreglos, listas y Mundo', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  ar &pos(ent):=[1, 2, 3];
  ar &m(ent):=[1, [2, 3]];
  lt &letras(car):={'a', 'b'};
  Mundo &total(ent):=0;
  ImpConsSl("arreglo: " -> &pos);
  ImpConsSl("anidado: " -> &m);
  ImpConsSl("lista: " -> &letras);
  ImpConsSl("global: " -> &total);
};` },
    { nombre: 'Arreglo anidado profundo', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  ar &tabla(ent):=[1, [2, [3, 4]], 5];
  lt &nombres(cad):={"Ana", "Luis", "Eva"};
  ImpConsSl("tabla: " -> &tabla);
  ImpConsSl("nombres: " -> &nombres);
};` },
  ],

  asignacion: [
    { nombre: 'Asignar un valor', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  &vida(ent):=5;
  ImpConsSl("antes: " -> &vida);
  &vida:=&vida + 1;
  ImpConsSl("despues: " -> &vida);
};` },
    { nombre: 'Cambiar de valor varias veces', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  &puntos(ent):=0;
  ImpConsSl("inicio: " -> &puntos);
  &puntos:=50;
  ImpConsSl("nivel 1: " -> &puntos);
  &puntos:=&puntos * 2;
  ImpConsSl("nivel 2: " -> &puntos);
};` },
    { nombre: 'Incrementos rápidos', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  &a(ent):=10;
  &a:=++;
  ImpConsSl("++ : " -> &a);
  &a:=+?(3);
  ImpConsSl("+?(3) : " -> &a);
  &a:=--;
  ImpConsSl("-- : " -> &a);
  &a:=-?(2);
  ImpConsSl("-?(2) : " -> &a);
};` },
    { nombre: 'Contador de monedas', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  &monedas(ent):=0;
  &monedas:=++;
  &monedas:=++;
  &monedas:=+?(10);
  ImpConsSl("monedas: " -> &monedas);
  &monedas:=-?(4);
  ImpConsSl("despues de comprar: " -> &monedas);
};` },
    { nombre: 'Operadores aritméticos', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  &a(ent):=17;
  &b(ent):=5;
  ImpConsSl("suma: " -> &a + &b);
  ImpConsSl("resta: " -> &a - &b);
  ImpConsSl("producto: " -> &a * &b);
  ImpConsSl("division: " -> &a / &b);
  ImpConsSl("residuo: " -> &a % &b);
};` },
    { nombre: 'Asignar atributos de un objeto', nivel: 'Intermedio', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(10, 0);
  ImpConsSl("vida inicial: " -> heroe.&vida);
  heroe.&vida:=3;
  heroe.&puntos:=heroe.&puntos + 25;
  ImpConsSl("vida: " -> heroe.&vida -> " puntos: " -> heroe.&puntos);
};` },
    { nombre: 'Signos con espacio', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  &a(ent):=10;
  &b(ent):=3;
  ImpConsSl("a - -b = " -> &a - -&b);
  ImpConsSl("a + +b = " -> &a + +&b);
  ImpConsSl("-a = " -> -&a);
};` },
    { nombre: 'Global desde una función', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  Accion Sumar --> (&n(ent)) {
    Mundo &total:=&total + &n;
  };
  Mundo &total(ent):=0;
  Sumar(5);
  Sumar(10);
  ImpConsSl("total: " -> &total);
};` },
  ],

  expresiones: [
    { nombre: 'Prioridad de operadores', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  ImpConsSl(2 + 3 * 4);
  ImpConsSl((2 + 3) * 4);
  ImpConsSl(10 - 4 - 3);
  ImpConsSl(8 / 4 / 2);
};` },
    { nombre: 'Paréntesis anidados', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  ImpConsSl(((2 + 3) * (4 - 1)) / 5);
  ImpConsSl(2 * (3 + (4 * 5)));
  ImpConsSl((10 - (2 + 3)) * 2);
};` },
    { nombre: 'Expresiones con variables', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  &base(ent):=6;
  &altura(ent):=4;
  ImpConsSl("area del rectangulo: " -> &base * &altura);
  ImpConsSl("perimetro: " -> 2 * (&base + &altura));
  ImpConsSl("area del triangulo: " -> &base * &altura / 2);
};` },
    { nombre: 'Asociatividad', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  ImpConsSl(100 / 5 / 2);
  ImpConsSl(20 - 5 - 3);
  ImpConsSl(2 * 3 % 4);
  ImpConsSl(100 - 10 * 2 + 5);
};` },
    { nombre: 'Comparaciones y lógicos', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  &a(ent):=7;
  ImpConsSl(&a > 3);
  ImpConsSl(&a =< 5);
  ImpConsSl((&a > 3) ^ (&a =< 10));
  ImpConsSl((&a == 0) || (&a != 0));
  ImpConsSl(!(&a == 7));
};` },
    { nombre: 'Rango con Y lógico', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  &edad(ent):=15;
  ImpConsSl("esta entre 12 y 17? " -> (&edad => 12) ^ (&edad =< 17));
  ImpConsSl("es menor de 10 o mayor de 60? " -> (&edad < 10) || (&edad > 60));
  ImpConsSl("no es adulto? " -> !(&edad => 18));
};` },
    { nombre: 'Precedencia de ! ^ y ||', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  &a(boo):=falso;
  &b(boo):=verdadero;
  &c(boo):=falso;
  ImpConsSl("!a ^ b || c = " -> !&a ^ &b || &c);
  ImpConsSl("((!a) ^ b) || c = " -> ((!&a) ^ &b) || &c);
  ImpConsSl("!(a || b) = " -> !(&a || &b));
};` },
    { nombre: 'Llamadas dentro de expresiones', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  Accion Doble --> (&n(ent)) {
    (&n * 2).retornar;
  };
  &x(ent):=3;
  ImpConsSl(-Doble(4));
  ImpConsSl(Doble(&x) + Doble(2) * 3);
};` },
    { nombre: 'Signos repetidos', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  &n(ent):=5;
  &ok(boo):=verdadero;
  ImpConsSl(- -&n);
  ImpConsSl(-&n);
  ImpConsSl(!!&ok);
  ImpConsSl(!&ok);
};` },
  ],

  decision: [
    { nombre: 'ev simple', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  &vida(ent):=3;
  ev( (&vida > 0) ? { ImpConsSl("sigues vivo"); } );
};` },
    { nombre: 'ev con alt', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  &puntos(ent):=40;
  ev( (&puntos => 50) ? { ImpConsSl("pasaste de nivel"); }
    -> alt { ImpConsSl("necesitas mas puntos"); } );
};` },
    { nombre: 'ev / evalt / alt', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  &vida(ent):=3;
  ev( (&vida > 5) ? { ImpConsSl("bien"); }
    -> evalt (&vida > 0) ? { ImpConsSl("cuidado"); }
    -> alt { ImpConsSl("sin vida"); } );
};` },
    { nombre: 'Positivo, negativo o cero', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  &n(ent):=-4;
  ev( (&n > 0) ? { ImpConsSl("positivo"); }
    -> evalt (&n < 0) ? { ImpConsSl("negativo"); }
    -> alt { ImpConsSl("es cero"); } );
};` },
    { nombre: 'Varios evalt: calificación', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  &nota(ent):=85;
  ev( (&nota => 90) ? { ImpConsSl("A"); }
    -> evalt (&nota => 80) ? { ImpConsSl("B"); }
    -> evalt (&nota => 70) ? { ImpConsSl("C"); }
    -> alt { ImpConsSl("reprobado"); } );
};` },
    { nombre: 'Par o impar (con entrada)', nivel: 'Intermedio', entradas: ['15'], codigo: `Esqueleto Principal --> {
  ObtDatos(ent:&n);
  ev( (&n % 2 == 0) ? { ImpConsSl(&n -> " es par"); }
    -> alt { ImpConsSl(&n -> " es impar"); } );
};` },
    { nombre: 'Bloque vacío con IGNOR', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  &a(ent):=2;
  ev( (&a > 3) ? { IGNOR; }
    -> alt { ImpConsSl("a no es mayor que 3"); } );
};` },
    { nombre: 'ev anidado', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  &edad(ent):=20;
  &tieneEntrada(boo):=verdadero;
  ev( (&edad => 18) ? {
        ev( (&tieneEntrada) ? { ImpConsSl("puede pasar"); }
          -> alt { ImpConsSl("compra una entrada"); } );
      }
    -> alt { ImpConsSl("menor de edad"); } );
};` },
  ],

  repeticion: [
    { nombre: 'Contar', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  rep( (&i(ent):=0) -> (&i < 5) ? { ImpConsSl(&i); } : ++ );
};` },
    { nombre: 'Cuenta regresiva', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  rep( (&i(ent):=5) -> (&i > 0) ? { ImpConsSl(&i); } : -- );
  ImpConsSl("despegue!");
};` },
    { nombre: 'Pares con +?(2)', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  rep( (&i(ent):=0) -> (&i =< 10) ? { ImpCons(&i -> " "); } : +?(2) );
  ImpConsSl("");
  ImpConsSl("fin");
};` },
    { nombre: 'Tabla del 3', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  rep( (&i(ent):=1) -> (&i =< 5) ? {
    ImpConsSl("3 x " -> &i -> " = " -> 3 * &i);
  } : ++ );
};` },
    { nombre: 'Suma acumulada', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  &suma(ent):=0;
  rep( (&i(ent):=1) -> (&i =< 10) ? { &suma:=&suma + &i; } : ++ );
  ImpConsSl("suma de 1 a 10: " -> &suma);
};` },
    { nombre: 'Par o impar', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  rep( (&i(ent):=1) -> (&i =< 6) ? {
    ev( (&i % 2 == 0) ? { ImpConsSl(&i -> " es par"); }
      -> alt { ImpConsSl(&i -> " es impar"); } );
  } : ++ );
};` },
    { nombre: 'Variable existente: ++(&j)', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  &j(ent):=9;
  rep( (&j:=0) -> (&j < 3) ? { ImpConsSl("vuelta " -> &j); } : ++(&j) );
  ImpConsSl("al salir j vale " -> &j);
};` },
    { nombre: 'Ciclos anidados', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  rep( (&f(ent):=1) -> (&f =< 3) ? {
    rep( (&c(ent):=1) -> (&c =< 3) ? { ImpCons(&f * &c -> " "); } : ++ );
    ImpConsSl("");
  } : ++ );
};` },
  ],

  entrada: [
    { nombre: 'ImpCons e ImpConsSl', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  &vida(ent):=10;
  &puntos(ent):=250;
  ImpConsSl("vida: " -> &vida -> " puntos: " -> &puntos);
};` },
    { nombre: 'Imprimir operaciones', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  &a(ent):=6;
  &b(ent):=4;
  ImpConsSl(&a + &b);
  ImpConsSl("a * b = " -> &a * &b);
  ImpConsSl(&a > &b);
};` },
    { nombre: 'Leer la edad', nivel: 'Intermedio', entradas: ['25'], codigo: `Esqueleto Principal --> {
  ObtDatos(ent:&edad);
  ImpConsSl("Tienes " -> &edad -> " años");
};` },
    { nombre: 'Saludo personalizado', nivel: 'Intermedio', entradas: ['Luis'], codigo: `Esqueleto Principal --> {
  ImpCons("Como te llamas? ");
  ObtDatos(cad:&nombre);
  ImpConsSl("Hola " -> &nombre -> ", bienvenido a DENVI");
};` },
    { nombre: 'Sumar dos números', nivel: 'Intermedio', entradas: ['8', '4'], codigo: `Esqueleto Principal --> {
  ObtDatos(ent:&a);
  ObtDatos(ent:&b);
  ImpConsSl(&a -> " + " -> &b -> " = " -> &a + &b);
};` },
    { nombre: 'Promedio de tres notas', nivel: 'Intermedio', entradas: ['80', '90', '70'], codigo: `Esqueleto Principal --> {
  ObtDatos(ent:&n1);
  ObtDatos(ent:&n2);
  ObtDatos(ent:&n3);
  ImpConsSl("promedio: " -> (&n1 + &n2 + &n3) / 3);
};` },
    { nombre: 'Área de un círculo', nivel: 'Avanzado', entradas: ['2.5'], codigo: `Esqueleto Principal --> {
  ObtDatos(dec:&radio);
  ImpConsSl("area: " -> 3.14 * &radio * &radio);
};` },
    { nombre: 'Nombre y mayoría de edad', nivel: 'Avanzado', entradas: ['Ana', '17'], codigo: `Esqueleto Principal --> {
  ObtDatos(cad:&nombre);
  ObtDatos(ent:&edad);
  ImpConsSl("Hola " -> &nombre);
  ev( (&edad => 18) ? { ImpConsSl("eres mayor de edad"); }
    -> alt { ImpConsSl("eres menor de edad"); } );
};` },
  ],

  funciones: [
    { nombre: 'Accion con retorno', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  Accion Doble --> (&n(ent)) {
    (&n * 2).retornar;
  };
  ImpConsSl(Doble(5));
};` },
    { nombre: 'Sin parámetros ni retorno', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  Accion Saludar --> () {
    ImpConsSl("Hola desde una funcion");
  };
  Saludar();
  Saludar();
};` },
    { nombre: 'Dos parámetros', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  Accion Sumar --> (&a(ent), &b(ent)) {
    (&a + &b).retornar;
  };
  ImpConsSl("3 + 4 = " -> Sumar(3, 4));
  ImpConsSl("10 + 25 = " -> Sumar(10, 25));
};` },
    { nombre: 'Dos parámetros y ev', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  Accion Mayor --> (&a(ent), &b(ent)) {
    ev( (&a > &b) ? { (&a).retornar; } );
    (&b).retornar;
  };
  ImpConsSl("el mayor es " -> Mayor(4, 9));
};` },
    { nombre: 'Salir con ().retornar', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  Accion Revisar --> (&n(ent)) {
    ev( (&n < 0) ? {
      ImpConsSl("negativo, no sigo");
      ().retornar;
    } );
    ImpConsSl("positivo o cero");
  };
  Revisar(-3);
  Revisar(4);
};` },
    { nombre: 'Una función llama a otra', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  Accion Doble --> (&n(ent)) {
    (&n * 2).retornar;
  };
  Accion Cuadruple --> (&n(ent)) {
    (Doble(Doble(&n))).retornar;
  };
  ImpConsSl("cuadruple de 5: " -> Cuadruple(5));
};` },
    { nombre: 'Ciclo dentro de una función', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  Accion SumaHasta --> (&n(ent)) {
    &total(ent):=0;
    rep( (&i(ent):=1) -> (&i =< &n) ? { &total:=&total + &i; } : ++ );
    (&total).retornar;
  };
  ImpConsSl("suma hasta 10: " -> SumaHasta(10));
  ImpConsSl("suma hasta 100: " -> SumaHasta(100));
};` },
    { nombre: 'Recursión: factorial', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  Accion Factorial --> (&n(ent)) {
    ev( (&n =< 1) ? { (1).retornar; } );
    (&n * Factorial(&n - 1)).retornar;
  };
  ImpConsSl("5! = " -> Factorial(5));
};` },
    { nombre: 'Recursión: Fibonacci', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  Accion Fib --> (&n(ent)) {
    ev( (&n =< 1) ? { (&n).retornar; } );
    (Fib(&n - 1) + Fib(&n - 2)).retornar;
  };
  rep( (&i(ent):=0) -> (&i =< 8) ? { ImpCons(Fib(&i) -> " "); } : ++ );
  ImpConsSl("");
};` },
  ],

  clases: [
    { nombre: 'Crear un objeto', nivel: 'Básico', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(10, 0);
  ImpConsSl("vida: " -> heroe.&vida);
  ImpConsSl("puntos: " -> heroe.&puntos);
};` },
    { nombre: 'Dos objetos de una clase', nivel: 'Básico', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador ana := iniciar(10, 0);
  Jugador luis := iniciar(20, 5);
  ImpConsSl("ana -> vida " -> ana.&vida -> ", puntos " -> ana.&puntos);
  ImpConsSl("luis -> vida " -> luis.&vida -> ", puntos " -> luis.&puntos);
};` },
    { nombre: 'Un obstáculo', nivel: 'Básico', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Obstaculo roca := iniciar(3);
  ImpConsSl("la roca hace " -> roca.&dano -> " de dano");
};` },
    { nombre: 'Métodos y atributos', nivel: 'Intermedio', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(10, 0);
  heroe.Curar(5);
  heroe.&puntos := 100;
  ImpConsSl("vida: " -> heroe.&vida -> " puntos: " -> heroe.&puntos);
};` },
    { nombre: 'Objetos independientes', nivel: 'Intermedio', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador a := iniciar(10, 0);
  Jugador b := iniciar(10, 0);
  a.Curar(5);
  ImpConsSl("a: " -> a.&vida);
  ImpConsSl("b: " -> b.&vida);
};` },
    { nombre: 'Atributos en expresiones', nivel: 'Intermedio', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(10, 40);
  Obstaculo roca := iniciar(3);
  ImpConsSl("vida tras el golpe: " -> heroe.&vida - roca.&dano);
  ImpConsSl("puntos dobles: " -> heroe.&puntos * 2);
};` },
    { nombre: 'Herencia (ObtieneDe)', nivel: 'Avanzado', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Mago gandalf := iniciar(30, 0, 50);
  gandalf.Lanzar(20);
  gandalf.Curar(5);
  ImpConsSl("vida: " -> gandalf.&vida -> " mana: " -> gandalf.&mana);
};` },
    { nombre: 'Objetos y ciclos', nivel: 'Avanzado', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(1, 0);
  rep( (&i(ent):=0) -> (&i < 5) ? {
    heroe.Curar(2);
    ImpConsSl("curacion " -> &i + 1 -> ", vida: " -> heroe.&vida);
  } : ++ );
};` },
  ],

  escenarios: [
    { nombre: 'Nivel y Viajar', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  Nivel Cueva -> (() {
    ImpConsSl("hace frio");
  });
  Viajar(Cueva);
};` },
    { nombre: 'Nivel con propiedad', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  Nivel Cueva -> ((&oscuro(boo):=verdadero) {
    ImpConsSl("la cueva es oscura");
  });
  Viajar(Cueva);
};` },
    { nombre: 'Declarar no activa', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  Nivel Pradera -> (() {
    ImpConsSl("entraste a la pradera");
  });
  Nivel Desierto -> (() {
    ImpConsSl("entraste al desierto");
  });
  ImpConsSl("niveles declarados, aun no viajas");
  Viajar(Desierto);
};` },
    { nombre: 'Portales', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  Nivel Bosque -> (() {
    ImpConsSl("Estas en el bosque");
  }).Portal --> Cueva;
  Nivel Cueva -> (() {
    ImpConsSl("Estas en la cueva");
  });
  Viajar(Bosque);
  Viajar(Cueva);
};` },
    { nombre: 'Portal con varios destinos', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  Nivel Bosque -> (() {
    ImpConsSl("Estas en el bosque");
  });
  Nivel Cueva -> (() {
    ImpConsSl("Estas en la cueva");
  });
  Nivel Salida -> (() {
    ImpConsSl("Saliste del juego");
  });
  Bosque.Portal --> (Cueva, Salida);
  Viajar(Bosque);
  Viajar(Cueva);
  Viajar(Salida);
};` },
    { nombre: 'Zonas dentro de un nivel', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  Nivel Entorno -> (() {
    Zona Entrada -> (() { IGNOR; }),
    Zona Fondo -> (() { IGNOR; })
  });
  Viajar(Entorno);
  ImpConsSl("nivel con zonas listo");
};` },
    { nombre: 'Posiciones con operaciones', nivel: 'Intermedio', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Obstaculo roca := iniciar(3);
  Nivel Cueva -> (() {
    ImpConsSl("Entras a la cueva");
  });
  Viajar(Cueva);
  Situar(roca -> (1 + 1, 2 * 2));
  ImpConsSl("roca colocada en (2, 4)");
};` },
    { nombre: 'Situar en otro nivel', nivel: 'Intermedio', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Recompensa llave := iniciar(1);
  Nivel Cueva -> (() {
    ImpConsSl("Entras a la cueva");
  });
  Situar(llave -> (1, 1) -> Cueva);
  Viajar(Cueva);
  ImpConsSl("la llave ya estaba esperando");
};` },
    { nombre: 'Suceso Toma', nivel: 'Avanzado', codigo: `Import juego.clase.dnv;
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
  ImpConsSl("fin");
};` },
    { nombre: 'Dos recompensas', nivel: 'Avanzado', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(10, 0);
  Recompensa moneda1 := iniciar(5);
  Recompensa moneda2 := iniciar(5);
  Nivel Pradera -> (() {
    ImpConsSl("Bienvenido a la pradera");
  });
  Viajar(Pradera);
  Situar(moneda1 -> (1, 1));
  Situar(moneda2 -> (2, 2));
  Suceso((heroe, Toma) -> {
    ImpConsSl("tomaste una recompensa");
  });
  Situar(heroe -> (1, 1));
  Situar(heroe -> (2, 2));
  ImpConsSl("fin");
};` },
    { nombre: 'Suceso Choque', nivel: 'Avanzado', codigo: `Import juego.clase.dnv;
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
  Suceso((heroe.&vida =< 0) -> {
    ImpConsSl("fin del juego");
  });
  Situar(heroe -> (0, 0));
  Situar(heroe -> (1, 1));
};` },
    { nombre: 'Suceso Ingreso', nivel: 'Avanzado', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(10, 0);
  Nivel Cueva -> (() {
    ImpConsSl("Hace frio");
  });
  Suceso((heroe, Ingreso) -> {
    ImpConsSl("el heroe entro a un nivel");
  });
  Viajar(Cueva);
  Situar(heroe -> (0, 0));
};` },
  ],

  // ── Temas nuevos ──
  arreglos: [
    { nombre: 'Arreglo de enteros', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  ar &pos(ent):=[1, 2, 3];
  ImpConsSl("arreglo: " -> &pos);
};` },
    { nombre: 'Lista de caracteres', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  lt &letras(car):={'a', 'b', 'c'};
  ImpConsSl("lista: " -> &letras);
};` },
    { nombre: 'Arreglo de cadenas', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  ar &nombres(cad):=["Ana", "Luis", "Eva"];
  ImpConsSl("nombres: " -> &nombres);
};` },
    { nombre: 'Colecciones vacías', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  ar &otro(ent):=[];
  lt &vacia(ent):={};
  ImpConsSl("arreglo vacio: " -> &otro);
  ImpConsSl("lista vacia: " -> &vacia);
};` },
    { nombre: 'Con variables y constantes', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  &a(ent):=7;
  #k(ent):=9;
  ar &mezcla(ent):=[&a, 2, #k];
  lt &conVars(ent):={&a, 2};
  ImpConsSl("arreglo: " -> &mezcla);
  ImpConsSl("lista: " -> &conVars);
};` },
    { nombre: 'Arreglo anidado', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  ar &m(ent):=[1, [2, 3], [4, [5, 6]]];
  ImpConsSl("anidado: " -> &m);
};` },
    { nombre: 'Arreglo de tiempos', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  ar &tiempos(tm):=[[1:30], [2:15:40], [::5]];
  ImpConsSl("tiempos: " -> &tiempos);
};` },
    { nombre: 'Reasignar un arreglo', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  ar &v(ent):=[1, 2];
  ImpConsSl("antes: " -> &v);
  &v:=[7, 8, 9];
  ImpConsSl("despues: " -> &v);
};` },
    { nombre: 'Arreglo y lista juntos', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  ImpConsSl("lista: " -> {1, 2, 3} -> " arreglo: " -> [1, 2]);
};` },
    { nombre: 'Globales con Mundo', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  Mundo ar &posiciones(ent):=[[1, 2, 3], [1, [2, 3]]];
  Mundo lt &letras(car):={'a', 'b'};
  ImpConsSl("posiciones: " -> &posiciones);
  ImpConsSl("letras: " -> &letras);
};` },
    { nombre: 'Arreglo como parámetro', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  Accion Mostrar --> (ar &v(ent)) {
    ImpConsSl("recibi: " -> &v);
  };
  ar &datos(ent):=[4, 5, 6];
  Mostrar(&datos);
};` },
  ],

  sucesos: [
    { nombre: 'Toma de una moneda', nivel: 'Básico', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(10, 0);
  Recompensa moneda := iniciar(5);
  Nivel Pradera -> (() {
    ImpConsSl("Estas en la pradera");
  });
  Viajar(Pradera);
  Situar(moneda -> (1, 1));
  Suceso((heroe, Toma) -> {
    ImpConsSl("tomaste la moneda");
  });
  Situar(heroe -> (1, 1));
};` },
    { nombre: 'Choque con una roca', nivel: 'Básico', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(10, 0);
  Obstaculo roca := iniciar(3);
  Nivel Cueva -> (() {
    ImpConsSl("Entras a la cueva");
  });
  Viajar(Cueva);
  Situar(roca -> (2, 2));
  Suceso((heroe, Choque) -> {
    ImpConsSl("choque con la roca");
  });
  Situar(heroe -> (2, 2));
};` },
    { nombre: 'Condición libre: sin vida', nivel: 'Intermedio', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(5, 0);
  Nivel Arena -> (() {
    ImpConsSl("Entras a la arena");
  });
  Viajar(Arena);
  Suceso((heroe.&vida =< 0) -> {
    ImpConsSl("te quedaste sin vida");
  });
  heroe.&vida := 0;
};` },
    { nombre: 'Condición con una variable', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  &puntos(ent):=0;
  Suceso((&puntos => 10) -> {
    ImpConsSl("llegaste a 10 puntos");
  });
  &puntos:=+?(10);
};` },
    { nombre: 'Suceso con bloque vacío', nivel: 'Intermedio', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(10, 0);
  Suceso((heroe, Choque) -> { });
  Suceso((heroe, Toma) -> { IGNOR; });
  ImpConsSl("sucesos registrados, sin hacer nada");
};` },
    { nombre: 'Egreso de un nivel', nivel: 'Avanzado', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(10, 0);
  Nivel Bosque -> (() {
    ImpConsSl("Estas en el bosque");
  });
  Nivel Cueva -> (() {
    ImpConsSl("Estas en la cueva");
  });
  Suceso((heroe, Egreso) -> {
    ImpConsSl("el heroe salio de un nivel");
  });
  Viajar(Bosque);
  Situar(heroe -> (0, 0));
  Viajar(Cueva);
};` },
    { nombre: 'Decisión dentro de un suceso', nivel: 'Avanzado', codigo: `Import juego.clase.dnv;
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
    ev( (heroe.&vida =< 0) ? { ImpConsSl("no sobreviviste"); }
      -> alt { ImpConsSl("sigues en pie"); } );
    Retirar(roca);
  });
  Situar(heroe -> (1, 1));
};` },
    { nombre: 'Condición compuesta', nivel: 'Avanzado', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(10, 0);
  &tiempo(ent):=3;
  Nivel Meta -> (() {
    ImpConsSl("Carrera iniciada");
  });
  Viajar(Meta);
  Suceso((heroe.&vida =< 0 || &tiempo == 0) -> {
    ImpConsSl("fin de la partida");
  });
  &tiempo:=-?(3);
};` },
    { nombre: 'Dos sucesos en un nivel', nivel: 'Avanzado', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(10, 0);
  Obstaculo roca := iniciar(2);
  Recompensa moneda := iniciar(5);
  Nivel Pradera -> (() {
    Situar(roca -> (1, 1));
    Situar(moneda -> (2, 2));
    Suceso((heroe, Choque) -> {
      ImpConsSl("ouch, una roca");
      Retirar(roca);
    });
    Suceso((heroe, Toma) -> {
      ImpConsSl("una moneda!");
      Retirar(moneda);
    });
  });
  Viajar(Pradera);
  Situar(heroe -> (1, 1));
  Situar(heroe -> (2, 2));
};` },
  ],

  importar: [
    { nombre: 'Programa sin imports', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  ImpConsSl("No necesito importar nada");
};` },
    { nombre: 'Importar una clase', nivel: 'Básico', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(10, 0);
  ImpConsSl("vida: " -> heroe.&vida);
};` },
    { nombre: 'Usar varias clases', nivel: 'Intermedio', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(10, 0);
  Obstaculo roca := iniciar(3);
  Recompensa moneda := iniciar(5);
  ImpConsSl("vida: " -> heroe.&vida);
  ImpConsSl("dano de la roca: " -> roca.&dano);
  ImpConsSl("valor de la moneda: " -> moneda.&valor);
};` },
    { nombre: 'Clase con herencia', nivel: 'Intermedio', codigo: `Import juego.clase.dnv;
Esqueleto Principal --> {
  Mago merlin := iniciar(20, 0, 40);
  merlin.Curar(5);
  merlin.Lanzar(10);
  ImpConsSl("vida: " -> merlin.&vida -> " mana: " -> merlin.&mana);
};` },
    { nombre: 'Import repetido en varias líneas', nivel: 'Avanzado', codigo: `Import juego.clase.dnv;
Import juego.clase.dnv;
Esqueleto Principal --> {
  Jugador heroe := iniciar(1, 1);
  ImpConsSl("puntos: " -> heroe.&puntos);
};` },
    { nombre: 'ERROR: archivo que no existe', nivel: 'Intermedio', codigo: `Import noexiste.clase.dnv;
Esqueleto Principal --> {
  ImpConsSl("nunca llego aqui");
};` },
    { nombre: 'ERROR: debe ser .clase.dnv', nivel: 'Intermedio', codigo: `Import juego.dnv;
Esqueleto Principal --> {
  ImpConsSl("nunca llego aqui");
};` },
    { nombre: 'ERROR: Import dentro de un bloque', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  Import juego.clase.dnv;
  ImpConsSl("Import solo va al inicio");
};` },
  ],

  nombres: [
    { nombre: 'Los cuatro tipos de nombre', nivel: 'Básico', codigo: `Import juego.clase.dnv;
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
};` },
    { nombre: 'camelCase', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  &edadMaxima(ent):=90;
  &x1(ent):=1;
  &puntosTotales(ent):=250;
  #valorMax(ent):=1000;
  ImpConsSl(&edadMaxima);
  ImpConsSl(&x1);
  ImpConsSl(&puntosTotales -> " de " -> #valorMax);
};` },
    { nombre: 'Acentos solo en cadenas', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  &mensaje(cad):="Ñandú, canción y más";
  ::: los comentarios también aceptan acentos
  ImpConsSl(&mensaje);
};` },
    { nombre: 'Un nivel con nombre propio', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  Nivel Bosque2 -> (() {
    ImpConsSl("Los nombres pueden llevar digitos");
  });
  Viajar(Bosque2);
};` },
    { nombre: 'ERROR: variable con mayúscula', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  &Color(cad):="rojo";
  ImpConsSl(&Color);
};` },
    { nombre: 'ERROR: guion bajo en el nombre', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  &edad_max(ent):=90;
  ImpConsSl(&edad_max);
};` },
    { nombre: 'ERROR: palabra reservada como nombre', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  Nivel Mundo -> (() {
    ImpConsSl("Mundo es palabra reservada");
  });
};` },
  ],

  errores: [
    { nombre: 'ERROR: falta el ;', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  ImpConsSl("hola")
};` },
    { nombre: 'ERROR: = en vez de :=', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  &a(ent) = 5;
  ImpConsSl(&a);
};` },
    { nombre: 'ERROR: >= en vez de =>', nivel: 'Básico', codigo: `Esqueleto Principal --> {
  &a(ent):=7;
  ev( (&a >= 3) ? { ImpConsSl("mayor o igual"); } );
};` },
    { nombre: 'ERROR: cuerpo vacío', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  Accion Saludar --> () { };
  Saludar();
};` },
    { nombre: 'ERROR: ev sin paréntesis propios', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  &a(ent):=7;
  ev( &a > 3 ? { ImpConsSl("mayor"); } );
};` },
    { nombre: 'ERROR: tipo que no coincide', nivel: 'Intermedio', codigo: `Esqueleto Principal --> {
  &a(ent):="hola";
  ImpConsSl(&a);
};` },
    { nombre: 'ERROR: variable que no existe', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  ImpConsSl("valor: " -> &fantasma);
};` },
    { nombre: 'ERROR: función que no existe', nivel: 'Avanzado', codigo: `Esqueleto Principal --> {
  Fantasma(3);
};` },
    { nombre: 'Versión corregida', nivel: 'Básico', codigo: `::: Los cuatro errores más comunes, ya corregidos
Esqueleto Principal --> {
  &a(ent):=7;
  Accion Saludar --> () {
    IGNOR;
  };
  Saludar();
  ev( (&a => 3) ? { ImpConsSl("mayor o igual"); } );
};` },
  ],
}