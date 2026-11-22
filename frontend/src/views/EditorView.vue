<script setup>
import { ref, computed, onMounted, onUnmounted } from 'vue'
import { useEditorStore } from '../stores/editor'
import { ejecutarCodigo } from '../services/api'
import { ejemplos } from '../data/ejemplos'
import { Files, SquareTerminal, Sun, Moon, FilePlus, Upload, Download, Play, Trash2, FileCode, BookOpen, X, Loader2, ChevronDown } from 'lucide-vue-next'

const EXT = '.dnv'
const store = useEditorStore()

const archivos = ref([{ nombre: 'hola_mundo.dnv', codigo: ejemplos[0].codigo }])
const activo = ref(0)
const consola = ref([])
const cargando = ref(false)
const inputArchivo = ref(null)
const gutter = ref(null)

// paneles y tema
const verExplorador = ref(true)
const verTerminal = ref(true)
const alturaTerminal = ref(240)
const claro = ref(localStorage.getItem('denvi-tema') === 'claro')
function cambiarTema() {
  claro.value = !claro.value
  localStorage.setItem('denvi-tema', claro.value ? 'claro' : 'oscuro')
}

const actual = computed(() => archivos.value[activo.value])
const lineas = computed(() => (actual.value?.codigo ?? '').split('\n').length)

// arrastrar para cambiar el alto de la terminal
let inicioY = 0, inicioAlto = 0
function empezarArrastre(e) {
  inicioY = e.clientY
  inicioAlto = alturaTerminal.value
  document.body.style.cursor = 'row-resize'
  window.addEventListener('mousemove', arrastrar)
  window.addEventListener('mouseup', soltar)
}
function arrastrar(e) {
  const nuevo = inicioAlto + (inicioY - e.clientY)
  alturaTerminal.value = Math.min(Math.max(nuevo, 90), window.innerHeight * 0.7)
}
function soltar() {
  document.body.style.cursor = ''
  window.removeEventListener('mousemove', arrastrar)
  window.removeEventListener('mouseup', soltar)
}

// atajos Ctrl+B y Ctrl+J
function atajos(e) {
  if (!e.ctrlKey) return
  if (e.key === 'b') { e.preventDefault(); verExplorador.value = !verExplorador.value }
  if (e.key === 'j') { e.preventDefault(); verTerminal.value = !verTerminal.value }
}

onMounted(() => {
  window.addEventListener('keydown', atajos)
  if (store.codigo) { abrirNuevo('tutorial.dnv', store.codigo); store.cargar('') }
})
onUnmounted(() => { window.removeEventListener('keydown', atajos); soltar() })

function abrirNuevo(nombre, codigo = '') {
  archivos.value.push({ nombre, codigo })
  activo.value = archivos.value.length - 1
}
function crear() {
  const nombre = prompt('Nombre del archivo:', 'nuevo' + EXT)
  if (!nombre) return
  abrirNuevo(nombre.endsWith(EXT) ? nombre : nombre + EXT)
}
function cerrar(i) {
  archivos.value.splice(i, 1)
  if (!archivos.value.length) abrirNuevo('nuevo' + EXT)
  activo.value = Math.min(activo.value, archivos.value.length - 1)
}
function importar(e) {
  const file = e.target.files[0]
  if (!file) return
  if (!file.name.endsWith(EXT)) {
    verTerminal.value = true
    consola.value.push({ tipo: 'error', texto: `Solo se aceptan archivos ${EXT}` })
    return
  }
  const lector = new FileReader()
  lector.onload = () => abrirNuevo(file.name, lector.result)
  lector.readAsText(file)
  e.target.value = ''
}
function exportar() {
  const blob = new Blob([actual.value.codigo], { type: 'text/plain' })
  const a = document.createElement('a')
  a.href = URL.createObjectURL(blob)
  a.download = actual.value.nombre
  a.click()
  URL.revokeObjectURL(a.href)
}
async function correr() {
  if (cargando.value) return
  verTerminal.value = true
  cargando.value = true
  consola.value.push({ tipo: 'info', texto: `$ denvi ${actual.value.nombre}` })
  const { salida, errores } = await ejecutarCodigo(actual.value.codigo)
  if (salida) consola.value.push({ tipo: 'salida', texto: salida })
  errores.forEach((er) =>
    consola.value.push({ tipo: 'error', texto: `Error ${er.tipo}${er.linea ? ' en línea ' + er.linea : ''}: ${er.mensaje}` }))
  cargando.value = false
}
function teclas(e) {
  if (e.key === 'Tab') {
    e.preventDefault()
    const t = e.target, ini = t.selectionStart
    actual.value.codigo = t.value.slice(0, ini) + '  ' + t.value.slice(t.selectionEnd)
    requestAnimationFrame(() => { t.selectionStart = t.selectionEnd = ini + 2 })
  }
  if (e.key === 'Enter' && e.ctrlKey) correr()
}
const sincronizar = (e) => { gutter.value.scrollTop = e.target.scrollTop }
const colores = { info: 'text-[var(--ed-suave)]', salida: 'text-[var(--ed-texto)]', error: 'text-red-500' }

