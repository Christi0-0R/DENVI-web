<script setup>
import { ref, computed, watch, onMounted, onUnmounted } from 'vue'
import { useRouter } from 'vue-router'
import { X, Heart, HeartCrack, Check, Play, Square, ExternalLink, Trophy, Star, RotateCcw, ArrowRight } from 'lucide-vue-next'
import { useEjecucion } from '../../composables/useEjecucion'
import { useProgresoStore } from '../../stores/progreso'
import { useEditorStore } from '../../stores/editor'
import { useDialogo } from '../../composables/useDialogo'
import TerminalSalida from '../TerminalSalida.vue'

const props = defineProps({ nivel: Object, haySiguiente: Boolean })
const emit = defineEmits(['cerrar', 'siguiente'])

const VIDAS = 3
const router = useRouter()
const editor = useEditorStore()
const progreso = useProgresoStore()
const { confirmar } = useDialogo()
const { segmentos, esperando, ejecutando, ejecutar, enviar, detener, reiniciar } = useEjecucion()

const cola = ref([])            // pasos pendientes; los fallados se vuelven a agregar al final
const indice = ref(0)
const hechos = ref(0)
const vidas = ref(VIDAS)
const estado = ref('jugando')   // 'jugando' | 'ganado' | 'perdido'
const resultado = ref(null)     // null | { ok, texto, correcta }
const seleccion = ref(null)     // opcion y completar: índice elegido
const armado = ref([])          // armar: ids de fichas colocadas
const banco = ref([])           // armar: fichas disponibles
const premio = ref({ estrellas: 0, xp: 0, primera: true })

const total = props.nivel.pasos.length
const ejercicios = props.nivel.pasos.filter((p) => p.tipo !== 'info').length
const paso = computed(() => cola.value[indice.value])
const porcentaje = computed(() => Math.round((hechos.value / total) * 100))
const partes = computed(() => (paso.value?.tipo === 'completar' ? paso.value.codigo.split('___') : []))
const textoArmado = computed(() => armado.value.map((id) => banco.value.find((b) => b.id === id)?.texto ?? ''))
const lineasCodigo = computed(() => (paso.value?.codigo ?? '').split('\n').length)

const puedeAccion = computed(() => {
  const p = paso.value
  if (!p) return false
  if (resultado.value || p.tipo === 'info') return true
  if (p.tipo === 'armar') return armado.value.length > 0
  return seleccion.value !== null
})

const elogios = ['¡Excelente!', '¡Muy bien!', '¡Perfecto!', '¡Correcto!']
const elogio = computed(() => elogios[indice.value % elogios.length])

function mezclar(arr) {
  const a = [...arr]
  for (let i = a.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1))
    ;[a[i], a[j]] = [a[j], a[i]]
  }
  return a
}

function preparar() {
  seleccion.value = null
  armado.value = []
  resultado.value = null
  reiniciar()   // cierra la ejecución anterior y limpia la terminal
  const p = paso.value
  if (p?.tipo === 'armar') {
    banco.value = mezclar([...p.tokens, ...(p.extras ?? [])]).map((texto, id) => ({ id, texto }))
  }
}

function empezar() {
  cola.value = [...props.nivel.pasos]
  indice.value = 0
  hechos.value = 0
  vidas.value = VIDAS
  estado.value = 'jugando'
  preparar()
}
watch(indice, preparar)
empezar()

// ── interacción ──
function elegir(i) { if (!resultado.value) seleccion.value = i }
function agregar(id) { if (!resultado.value && !armado.value.includes(id)) armado.value.push(id) }
function quitar(id) { if (!resultado.value) armado.value = armado.value.filter((x) => x !== id) }

function claseOpcion(i) {
  const base = 'w-full rounded-2xl border-2 border-b-4 px-5 py-4 text-left text-lg font-bold transition '
  if (resultado.value) {
    if (i === paso.value.correcta) return base + 'border-green-500 bg-green-100 text-green-700'
    if (i === seleccion.value) return base + 'anim-sacudir border-red-500 bg-red-100 text-red-700'
    return base + 'border-noche/10 text-noche/40'
  }
  return base + (i === seleccion.value ? 'border-mor bg-mor/10 text-mor' : 'border-noche/15 bg-white hover:bg-noche/5')
}

