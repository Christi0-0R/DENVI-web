<script setup>
import { ref, watch, computed, onMounted, onUnmounted } from 'vue'
import { useRouter } from 'vue-router'
import {
  ArrowLeft, ArrowRight, Play, Square, ExternalLink, BookOpen,
  ChevronDown, Maximize2, Minimize2,
} from 'lucide-vue-next'
import { useEditorStore } from '../../stores/editor'
import { useEjecucion } from '../../composables/useEjecucion'
import { ejemplosTema } from '../../data/ejemplosTema'
import TerminalSalida from '../TerminalSalida.vue'

const props = defineProps({ tema: Object, numero: Number, total: Number })
const emit = defineEmits(['cerrar', 'anterior', 'siguiente'])
const router = useRouter()
const editor = useEditorStore()
const { segmentos, ejecutando, esperando, ejecutar, enviar, detener, reiniciar } = useEjecucion()

const actual = ref(0)
const verEjemplos = ref(false)  // la caja de ejemplos siempre empieza cerrada
const grande = ref(false)       // ampliar código y terminal

const ejemplos = computed(() => ejemplosTema[props.tema.id] ?? props.tema.ejemplos)
const ejemplo = computed(() => ejemplos.value[actual.value])
const totalLineas = computed(() => (ejemplo.value?.codigo ?? '').split('\n').length)

const colorNivel = {
  'Básico': 'bg-green-500/20 text-green-300',
  'Intermedio': 'bg-yellow-400/20 text-yellow-300',
  'Avanzado': 'bg-red-400/20 text-red-300',
}

const parrafos = computed(() => props.tema.texto.split('\n\n'))
const corte = computed(() => {
  const total = props.tema.texto.length
  let suma = 0
  for (let i = 0; i < parrafos.value.length; i++) {
    suma += parrafos.value[i].length
    if (suma >= total * 0.6) return i + 1
  }
  return parrafos.value.length
})
const izquierda = computed(() => parrafos.value.slice(0, corte.value).join('\n\n'))
const derecha = computed(() => parrafos.value.slice(corte.value).join('\n\n'))

function elegir(i) {
  actual.value = i
  reiniciar()
}
// Al cambiar de tema (anterior / siguiente) todo vuelve a su estado inicial
watch(() => props.tema, () => {
  actual.value = 0
  verEjemplos.value = false
  grande.value = false
  reiniciar()
})

function correr() {
  if (ejecutando.value || !ejemplo.value?.codigo) return
  segmentos.value = []
  ejecutar(ejemplo.value.codigo)
}

function abrirEditor() {
  editor.cargar(ejemplo.value.codigo)
  router.push('/editor')
}

const conEsc = (e) => { if (e.key === 'Escape') emit('cerrar') }
onMounted(() => window.addEventListener('keydown', conEsc))
onUnmounted(() => window.removeEventListener('keydown', conEsc))
</script>

