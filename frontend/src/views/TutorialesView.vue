<script setup>
import { ref, nextTick } from 'vue'
import { BookOpen, Sparkles, ArrowDown } from 'lucide-vue-next'
import { temas } from '../data/temas'
import TemaDetalle from '../components/tutoriales/TemaDetalle.vue'

const abierto = ref(null)

async function abrir(i) {
  abierto.value = abierto.value === i ? null : i
  await nextTick()
  document.getElementById('detalle')?.scrollIntoView({ behavior: 'smooth', block: 'start' })
}
</script>

<template>
  <!-- PORTADA -->
  <section class="relative overflow-hidden pt-36 pb-16">
    <div class="pixeles right-20 top-32"></div>
    <div class="mx-auto grid max-w-7xl 2xl:max-w-[1600px] items-center gap-12 px-8 lg:grid-cols-[auto_1fr]">
      <!-- DIBUJOO mascota-tutoriales.png -->
      <div class="flotar grid h-72 w-64 place-items-center rounded-2xl border-2 border-dashed border-pri text-sm text-pri">
        mascota-tutoriales.png
      </div>

      <div>
        <span class="rounded-lg bg-mor/15 px-4 py-1.5 font-titulo font-bold tracking-widest text-mor">APRENDE DENVI</span>
        <h1 class="mt-4 font-titulo text-7xl font-bold">Tutoriales</h1>
        <p class="mt-4 max-w-2xl text-xl text-noche/70">
          Aquí aprenderás DENVI paso a paso, desde lo básico hasta crear tus propios escenarios.
        </p>

        <div class="mt-8 grid max-w-2xl gap-5 sm:grid-cols-2">
          <a href="#documentacion"
            class="group rounded-2xl border border-noche/10 bg-white p-6 transition hover:-translate-y-1 hover:border-pri/50 hover:shadow-lg">
            <div class="grid h-12 w-12 place-items-center rounded-xl bg-crema text-pri"><BookOpen :size="26" /></div>
            <h3 class="mt-4 text-xl font-bold">Documentación</h3>
            <p class="text-sm text-noche/60">Los 10 temas del lenguaje con ejemplos.</p>
            <ArrowDown class="mt-3 text-noche/40 transition group-hover:translate-y-1 group-hover:text-pri" :size="18" />
          </a>
          <a href="#interactivo"
            class="group rounded-2xl border border-noche/10 bg-white p-6 transition hover:-translate-y-1 hover:border-mor/50 hover:shadow-lg">
            <div class="grid h-12 w-12 place-items-center rounded-xl bg-mor/15 text-mor"><Sparkles :size="26" /></div>
            <h3 class="mt-4 text-xl font-bold">Interactivo</h3>
            <p class="text-sm text-noche/60">Aprende jugando, nivel por nivel.</p>
            <ArrowDown class="mt-3 text-noche/40 transition group-hover:translate-y-1 group-hover:text-mor" :size="18" />
          </a>
        </div>
      </div>
    </div>
  </section>

  <!-- DOCUMENTACIÓN -->
  <section id="documentacion" class="bg-white/60 py-20">
    <div class="mx-auto max-w-7xl 2xl:max-w-[1600px] px-8">
      <h2 class="flex items-center gap-3 font-titulo text-5xl font-bold">
        <BookOpen class="text-pri" :size="38" /> Documentación
      </h2>
      <p class="mt-2 text-lg text-noche/70">Elige un tema para empezar.</p>

<div class="mt-10 grid gap-5 sm:grid-cols-2 lg:grid-cols-5">
  <template v-for="(t, i) in temas" :key="t.id">
    <TemaDetalle v-if="abierto === i" id="detalle" :tema="t" :numero="i + 1" @cerrar="abierto = null" />

    <button v-else @click="abrir(i)"
      class="group relative flex h-44 flex-col rounded-2xl border border-noche/10 bg-white p-5 text-left transition duration-300 hover:-translate-y-1 hover:border-pri/50 hover:shadow-lg"
      :class="abierto !== null ? 'opacity-40 hover:opacity-100' : ''">
      <span class="absolute right-4 top-4 font-titulo text-2xl text-noche/15 group-hover:text-pri">{{ String(i + 1).padStart(2, '0') }}</span>
      <div class="grid h-11 w-11 place-items-center rounded-xl" :class="t.color"><component :is="t.icono" :size="22" /></div>
      <h3 class="mt-auto font-bold leading-snug">{{ t.titulo }}</h3>
    </button>
  </template>
</div>












      <!-- <div class="mt-10 grid gap-5 sm:grid-cols-2 lg:grid-cols-5">
        <button v-for="(t, i) in temas" :key="t.id" @click="abierto = i"
          class="group relative flex h-44 flex-col rounded-2xl border border-noche/10 bg-white p-5 text-left transition hover:-translate-y-1 hover:border-pri/50 hover:shadow-lg">
          <span class="absolute right-4 top-4 font-titulo text-2xl text-noche/15 group-hover:text-pri">{{ String(i + 1).padStart(2, '0') }}</span>
          <div class="grid h-11 w-11 place-items-center rounded-xl" :class="t.color"><component :is="t.icono" :size="22" /></div>
          <h3 class="mt-auto font-bold leading-snug">{{ t.titulo }}</h3>
        </button>
      </div> -->
    </div>
  </section>

  <!-- INTERACTIVO (opcional) -->
  <section id="interactivo" class="py-20">
    <div class="mx-auto max-w-7xl px-8">
      <h2 class="flex items-center gap-3 font-titulo text-5xl font-bold">
        <Sparkles class="text-mor" :size="38" /> Interactivo
      </h2>
      <div class="mt-8 grid h-64 place-items-center rounded-2xl border-2 border-dashed border-mor/40 text-mor">
        Próximamente: mapa de niveles
      </div>
    </div>
  </section>

  <!-- <Transition
    enter-active-class="transition duration-200" enter-from-class="opacity-0 scale-95"
    leave-active-class="transition duration-150" leave-to-class="opacity-0 scale-95">
    <TemaDetalle v-if="temaAbierto" :tema="temaAbierto" :numero="abierto + 1" @cerrar="abierto = null" />
  </Transition> -->
</template>