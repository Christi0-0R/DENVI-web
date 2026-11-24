<script setup>
import { ref, computed } from 'vue'
import { Lock, Check, Star, Zap, RotateCcw, Trophy } from 'lucide-vue-next'
import { temas } from '../../data/temas'
import { niveles } from '../../data/niveles'
import { useProgresoStore } from '../../stores/progreso'
import { useDialogo } from '../../composables/useDialogo'
import Leccion from './Leccion.vue'
import MonitoDenvi from './MonitoDenvi.vue'

const progreso = useProgresoStore()
const { confirmar } = useDialogo()
const abierta = ref(null)   // índice de la lección abierta
const sacudir = ref(null)   // índice del nivel bloqueado que se sacude

// Si tienes el dibujo de la mascota, ponlo en /public y pon aquí su ruta, ej. '/mascota.png'.
// Con null se usa el monito dibujado en MonitoDenvi.vue.
// (copia mascota.png a la carpeta public/ de tu proyecto)
const MASCOTA = '/mascota.png'

// Une cada nivel con los datos de su tema (título e icono)
const lista = computed(() => niveles.map((n) => {
  const t = temas.find((t) => t.id === n.id)
  return { ...n, titulo: t?.titulo ?? n.id, icono: t?.icono }
}))

const completados = computed(() => lista.value.filter((n) => progreso.estrellas[n.id]).length)
const todo = computed(() => completados.value >= lista.value.length)

// El mapa serpentea: cada nivel se desplaza un poco a izquierda o derecha
const DESPLAZ = [0, 56, 84, 56, 0, -56, -84, -56]
const desp = (i) => DESPLAZ[i % DESPLAZ.length]

// Caminito continuo: una curva por tramo, del centro de un nivel al centro del siguiente.
// Cada fila mide H px y el nivel está centrado en ella, así que las coordenadas son fijas.
const H = 170
const ANCHO = 400
const cx = (i) => ANCHO / 2 + desp(i)
const cy = (i) => i * H + H / 2
function trazo(i) {
  const x1 = cx(i), y1 = cy(i), x2 = cx(i + 1), y2 = cy(i + 1), k = H * 0.5
  return `M ${x1} ${y1} C ${x1} ${y1 + k}, ${x2} ${y2 - k}, ${x2} ${y2}`
}
// El nombre va hacia adentro del mapa y la mascota hacia afuera
const etiquetaIzq = (i) => desp(i) > 0

function estado(i) {
  if (progreso.estrellas[lista.value[i].id]) return 'hecho'
  return i === 0 || progreso.estrellas[lista.value[i - 1].id] ? 'actual' : 'bloqueado'
}

// Tramo i → i+1: dorado si ya se recorrió, con puntitos que avanzan si lleva al nivel actual
function claseCamino(i) {
  if (estado(i) !== 'hecho') return 'text-noche/20'
  return estado(i + 1) === 'actual' ? 'text-pri anim-camino' : 'text-pri'
}

function claseNodo(i) {
  const base = 'grid h-24 w-24 place-items-center rounded-full border-4 transition active:translate-y-1 active:shadow-none '
  const e = estado(i)
  if (e === 'hecho') return base + 'border-caf/30 bg-pri text-noche shadow-[0_6px_0_var(--color-caf)] hover:brightness-105'
  if (e === 'actual') return base + 'anim-latido border-white/40 bg-mor text-white shadow-[0_6px_0_rgba(0,0,0,.35)]'
  return base + 'cursor-not-allowed border-noche/5 bg-noche/10 text-noche/35 shadow-[0_6px_0_rgba(0,0,0,.08)]'
}

function abrir(i) {
  if (estado(i) === 'bloqueado') {
    sacudir.value = i
    setTimeout(() => { sacudir.value = null }, 500)
    return
  }
  abierta.value = i
}

async function reiniciar() {
  const ok = await confirmar({
    titulo: '¿Empezar de cero?',
    texto: 'Se borrarán tu progreso, tus estrellas y tu XP. No se puede deshacer.',
    aceptar: 'Borrar progreso', cancelar: 'Cancelar', tono: 'peligro',
  })
  if (ok) progreso.reiniciar()
}
</script>

