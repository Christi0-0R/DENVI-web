<script setup>
import { Crosshair, Zap, Gamepad2, Type, ArrowRight } from 'lucide-vue-next'


const features = [
  { icono: Crosshair, titulo: 'Propósito', texto: 'Describir escenarios, colocar obstáculos y recompensas, establecer eventos y definir el comportamiento de cada elemento del juego.', color: 'text-mor bg-mor/15' },
  { icono: Gamepad2, titulo: 'Vocabulario gamer', texto: 'Usa palabras que cualquier diseñador reconoce: Nivel, Zona, Portal, Suceso, Situar, Retirar y Viajar.', color: 'text-pri bg-crema' },
  { icono: Zap, titulo: 'Pocas palabras reservadas', texto: 'Estructuras pocas y sintaxis regular. Los sucesos como Choque o Toma son un catálogo, así el lenguaje crece sin cambiar su gramática.', color: 'text-mor bg-mor/15' },
  { icono: Type, titulo: 'Se distingue a simple vista', texto: 'Variables con &, constantes con #, estructuras con mayúscula y objetos en minúscula. Tus archivos usan la extensión .dnv.', color: 'text-azu bg-aqu/25' },
]


</script>

<template>
  <section id="descripcion" class="relative overflow-hidden bg-white/60 py-24">
    <div class="pixeles right-10 top-10"></div>
    <div class="mx-auto grid max-w-7xl items-center gap-14 px-8 lg:grid-cols-[1fr_1.6fr] 2xl:max-w-[1600px] 2xl:gap-20">
      <div class="relative">
        <span class="rounded-lg bg-mor/15 px-4 py-1.5 font-titulo font-bold tracking-widest text-mor">CONOCE EL LENGUAJE</span>
        <h2 class="mt-5 font-titulo text-6xl font-bold leading-tight">
          Hecho para <br /><span class="text-pri">crear juegos</span>
        </h2>
        <p class="mt-5 text-lg text-noche/70">
          <strong class="text-noche">DENVI</strong>, «Desarrollo de Niveles de Videojuegos», es un lenguaje de dominio específico para diseñar niveles. Crea tus propios objetos con clases, colócalos en el escenario y decide cómo reaccionan con eventos y condiciones.
        </p>
        <!-- DIBUJITO.png -->
         <img src="/img/DENVI-2.png" alt="Logo DENVI" class="h-110 w-auto" />

        <span class="brillo absolute right-10 top-0 text-3xl text-mor">✦</span>
      </div>


      <div class="grid gap-5 sm:grid-cols-2 2xl:gap-6">
        <article v-for="f in features" :key="f.titulo"
          class="group flex items-start gap-3 rounded-2xl border border-noche/10 bg-white p-6 transition hover:-translate-y-1 hover:border-mor/40 hover:shadow-lg">
          <div class="grid h-14 w-14 shrink-0 place-items-center rounded-xl" :class="f.color"><component :is="f.icono" :size="28" /></div>
          <div class="flex-1">
            <h3 class="text-[25px] font-bold">{{ f.titulo }}</h3>
            <p class="text-[20px] text-noche/60">{{ f.texto }}</p>
          </div>
        </article>
      </div>
    </div>
  </section>
</template>