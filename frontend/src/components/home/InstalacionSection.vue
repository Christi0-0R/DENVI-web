<script setup>
import { Download, Terminal, Play, ArrowRight, Sparkles } from 'lucide-vue-next'
const pasos = [
  { icono: Download, titulo: 'Clona la repo', texto: 'Obtén el código desde GitHub.', color: 'text-mor bg-mor/15' },
  { icono: Terminal, titulo: 'Levanta el backend Java', texto: 'Ejecuta el servidor.', color: 'text-white bg-noche' },
  { icono: Play, titulo: 'Corre npm run dev', texto: '¡Y comienza a desarrollar!', color: 'text-pri bg-pri/15' },
]
</script>

<template>
  <section id="instalacion" class="mx-auto max-w-7xl px-8 py-16">
    <div class="flex items-end justify-between">
      <div>
        <h2 class="flex items-center gap-3 font-titulo text-5xl font-bold">
          <Sparkles class="text-mor" :size="36" /> Instalación
        </h2>
        <p class="mt-2 text-lg text-noche/70">En solo unos pasos, estarás listo para crear.</p>
      </div>

    </div>

    <!-- <div class="mt-10 grid items-center gap-4 md:grid-cols-[1fr_auto_1fr_auto_1fr]">
      <template v-for="(p, i) in pasos" :key="i">
        <article class="relative rounded-2xl border border-noche/10 bg-white p-7 transition hover:-translate-y-1 hover:border-mor/40 hover:shadow-lg">
          <span class="absolute -left-3 -top-3 grid h-8 w-8 place-items-center rounded-full bg-mor/20 font-bold text-mor">{{ i + 1 }}</span>
          <div class="grid h-14 w-14 place-items-center rounded-xl" :class="p.color"><component :is="p.icono" :size="28" /></div>
          <h3 class="mt-5 text-lg font-bold">{{ p.titulo }}</h3>
          <p class="text-sm text-noche/60">{{ p.texto }}</p>
        </article>
        <ArrowRight v-if="i < 2" class="mx-auto hidden text-mor md:block" :size="28" />
      </template>
    </div> -->
  </section>
</template>