</script>

<template>
  <section class="px-3 pt-24 pb-3">
    <div class="mx-auto flex h-[calc(100vh-6.75rem)] overflow-hidden rounded-2xl border border-[var(--ed-borde)] bg-[var(--ed-bg)] text-[var(--ed-texto)] shadow-2xl transition-colors"
      :class="claro ? 'ed-claro' : 'ed-oscuro'">

      <!-- BARRA DE ACTIVIDAD -->
      <nav class="flex w-14 shrink-0 flex-col items-center gap-2 bg-[var(--ed-barra)] py-3">
        <button title="Explorador (Ctrl+B)" class="rounded-lg p-2.5 transition"
          :class="verExplorador ? 'bg-[var(--ed-activo)] text-pri' : 'text-[var(--ed-suave)] hover:text-[var(--ed-texto)]'"
          @click="verExplorador = !verExplorador"><Files :size="22" /></button>
        <button title="Terminal (Ctrl+J)" class="rounded-lg p-2.5 transition"
          :class="verTerminal ? 'bg-[var(--ed-activo)] text-pri' : 'text-[var(--ed-suave)] hover:text-[var(--ed-texto)]'"
          @click="verTerminal = !verTerminal"><SquareTerminal :size="22" /></button>

        <button :title="claro ? 'Modo oscuro' : 'Modo claro'" @click="cambiarTema"
          class="mt-auto rounded-full p-2.5 transition hover:rotate-45"
          :class="claro ? 'bg-noche text-crema' : 'bg-crema text-pri'">
          <Moon v-if="claro" :size="20" />
          <Sun v-else :size="20" />
        </button>
      </nav>

      <!-- EXPLORADOR -->
      <aside v-if="verExplorador" class="flex w-60 shrink-0 flex-col border-r border-[var(--ed-borde)] bg-[var(--ed-panel)]">
        <div class="flex items-center justify-between px-4 py-3 text-xs font-bold uppercase tracking-widest text-[var(--ed-suave)]">
          Explorador
          <div class="flex gap-1">
            <button title="Crear" class="rounded p-1 hover:bg-[var(--ed-hover)]" @click="crear"><FilePlus :size="16" /></button>
            <button title="Importar" class="rounded p-1 hover:bg-[var(--ed-hover)]" @click="inputArchivo.click()"><Upload :size="16" /></button>
            <button title="Exportar" class="rounded p-1 hover:bg-[var(--ed-hover)]" @click="exportar"><Download :size="16" /></button>
          </div>
          <input ref="inputArchivo" type="file" :accept="EXT" class="hidden" @change="importar" />
        </div>
        <ul class="px-2">
          <li v-for="(a, i) in archivos" :key="i">
            <button class="flex w-full items-center gap-2 rounded px-2 py-1.5 text-sm"
              :class="i === activo ? 'bg-[var(--ed-activo)]' : 'text-[var(--ed-suave)] hover:bg-[var(--ed-hover)]'" @click="activo = i">
              <FileCode :size="15" class="text-pri" /> {{ a.nombre }}
            </button>
          </li>
        </ul>
        <p class="mt-6 flex items-center gap-2 px-4 text-xs font-bold uppercase tracking-widest text-[var(--ed-suave)]">
          <BookOpen :size="14" /> Ejemplos
        </p>
        <ul class="px-2 pt-2">
          <li v-for="ej in ejemplos" :key="ej.nombre">
            <button class="w-full rounded px-2 py-1.5 text-left text-sm text-[var(--ed-suave)] hover:bg-[var(--ed-hover)] hover:text-mor"
              @click="abrirNuevo(ej.nombre, ej.codigo)">{{ ej.nombre }}</button>
          </li>
        </ul>
      </aside>

      <!-- ZONA PRINCIPAL -->
      <div class="flex min-w-0 flex-1 flex-col">
        <div class="flex items-center border-b border-[var(--ed-borde)] bg-[var(--ed-panel)]">
          <div class="flex flex-1 overflow-x-auto">
            <div v-for="(a, i) in archivos" :key="i" @click="activo = i"
              class="group flex cursor-pointer items-center gap-2 border-r border-[var(--ed-borde)] px-4 py-2.5 text-sm"
              :class="i === activo ? 'border-t-2 border-t-pri bg-[var(--ed-bg)]' : 'text-[var(--ed-suave)] hover:text-[var(--ed-texto)]'">
              {{ a.nombre }}
              <X :size="14" class="opacity-0 hover:text-red-500 group-hover:opacity-100" @click.stop="cerrar(i)" />
            </div>
          </div>
          <button class="m-2 flex items-center gap-2 rounded-lg bg-pri px-5 py-1.5 font-bold text-noche hover:bg-caf disabled:opacity-60"
            :disabled="cargando" @click="correr">
            <Loader2 v-if="cargando" :size="16" class="animate-spin" />
            <Play v-else :size="16" fill="currentColor" /> RUN
          </button>
        </div>

        <div class="flex min-h-0 flex-1">
          <div ref="gutter" class="select-none overflow-hidden px-4 py-4 text-right font-mono text-sm leading-6 text-[var(--ed-suave)] opacity-60">
            <div v-for="n in lineas" :key="n">{{ n }}</div>
          </div>
          <textarea v-model="actual.codigo" spellcheck="false" @keydown="teclas" @scroll="sincronizar"
            class="flex-1 resize-none bg-transparent py-4 pr-4 font-mono text-[15px] leading-6 text-[var(--ed-codigo)] outline-none"></textarea>
        </div>

        <!-- TERMINAL -->
        <div v-if="verTerminal" class="relative flex shrink-0 flex-col border-t border-[var(--ed-borde)] bg-[var(--ed-term)]"
          :style="{ height: alturaTerminal + 'px' }">
          <div class="absolute inset-x-0 -top-1 h-2 cursor-row-resize hover:bg-pri/60" @mousedown.prevent="empezarArrastre"></div>
          <div class="flex items-center gap-6 px-4 py-2 text-xs font-bold uppercase tracking-widest">
            <span class="border-b-2 border-pri pb-1">Terminal</span>
            <button class="ml-auto flex items-center gap-1 normal-case tracking-normal text-[var(--ed-suave)] hover:text-[var(--ed-texto)]"
              @click="consola = []"><Trash2 :size="14" /> Limpiar</button>
            <button title="Cerrar (Ctrl+J)" class="text-[var(--ed-suave)] hover:text-[var(--ed-texto)]"
              @click="verTerminal = false"><ChevronDown :size="16" /></button>
          </div>
          <div class="flex-1 overflow-auto px-4 pb-3 font-mono text-sm leading-6">
            <p v-if="!consola.length" class="text-[var(--ed-suave)]">Presiona RUN o Ctrl + Enter para ejecutar.</p>
            <pre v-for="(l, i) in consola" :key="i" class="whitespace-pre-wrap" :class="colores[l.tipo]">{{ l.texto }}</pre>
          </div>
        </div>

        <div class="flex items-center gap-4 bg-pri px-4 py-1 text-xs font-bold text-noche">
          <span>DENVI</span><span>{{ actual.nombre }}</span>
          <span class="ml-auto">{{ lineas }} líneas</span><span>UTF-8</span>
          <span>{{ claro ? '☀️ Claro' : '🌙 Oscuro' }}</span>
        </div>
      </div>
    </div>
  </section>
</template>