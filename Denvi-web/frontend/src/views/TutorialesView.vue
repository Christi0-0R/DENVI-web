<script setup>
import { ref, nextTick } from 'vue'
import { BookOpen, Sparkles, ArrowDown, ArrowLeft } from 'lucide-vue-next'
import { temas } from '../data/temas'
import TemaDetalle from '../components/tutoriales/TemaDetalle.vue'
import ModoInteractivo from '../components/interactivo/ModoInteractivo.vue'

const modo = ref(null)      // null = portada | 'documentacion' | 'interactivo'
const abierto = ref(null)   // índice del tema abierto

function arriba() { window.scrollTo({ top: 0, behavior: 'smooth' }) }

function elegirModo(m) {
  modo.value = m
  abierto.value = null
  arriba()
}
function volverOpciones() {
  modo.value = null
  abierto.value = null
  arriba()
}

async function irA(i) {
  if (i < 0 || i >= temas.length) return
  abierto.value = i
  await nextTick()
  document.getElementById('detalle')?.scrollIntoView({ behavior: 'smooth', block: 'start' })
}
</script>

<template>
  <!-- PORTADA: solo las dos opciones -->
  <section v-if="!modo" class="relative overflow-hidden pt-36 pb-24">
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
          <button @click="elegirModo('documentacion')"
            class="group rounded-2xl border border-noche/10 bg-white p-6 text-left transition hover:-translate-y-1 hover:border-pri/50 hover:shadow-lg">
            <div class="grid h-12 w-12 place-items-center rounded-xl bg-crema text-pri"><BookOpen :size="26" /></div>
            <h3 class="mt-4 text-xl font-bold">Documentación</h3>
            <p class="text-sm text-noche/60">Los {{ temas.length }} temas del lenguaje con ejemplos.</p>
            <ArrowDown class="mt-3 text-noche/40 transition group-hover:translate-y-1 group-hover:text-pri" :size="18" />
          </button>
          <button @click="elegirModo('interactivo')"
            class="group rounded-2xl border border-noche/10 bg-white p-6 text-left transition hover:-translate-y-1 hover:border-mor/50 hover:shadow-lg">
            <div class="grid h-12 w-12 place-items-center rounded-xl bg-mor/15 text-mor"><Sparkles :size="26" /></div>
            <h3 class="mt-4 text-xl font-bold">Interactivo</h3>
            <p class="text-sm text-noche/60">Aprende jugando, nivel por nivel.</p>
            <ArrowDown class="mt-3 text-noche/40 transition group-hover:translate-y-1 group-hover:text-mor" :size="18" />
          </button>
        </div>
      </div>
    </div>
  </section>

  <!-- DOCUMENTACIÓN -->
  <section v-else-if="modo === 'documentacion'" id="documentacion" class="min-h-screen bg-white/60 pt-32 pb-20">
    <div class="mx-auto max-w-7xl 2xl:max-w-[1600px] px-8">
      <button class="mb-6 flex items-center gap-2 text-sm font-bold text-mor hover:underline" @click="volverOpciones">
        <ArrowLeft :size="18" /> Volver a las opciones
      </button>

      <h2 class="flex items-center gap-3 font-titulo text-5xl font-bold">
        <BookOpen class="text-pri" :size="38" /> Documentación
      </h2>
      <p class="mt-2 text-lg text-noche/70">Elige un tema para empezar.</p>

      <div class="mt-10 grid gap-5 sm:grid-cols-2 lg:grid-cols-5">
        <template v-for="(t, i) in temas" :key="t.id">
          <TemaDetalle v-if="abierto === i" id="detalle" :tema="t" :numero="i + 1" :total="temas.length"
            @cerrar="abierto = null" @anterior="irA(i - 1)" @siguiente="irA(i + 1)" />

          <button v-else @click="irA(i)"
            class="group relative flex h-44 flex-col rounded-2xl border border-noche/10 bg-white p-5 text-left transition duration-300 hover:-translate-y-1 hover:border-pri/50 hover:shadow-lg"
            :class="abierto !== null ? 'opacity-40 hover:opacity-100' : ''">
            <span class="absolute right-4 top-4 font-titulo text-2xl text-noche/15 group-hover:text-pri">{{ String(i + 1).padStart(2, '0') }}</span>
            <div class="grid h-11 w-11 place-items-center rounded-xl" :class="t.color"><component :is="t.icono" :size="22" /></div>
            <h3 class="mt-auto font-bold leading-snug">{{ t.titulo }}</h3>
          </button>
        </template>
      </div>
    </div>
  </section>

  <!-- INTERACTIVO -->
  <section v-else id="interactivo" class="min-h-screen pt-32 pb-20">
    <div class="mx-auto max-w-7xl px-8">
      <button class="mb-6 flex items-center gap-2 text-sm font-bold text-mor hover:underline" @click="volverOpciones">
        <ArrowLeft :size="18" /> Volver a las opciones
      </button>

      <h2 class="flex items-center gap-3 font-titulo text-5xl font-bold">
        <Sparkles class="text-mor" :size="38" /> Interactivo
      </h2>
      <p class="mt-2 mb-8 text-lg text-noche/70">Completa cada nivel para desbloquear el siguiente.</p>

      <ModoInteractivo />
    </div>
  </section>
</template>