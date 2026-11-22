<script setup>
import { Crosshair, Zap, Gamepad2, Code2, ArrowRight } from 'lucide-vue-next'
const features = [
  { icono: Crosshair, titulo: 'Propósito', texto: 'Para qué se creó DENVI.', color: 'text-mor bg-mor/15' },
  { icono: Zap, titulo: 'Sintaxis simple', texto: 'Característica 1.', color: 'text-pri bg-crema' },
  { icono: Gamepad2, titulo: 'Escenarios y eventos', texto: 'Característica 2.', color: 'text-mor bg-mor/15' },
  { icono: Code2, titulo: 'Intérprete en Java', texto: 'Característica 3.', color: 'text-azu bg-aqu/25' },
]
</script>

<template>
  <section id="descripcion" class="relative overflow-hidden bg-white/60 py-24">
    <div class="pixeles right-10 top-10"></div>
    <div class="mx-auto grid max-w-7xl items-center gap-14 px-8 lg:grid-cols-[1fr_1.3fr]">
      <div class="relative">
        <span class="rounded-lg bg-mor/15 px-4 py-1.5 font-titulo font-bold tracking-widest text-mor">CONOCE EL LENGUAJE</span>
        <h2 class="mt-5 font-titulo text-6xl font-bold leading-tight">
          Hecho para <br /><span class="text-pri">crear juegos</span>
        </h2>
        <p class="mt-5 text-lg text-noche/70">
          Descripción breve de DENVI en dos o tres líneas. Qué es, para quién es y por qué existe.
        </p>
        <!-- AQUÍ VA TU DIBUJO: mascota-descripcion.png -->
        <div class="mt-8 grid h-40 w-40 place-items-center rounded-2xl border-2 border-dashed border-pri text-sm text-pri">
          mascota-descripcion.png
        </div>
        <span class="brillo absolute right-10 top-0 text-3xl text-mor">✦</span>
      </div>

      <div class="grid gap-5 sm:grid-cols-2">
        <article v-for="f in features" :key="f.titulo"
          class="group flex items-start gap-4 rounded-2xl border border-noche/10 bg-white p-6 transition hover:-translate-y-1 hover:border-mor/40 hover:shadow-lg">
          <div class="grid h-14 w-14 shrink-0 place-items-center rounded-xl" :class="f.color"><component :is="f.icono" :size="28" /></div>
          <div class="flex-1">
            <h3 class="text-lg font-bold">{{ f.titulo }}</h3>
            <p class="text-sm text-noche/60">{{ f.texto }}</p>
          </div>
          <ArrowRight :size="18" class="mt-auto text-noche/40 transition group-hover:translate-x-1 group-hover:text-mor" />
        </article>
      </div>
    </div>
  </section>
</template>