function accion() {
  if (!puedeAccion.value) return
  if (paso.value.tipo === 'info' || resultado.value) continuar()
  else comprobar()
}

function comprobar() {
  const p = paso.value
  const ok = p.tipo === 'armar'
    ? textoArmado.value.join('\u0001') === p.tokens.join('\u0001')
    : seleccion.value === p.correcta
  if (!ok) {
    vidas.value--
    if (vidas.value > 0) cola.value.push(p)   // se repite al final, como en Duolingo
  }
  const correcta = p.tipo === 'armar' ? p.tokens.join(' ') : p.opciones[p.correcta]
  resultado.value = { ok, texto: p.explicacion, correcta }
}

function continuar() {
  if (paso.value.tipo === 'info' || resultado.value?.ok) hechos.value++
  if (vidas.value <= 0) { estado.value = 'perdido'; return }
  if (indice.value + 1 >= cola.value.length) { ganar(); return }
  indice.value++
}

function ganar() {
  const estrellas = Math.max(1, vidas.value)
  const xp = ejercicios * 10 + estrellas * 5
  const primera = progreso.completar(props.nivel.id, estrellas, xp)
  premio.value = { estrellas, xp: primera ? xp : 5, primera }
  estado.value = 'ganado'
}

// ── código de los pasos info (igual que en Documentación) ──
function probar() {
  if (ejecutando.value || !paso.value?.codigo) return
  segmentos.value = []
  ejecutar(paso.value.codigo)
}

async function abrirEditor() {
  const ok = await confirmar({
    titulo: '¿Abrir en el editor?',
    texto: 'Saldrás de la lección y perderás el avance de este nivel.',
    aceptar: 'Abrir editor', cancelar: 'Seguir aquí', icono: 'pregunta',
  })
  if (!ok) return
  editor.cargar(paso.value.codigo)
  router.push('/editor')
}

async function salir() {
  if (estado.value === 'jugando' && hechos.value > 0) {
    const ok = await confirmar({
      titulo: '¿Salir de la lección?',
      texto: 'Perderás el avance de este nivel.',
      aceptar: 'Salir', cancelar: 'Seguir aquí', tono: 'peligro',
    })
    if (!ok) return
  }
  emit('cerrar')
}

// confeti de la pantalla final
const colores = ['#facc15', '#a855f7', '#22c55e', '#38bdf8', '#f97316', '#ef4444']
const confeti = Array.from({ length: 36 }, (_, i) => ({
  left: Math.random() * 100,
  color: colores[i % colores.length],
  delay: Math.random() * 1.2,
  dur: 2.4 + Math.random() * 2,
}))

function teclas(e) {
  // si se escribe en la terminal (input), no se interpretan Enter ni Esc
  if (e.target?.tagName === 'INPUT') return
  if (e.key === 'Enter' && estado.value === 'jugando') { e.preventDefault(); accion() }
  if (e.key === 'Escape') salir()
}
onMounted(() => {
  document.body.style.overflow = 'hidden'
  window.addEventListener('keydown', teclas)
})
onUnmounted(() => {
  document.body.style.overflow = ''
  window.removeEventListener('keydown', teclas)
})
</script>

