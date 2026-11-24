export const ejemplos = [
  { nombre: 'hola_mundo.dnv', codigo: `::: Hola mundo en DENVI
Esqueleto Principal --> {
  ImpConsSl("Hola mundo");
};
` },
  { nombre: 'variables.dnv', codigo: `Esqueleto Principal --> {
  &vida(ent):=10;
  #max(ent):=100;
  ImpConsSl("vida: " -> &vida -> " de " -> #max);
};
` },
  { nombre: 'ciclos.dnv', codigo: `Esqueleto Principal --> {
  rep( (&i(ent):=0) -> (&i < 5) ? { ImpConsSl(&i); } : ++ );
};
` },
  { nombre: 'funciones.dnv', codigo: `Esqueleto Principal --> {
  Accion Doble --> (&n(ent)) {
    (&n * 2).retornar;
  };
  ImpConsSl(Doble(5));
};
` },
]