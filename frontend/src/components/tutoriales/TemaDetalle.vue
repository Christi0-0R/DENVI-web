<script setup>

import { ref, watch, computed, onMounted, onUnmounted } from 'vue'
import { useRouter } from 'vue-router'
import { ArrowLeft, Play } from 'lucide-vue-next'
import { useEditorStore } from '../../stores/editor'

const props = defineProps({ tema: Object, numero: Number })
const emit = defineEmits(['cerrar'])
const router = useRouter()
const editor = useEditorStore()
const actual = ref(0)

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

watch(() => props.tema, () => { actual.value = 0 })

function probar() {
  editor.cargar(props.tema.ejemplos[actual.value].codigo)
  router.push('/editor')
}

const conEsc = (e) => { if (e.key === 'Escape') emit('cerrar') }
onMounted(() => window.addEventListener('keydown', conEsc))
onUnmounted(() => window.removeEventListener('keydown', conEsc))

</script>


<template>
  <article class="col-span-full grid scroll-mt-28 items-start gap-12 rounded-3xl border-2 border-pri bg-white p-8 shadow-xl animate-[abrir_.3s_ease-out] lg:grid-cols-2">
    <!-- TEXTO DE ARRIBA -->
    <div>
      <button class="flex items-center gap-2 text-sm font-bold text-mor hover:underline" @click="emit('cerrar')">
        <ArrowLeft :size="18" /> Volver a los temas
      </button>
      <p class="mt-6 font-titulo text-lg text-pri">TEMA {{ numero }}</p>
      <h2 class="font-titulo text-4xl font-bold leading-tight">{{ tema.titulo }}</h2>
      <p class="mt-5 whitespace-pre-line text-lg leading-relaxed text-noche/75">{{ izquierda }}</p>
    </div>

    <!-- EJEMPLO, flota a la derecha -->
    <!-- <div class="mb-8 lg:float-right lg:ml-10 lg:w-[55%]"> -->
    <div class="w-full">
      <p class="font-bold">Ejemplo</p>
      <div class="mt-3 flex overflow-hidden rounded-2xl bg-noche w-full">
        <div class="flex flex-1 flex-col">
          <div class="flex items-center gap-2 border-b border-white/10 px-4 py-3">
            <span class="h-3 w-3 rounded-full bg-red-400"></span>
            <span class="h-3 w-3 rounded-full bg-pri"></span>
            <span class="h-3 w-3 rounded-full bg-green-400"></span>
            <span class="ml-3 text-sm text-white/60">{{ tema.ejemplos[actual].nombre }}</span>
          </div>
          <pre class="min-h-64 flex-1 overflow-auto p-5 font-mono text-sm text-aqu">{{ tema.ejemplos[actual].codigo }}</pre>
          <div class="flex justify-end border-t border-white/10 p-3">
            <button class="flex items-center gap-2 rounded-lg bg-pri px-4 py-2 font-bold text-noche hover:bg-caf" @click="probar">
              <Play :size="16" fill="currentColor" /> Probar código
            </button>
          </div>
        </div>

        <ul class="w-44 shrink-0 border-l border-white/10 p-3">
          <p class="mb-2 px-2 text-xs font-bold uppercase tracking-widest text-white/40">Ejemplos</p>
          <li v-for="(ej, i) in tema.ejemplos" :key="i">
            <button class="w-full rounded-lg px-3 py-2 text-left text-sm transition"
              :class="i === actual ? 'bg-mor font-bold text-white' : 'text-white/70 hover:bg-white/10'"
              @click="actual = i">{{ ej.nombre }}</button>
          </li>
        </ul>
      </div>
      <p v-if="derecha" class="mt-8 whitespace-pre-line text-lg leading-relaxed text-noche/75">{{ derecha }}</p>
    </div>

  </article>
</template>