<template>
  <div class="anim-entrada fixed inset-0 z-[100] flex flex-col bg-white">
    <!-- BARRA SUPERIOR -->
    <header v-if="estado === 'jugando'" class="mx-auto flex w-full max-w-3xl items-center gap-4 px-4 pt-5">
      <button class="rounded-lg p-1 text-noche/40 transition hover:text-noche" title="Salir (Esc)" @click="salir">
        <X :size="28" />
      </button>
      <div class="h-4 flex-1 overflow-hidden rounded-full bg-noche/10">
        <div class="h-full rounded-full bg-green-500 transition-all duration-500" :style="{ width: porcentaje + '%' }"></div>
      </div>
      <div :key="vidas" class="anim-pop flex items-center gap-1.5 font-black text-red-500">
        <Heart :size="26" fill="currentColor" /> {{ vidas }}
      </div>
    </header>

    <!-- PASO ACTUAL -->
    <main v-if="estado === 'jugando' && paso" class="flex-1 overflow-y-auto">
      <div :key="indice" class="anim-paso mx-auto w-full max-w-3xl px-4 py-8">
        <!-- info -->
        <template v-if="paso.tipo === 'info'">
          <p class="font-titulo text-lg text-pri">{{ nivel.titulo }}</p>
          <h2 class="mt-1 font-titulo text-4xl font-bold leading-tight">{{ paso.titulo }}</h2>
          <p class="mt-5 whitespace-pre-line text-xl leading-relaxed text-noche/75">{{ paso.texto }}</p>

          <div v-if="paso.codigo" class="mt-6 overflow-hidden rounded-2xl bg-noche">
            <!-- barra del código: puntos, y botones SIEMPRE visibles arriba -->
            <div class="flex flex-wrap items-center gap-2 border-b border-white/10 px-4 py-3">
              <span class="h-3 w-3 rounded-full bg-red-400"></span>
              <span class="h-3 w-3 rounded-full bg-pri"></span>
              <span class="h-3 w-3 rounded-full bg-green-400"></span>
              <span class="ml-2 text-sm text-white/60">ejemplo.dnv</span>

              <div v-if="paso.probar !== false" class="ml-auto flex flex-wrap gap-2">
                <button class="flex items-center gap-2 rounded-lg border border-white/20 px-3 py-1.5 text-sm text-white hover:bg-white/10"
                  @click="abrirEditor">
                  <ExternalLink :size="14" /> Editor
                </button>
                <button v-if="!ejecutando"
                  class="flex items-center gap-2 rounded-lg bg-pri px-4 py-1.5 font-bold text-noche hover:bg-caf" @click="probar">
                  <Play :size="16" fill="currentColor" /> Probar código
                </button>
                <button v-else
                  class="flex items-center gap-2 rounded-lg bg-red-400 px-4 py-1.5 font-bold text-noche hover:bg-red-300" @click="detener">
                  <Square :size="16" fill="currentColor" /> Detener
                </button>
              </div>
            </div>

            <!-- código con números de línea -->
            <div class="max-h-72 overflow-auto">
              <div class="flex min-w-max">
                <div class="select-none px-4 py-4 text-right font-mono text-[15px] leading-7 text-white/30">
                  <div v-for="n in lineasCodigo" :key="n">{{ n }}</div>
                </div>
                <pre class="py-4 pr-6 font-mono text-[15px] leading-7 text-aqu">{{ paso.codigo }}</pre>
              </div>
            </div>

            <template v-if="paso.probar !== false">
              <!-- aviso de entradas -->
              <p v-if="paso.entradas?.length" class="border-t border-white/10 px-4 py-2 text-xs text-white/60">
                Cuando la terminal te lo pida, escribe:
                <span class="font-mono font-bold text-pri">{{ paso.entradas.join('  ·  ') }}</span>
              </p>

              <!-- terminal siempre visible, debajo del código -->
              <TerminalSalida class="h-44 border-t border-white/10 text-white"
                :segmentos="segmentos" :esperando="esperando" @enviar="enviar"
                vacio="Pulsa «Probar código» para ver la salida aquí." />
            </template>
          </div>
        </template>

        <!-- opción múltiple -->
        <template v-else-if="paso.tipo === 'opcion'">
          <h2 class="font-titulo text-3xl font-bold leading-snug">{{ paso.pregunta }}</h2>
          <pre v-if="paso.codigo" class="mt-5 overflow-auto rounded-2xl bg-noche p-5 font-mono text-[15px] leading-7 text-aqu">{{ paso.codigo }}</pre>
          <div class="mt-6 grid gap-3">
            <button v-for="(o, i) in paso.opciones" :key="i" :class="claseOpcion(i)" @click="elegir(i)">
              <span class="font-mono">{{ o }}</span>
            </button>
          </div>
        </template>

        <!-- completar -->
        <template v-else-if="paso.tipo === 'completar'">
          <h2 class="font-titulo text-3xl font-bold leading-snug">{{ paso.pregunta }}</h2>
          <pre class="mt-5 overflow-auto rounded-2xl bg-noche p-5 font-mono text-[15px] leading-8 text-aqu"><template v-for="(parte, i) in partes" :key="i"><span>{{ parte }}</span><button v-if="i < partes.length - 1" class="mx-1 inline-block min-w-[5.5rem] rounded-lg border-b-4 px-3 text-center font-bold transition" :class="resultado ? (resultado.ok ? 'border-green-500 bg-green-500/20 text-green-300' : 'anim-sacudir border-red-400 bg-red-400/20 text-red-300') : 'border-white/30 bg-white/10 text-pri'" @click="seleccion = resultado ? seleccion : null">{{ seleccion !== null ? paso.opciones[seleccion] : '\u00a0' }}</button></template></pre>
          <div class="mt-6 flex flex-wrap gap-3">
            <button v-for="(o, i) in paso.opciones" :key="i"
              class="rounded-xl border-2 border-b-4 px-5 py-2.5 font-mono text-lg font-bold transition"
              :class="seleccion === i ? 'border-noche/10 bg-noche/5 text-transparent' : 'border-noche/20 bg-white text-noche hover:bg-noche/5'"
              @click="elegir(i)">{{ o }}</button>
          </div>
        </template>

        <!-- armar -->
        <template v-else-if="paso.tipo === 'armar'">
          <h2 class="font-titulo text-3xl font-bold leading-snug">{{ paso.pregunta }}</h2>
          <div class="mt-6 flex min-h-[5rem] flex-wrap content-start items-center gap-2 border-y-2 border-noche/10 py-3">
            <button v-for="id in armado" :key="id"
              class="anim-pop rounded-xl border-2 border-b-4 border-noche/20 bg-white px-4 py-2 font-mono text-lg font-bold hover:bg-noche/5"
              @click="quitar(id)">{{ banco.find((b) => b.id === id)?.texto }}</button>
          </div>
          <div class="mt-6 flex flex-wrap justify-center gap-2">
            <button v-for="b in banco" :key="b.id" :disabled="armado.includes(b.id)"
              class="rounded-xl border-2 border-b-4 px-4 py-2 font-mono text-lg font-bold transition"
              :class="armado.includes(b.id) ? 'border-noche/5 bg-noche/5 text-transparent' : 'border-noche/20 bg-white hover:bg-noche/5'"
              @click="agregar(b.id)">{{ b.texto }}</button>
          </div>
        </template>
      </div>
    </main>

    <!-- BARRA INFERIOR: comprobar / resultado -->
    <footer v-if="estado === 'jugando' && paso" class="border-t-2 transition-colors duration-300"
      :class="resultado ? (resultado.ok ? 'border-green-200 bg-green-100' : 'border-red-200 bg-red-100') : 'border-noche/10 bg-white'">
      <div class="mx-auto flex max-w-3xl items-center gap-4 px-4 py-5">
        <div v-if="resultado" class="anim-subir flex flex-1 items-start gap-3"
          :class="resultado.ok ? 'text-green-700' : 'text-red-700'">
          <div class="grid h-10 w-10 shrink-0 place-items-center rounded-full bg-white">
            <Check v-if="resultado.ok" :size="24" :stroke-width="4" />
            <X v-else :size="24" :stroke-width="4" />
          </div>
          <div>
            <p class="text-xl font-black">{{ resultado.ok ? elogio : 'Respuesta correcta:' }}</p>
            <p v-if="!resultado.ok" class="font-mono font-bold">{{ resultado.correcta }}</p>
            <p class="mt-1 text-sm font-semibold opacity-90">{{ resultado.texto }}</p>
          </div>
        </div>
        <div v-else class="flex-1"></div>

        <button :disabled="!puedeAccion"
          class="rounded-2xl border-b-4 px-8 py-3 text-lg font-black uppercase tracking-wide transition active:translate-y-0.5 active:border-b-0"
          :class="!puedeAccion ? 'cursor-not-allowed border-noche/10 bg-noche/10 text-noche/30'
            : resultado && !resultado.ok ? 'border-red-700 bg-red-500 text-white hover:bg-red-400'
            : 'border-green-700 bg-green-500 text-white hover:bg-green-400'"
          @click="accion">
          {{ paso.tipo === 'info' || resultado ? 'Continuar' : 'Comprobar' }}
        </button>
      </div>
    </footer>

    <!-- GANASTE -->
    <div v-else-if="estado === 'ganado'" class="relative flex flex-1 flex-col items-center justify-center overflow-hidden px-6 text-center">
      <div class="pointer-events-none absolute inset-0">
        <span v-for="(c, i) in confeti" :key="i" class="confeti"
          :style="{ left: c.left + '%', background: c.color, animationDelay: c.delay + 's', animationDuration: c.dur + 's' }"></span>
      </div>
      <Trophy class="anim-rebote text-pri" :size="110" />
      <h2 class="mt-4 font-titulo text-5xl font-bold">¡Nivel completado!</h2>
      <p class="mt-2 text-lg text-noche/60">{{ nivel.titulo }}</p>
      <div class="mt-6 flex gap-3">
        <Star v-for="n in 3" :key="n" :size="60"
          :class="n <= premio.estrellas ? 'anim-pop fill-pri text-pri' : 'text-noche/20'"
          :style="{ animationDelay: n * 0.25 + 's' }" />
      </div>
      <p class="anim-pop mt-6 rounded-2xl bg-crema px-6 py-3 text-2xl font-black text-caf" style="animation-delay: .9s">
        +{{ premio.xp }} XP
      </p>
      <p v-if="!premio.primera" class="mt-2 text-sm text-noche/50">Repetir un nivel da menos XP.</p>
      <div class="mt-10 flex flex-wrap justify-center gap-3">
        <button class="rounded-2xl border-2 border-b-4 border-noche/20 px-6 py-3 font-black uppercase text-noche/70 hover:bg-noche/5"
          @click="emit('cerrar')">Volver al mapa</button>
        <button v-if="haySiguiente"
          class="flex items-center gap-2 rounded-2xl border-b-4 border-green-700 bg-green-500 px-6 py-3 font-black uppercase text-white hover:bg-green-400"
          @click="emit('siguiente')">Siguiente nivel <ArrowRight :size="20" /></button>
      </div>
    </div>

    <!-- SIN VIDAS -->
    <div v-else class="flex flex-1 flex-col items-center justify-center px-6 text-center">
      <HeartCrack class="anim-sacudir text-red-500" :size="100" />
      <h2 class="mt-4 font-titulo text-5xl font-bold">¡Te quedaste sin vidas!</h2>
      <p class="mt-3 max-w-md text-lg text-noche/60">
        No pasa nada. Lee de nuevo la explicación e inténtalo otra vez, cada intento te deja más cerca.
      </p>
      <div class="mt-10 flex flex-wrap justify-center gap-3">
        <button class="rounded-2xl border-2 border-b-4 border-noche/20 px-6 py-3 font-black uppercase text-noche/70 hover:bg-noche/5"
          @click="emit('cerrar')">Volver al mapa</button>
        <button class="flex items-center gap-2 rounded-2xl border-b-4 border-green-700 bg-green-500 px-6 py-3 font-black uppercase text-white hover:bg-green-400"
          @click="empezar"><RotateCcw :size="20" /> Reintentar</button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.anim-entrada { animation: entrada .25s ease-out; }