<template>
  <div class="mx-auto max-w-xl">
    <!-- BARRA DE PROGRESO -->
    <div class="sticky top-24 z-10 mb-4 flex items-center gap-4 rounded-2xl border border-noche/10 bg-white/90 px-5 py-3 shadow-md backdrop-blur">
      <div class="flex items-center gap-1.5 font-black text-caf"><Zap :size="22" fill="currentColor" /> {{ progreso.xp }} XP</div>
      <div class="h-3 flex-1 overflow-hidden rounded-full bg-noche/10">
        <div class="h-full rounded-full bg-pri transition-all duration-700" :style="{ width: (completados / lista.length) * 100 + '%' }"></div>
      </div>
      <span class="text-sm font-bold text-noche/60">{{ completados }}/{{ lista.length }}</span>
      <button class="text-noche/30 transition hover:rotate-[-90deg] hover:text-noche" title="Reiniciar progreso" @click="reiniciar">
        <RotateCcw :size="18" />
      </button>
    </div>

    <!-- MAPA -->
    <div class="relative pb-16 pt-12">
      <!-- caminito: detrás de los niveles, de uno al siguiente sin cortes -->
      <svg aria-hidden="true" class="pointer-events-none absolute overflow-visible"
        :style="{ top: '48px', left: `calc(50% - ${ANCHO / 2}px)` }"
        :width="ANCHO" :height="lista.length * H" :viewBox="`0 0 ${ANCHO} ${lista.length * H}`">
        <path v-for="(n, i) in lista.slice(0, -1)" :key="n.id" :d="trazo(i)" fill="none" stroke="currentColor"
          stroke-width="8" stroke-linecap="round" stroke-dasharray="1 16" :class="claseCamino(i)" />
      </svg>

      <ol class="relative">
        <li v-for="(n, i) in lista" :key="n.id" class="flex items-center justify-center" :style="{ height: H + 'px' }">
          <div class="relative" :style="{ transform: `translateX(${desp(i)}px)` }">
            <!-- burbuja del nivel actual -->
            <div v-if="estado(i) === 'actual'" class="absolute bottom-full left-1/2 mb-3 -translate-x-1/2">
              <div class="anim-flota relative whitespace-nowrap rounded-xl border-2 border-pri bg-white px-4 py-1.5 text-sm font-black text-caf shadow">
                {{ i === 0 && !progreso.xp ? 'Empieza aquí' : 'Sigue aquí' }}
                <span class="absolute -bottom-[7px] left-1/2 h-3 w-3 -translate-x-1/2 rotate-45 border-b-2 border-r-2 border-pri bg-white"></span>
              </div>
            </div>

            <button :class="[claseNodo(i), sacudir === i ? 'anim-sacudir' : '']" :title="n.titulo" @click="abrir(i)">
              <Check v-if="estado(i) === 'hecho'" :size="42" :stroke-width="4" />
              <Lock v-else-if="estado(i) === 'bloqueado'" :size="34" />
              <component :is="n.icono" v-else :size="40" />
            </button>

            <!-- nombre del nivel, al costado para no tapar el camino -->
            <div class="absolute top-1/2 w-32 -translate-y-1/2 sm:w-44"
              :class="etiquetaIzq(i) ? 'right-full mr-4 text-right' : 'left-full ml-4 text-left'">
              <p class="font-bold leading-snug" :class="estado(i) === 'bloqueado' ? 'text-noche/35' : 'text-noche'">
                <span class="block font-titulo text-sm text-noche/40">NIVEL {{ i + 1 }}</span>
                {{ n.titulo }}
              </p>
              <div v-if="estado(i) === 'hecho'" class="mt-1 flex gap-0.5" :class="etiquetaIzq(i) ? 'justify-end' : ''">
                <Star v-for="s in 3" :key="s" :size="18"
                  :class="s <= progreso.estrellas[n.id] ? 'fill-pri text-pri' : 'text-noche/20'" />
              </div>
            </div>

            <!-- mascota: solo en el nivel actual, del lado contrario al nombre -->
            <MonitoDenvi v-if="estado(i) === 'actual'" estado="actual" :src="MASCOTA"
              class="absolute top-1/2 hidden -translate-y-1/2 sm:block"
              :class="etiquetaIzq(i) ? 'left-full ml-3' : 'right-full mr-3'" />
          </div>
        </li>
      </ol>

      <div v-if="todo" class="anim-flota mt-4 flex flex-col items-center text-center">
        <Trophy class="text-pri" :size="72" />
        <p class="mt-2 font-titulo text-3xl font-bold">¡Completaste DENVI!</p>
        <p class="text-noche/60">Ahora crea tus propios niveles en el editor.</p>
      </div>
    </div>

    <!-- LECCIÓN -->
    <Leccion v-if="abierta !== null" :key="abierta" :nivel="lista[abierta]"
      :hay-siguiente="abierta < lista.length - 1"
      @cerrar="abierta = null" @siguiente="abierta++" />
  </div>
</template>

<style scoped>
.anim-latido { animation: latido 1.6s ease-out infinite; }
.anim-flota { animation: flota 1.4s ease-in-out infinite; }
.anim-sacudir { animation: sacudir .4s; }
.anim-camino { animation: fluir 1s linear infinite; }

@keyframes latido {
  0%   { box-shadow: 0 6px 0 rgba(0, 0, 0, .35), 0 0 0 0 rgba(139, 92, 246, .55); }
  100% { box-shadow: 0 6px 0 rgba(0, 0, 0, .35), 0 0 0 24px rgba(139, 92, 246, 0); }
}
@keyframes flota { 50% { transform: translateY(-6px); } }
@keyframes sacudir {
  0%, 100% { transform: translateX(0); }
  20% { transform: translateX(-8px); }
  40% { transform: translateX(8px); }
  60% { transform: translateX(-6px); }
  80% { transform: translateX(4px); }
}
@keyframes fluir { to { stroke-dashoffset: -17; } }

@media (prefers-reduced-motion: reduce) {
  .anim-latido, .anim-flota, .anim-sacudir, .anim-camino { animation: none; }
}
</style>