<template>
  <article class="col-span-full grid scroll-mt-28 items-start gap-x-12 gap-y-6 rounded-3xl border-2 border-pri bg-white p-8 shadow-xl animate-[abrir_.3s_ease-out] lg:grid-cols-[minmax(0,2fr)_minmax(0,3fr)]">

    <!-- BARRA SUPERIOR: volver / anterior / siguiente -->
    <div class="col-span-full flex flex-wrap items-center justify-between gap-3">
      <button class="flex items-center gap-2 text-sm font-bold text-mor hover:underline" @click="emit('cerrar')">
        <ArrowLeft :size="18" /> Volver a los temas
      </button>

      <div class="flex items-center gap-2">
        <button :disabled="numero <= 1"
          class="flex items-center gap-2 rounded-lg border border-noche/15 px-4 py-2 text-sm font-bold text-noche transition hover:bg-crema disabled:cursor-not-allowed disabled:opacity-30 disabled:hover:bg-transparent"
          @click="emit('anterior')">
          <ArrowLeft :size="16" /> Anterior
        </button>
        <button :disabled="numero >= total"
          class="flex items-center gap-2 rounded-lg bg-mor px-4 py-2 text-sm font-bold text-white transition hover:opacity-90 disabled:cursor-not-allowed disabled:opacity-30"
          @click="emit('siguiente')">
          Siguiente <ArrowRight :size="16" />
        </button>
      </div>
    </div>

    <!-- TEXTO -->
    <div>
      <p class="font-titulo text-lg text-pri">TEMA {{ numero }} / {{ total }}</p>
      <h2 class="font-titulo text-4xl font-bold leading-tight">{{ tema.titulo }}</h2>
      <p class="mt-5 whitespace-pre-line text-lg leading-relaxed text-noche/75">{{ izquierda }}</p>
    </div>

    <!-- EJEMPLOS -->
    <div class="w-full min-w-0">
      <div class="flex items-center justify-between">
        <p class="font-bold">Ejemplo</p>
        <button class="flex items-center gap-1.5 rounded-lg px-3 py-1.5 text-sm font-bold text-mor hover:bg-mor/10"
          @click="grande = !grande">
          <component :is="grande ? Minimize2 : Maximize2" :size="15" />
          {{ grande ? 'Reducir' : 'Ampliar' }}
        </button>
      </div>

      <div class="mt-3 overflow-hidden rounded-2xl bg-noche">
        <div class="flex items-center gap-2 border-b border-white/10 px-4 py-3">
          <span class="h-3 w-3 rounded-full bg-red-400"></span>
          <span class="h-3 w-3 rounded-full bg-pri"></span>
          <span class="h-3 w-3 rounded-full bg-green-400"></span>
          <span class="ml-3 text-sm text-white/60">{{ ejemplo.nombre }}</span>
          <span v-if="ejemplo.nivel" class="ml-auto rounded px-2 py-0.5 text-xs font-bold" :class="colorNivel[ejemplo.nivel]">
            {{ ejemplo.nivel }}
          </span>
        </div>

        <!-- código (solo lectura), a todo el ancho -->
        <div class="overflow-auto transition-[height] duration-300" :class="grande ? 'h-[32rem]' : 'h-80'">
          <div class="flex min-w-max">
            <div class="select-none px-4 py-4 text-right font-mono text-[15px] leading-7 text-white/30">
              <div v-for="n in totalLineas" :key="n">{{ n }}</div>
            </div>
            <pre class="py-4 pr-6 font-mono text-[15px] leading-7 text-aqu">{{ ejemplo.codigo }}</pre>
          </div>
        </div>

        <!-- aviso de entradas -->
        <p v-if="ejemplo.entradas?.length"
          class="border-t border-white/10 px-4 py-2 text-xs text-white/60">
          Cuando la terminal te lo pida, escribe:
          <span class="font-mono font-bold text-pri">{{ ejemplo.entradas.join('  ·  ') }}</span>
        </p>

        <!-- botones -->
        <div class="flex flex-wrap justify-end gap-2 border-t border-white/10 p-3">
          <button class="flex items-center gap-2 rounded-lg border border-white/20 px-4 py-2 text-sm text-white hover:bg-white/10"
            @click="abrirEditor">
            <ExternalLink :size="15" /> Abrir en el editor
          </button>
          <button v-if="!ejecutando" class="flex items-center gap-2 rounded-lg bg-pri px-4 py-2 font-bold text-noche hover:bg-caf"
            @click="correr">
            <Play :size="16" fill="currentColor" /> Probar código
          </button>
          <button v-else class="flex items-center gap-2 rounded-lg bg-red-400 px-4 py-2 font-bold text-noche hover:bg-red-300"
            @click="detener">
            <Square :size="16" fill="currentColor" /> Detener
          </button>
        </div>

        <!-- terminal, debajo del código -->
        <TerminalSalida class="border-t border-white/10 text-white transition-[height] duration-300"
          :class="grande ? 'h-80' : 'h-56'"
          :segmentos="segmentos" :esperando="esperando" @enviar="enviar" />

        <!-- CAJA DE EJEMPLOS (plegable, siempre cerrada al abrir un tema) -->
        <div class="border-t border-white/10 p-3">
          <button class="flex w-full items-center gap-2 px-1 text-xs font-bold uppercase tracking-widest text-white/50 hover:text-white"
            @click="verEjemplos = !verEjemplos">
            <BookOpen :size="13" /> Ejemplos ({{ ejemplos.length }})
            <ChevronDown :size="16" class="ml-auto transition-transform" :class="verEjemplos ? '' : '-rotate-90'" />
          </button>

          <ul v-show="verEjemplos" class="mt-2 max-h-60 space-y-1 overflow-y-auto pr-1">
            <li v-for="(ej, i) in ejemplos" :key="i">
              <button class="flex w-full items-center gap-3 rounded-lg px-3 py-2 text-left text-sm transition"
                :class="i === actual ? 'bg-mor font-bold text-white' : 'text-white/70 hover:bg-white/10'"
                @click="elegir(i)">
                <span class="flex-1">{{ ej.nombre }}</span>
                <span v-if="ej.nivel" class="rounded px-2 py-0.5 text-[10px] font-bold" :class="colorNivel[ej.nivel]">{{ ej.nivel }}</span>
              </button>
            </li>
          </ul>
        </div>
      </div>

      <p v-if="derecha" class="mt-8 whitespace-pre-line text-lg leading-relaxed text-noche/75">{{ derecha }}</p>
    </div>
  </article>
</template>