.anim-paso { animation: paso .35s ease-out; }
.anim-subir { animation: subir .25s ease-out; }
.anim-sacudir { animation: sacudir .4s; }
.anim-pop { animation: pop .45s cubic-bezier(.34, 1.56, .64, 1) both; }
.anim-rebote { animation: rebote 1s ease-in-out infinite; }
.confeti { position: absolute; top: -20px; width: 10px; height: 16px; border-radius: 2px; animation-name: caer; animation-timing-function: linear; animation-fill-mode: forwards; }

@keyframes entrada { from { opacity: 0; transform: translateY(16px); } to { opacity: 1; transform: none; } }
@keyframes paso { from { opacity: 0; transform: translateX(32px); } to { opacity: 1; transform: none; } }
@keyframes subir { from { opacity: 0; transform: translateY(24px); } to { opacity: 1; transform: none; } }
@keyframes sacudir { 0%, 100% { transform: translateX(0); } 20% { transform: translateX(-8px); } 40% { transform: translateX(8px); } 60% { transform: translateX(-6px); } 80% { transform: translateX(4px); } }
@keyframes pop { from { transform: scale(0); opacity: 0; } to { transform: scale(1); opacity: 1; } }
@keyframes rebote { 50% { transform: translateY(-12px); } }
@keyframes caer { to { transform: translateY(110vh) rotate(720deg); } }

@media (prefers-reduced-motion: reduce) {
  .anim-entrada, .anim-paso, .anim-subir, .anim-sacudir, .anim-pop, .anim-rebote, .confeti { animation: none; }
  .anim-pop { opacity: 1; transform: none; }
}
</style>