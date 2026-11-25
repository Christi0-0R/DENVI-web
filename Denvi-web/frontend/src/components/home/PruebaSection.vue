<script setup>
import { ref, computed } from 'vue'
import { useRouter } from 'vue-router'
import { useEditorStore } from '../../stores/editor'
import { useEjecucion } from '../../composables/useEjecucion'
import TerminalSalida from '../TerminalSalida.vue'

const MAX_CHARS = 1500   // límite solo para este ejemplo

const codigo = ref(`::: Hola mundo en DENVI
Esqueleto Principal --> {
  ImpConsSl("Hola mundo");
};
`)
const router = useRouter()
const editor = useEditorStore()
const { segmentos, ejecutando, esperando, ejecutar, enviar, detener } = useEjecucion()
const lineas = computed(() => codigo.value.split('\n').length)

function correr() {
  if (ejecutando.value) return
  segmentos.value = []
  ejecutar(codigo.value)
}

function abrirEditor() {
  editor.cargar(codigo.value)
  router.push('/editor')
}
</script>

<template>
  <section id="prueba" class="relative mx-auto max-w-7xl px-8 py-20">
    <!-- AQUÍ VA EL DIBUJO: mascota-asomada.png -->
    
    

    <div class="absolute right-16 top-15 grid h-20 w-28 place-items-center rounded-t-2xl text-xs text-pri">
      <img src="/img/DENVI-ICON.png" alt="Logo DENVI" class="h-20 w-auto" />
    </div>

    <h2 class="flex items-center justify-center gap-3 font-titulo text-4xl font-bold">
      <span class="text-mor">&gt;_</span> Prueba <span class="text-pri">DENVI</span> aquí mismo
    </h2>
    

    <div class="relative mt-10 overflow-hidden rounded-2xl bg-noche shadow-2xl">
      <div class="flex items-center gap-2 border-b border-white/10 px-4">
        <span class="h-3.5 w-3.5 rounded-full bg-red-400"></span>
        <span class="h-3.5 w-3.5 rounded-full bg-pri"></span>
        <span class="h-3.5 w-3.5 rounded-full bg-green-400"></span>
        <span class="ml-4 rounded-t-lg bg-white/10 px-4 py-2.5 text-sm font-bold text-white">hola_mundo.dnv</span>
        <span class="px-2 text-white/50">+</span>
        <div class="ml-auto flex gap-2 py-2">
          <button v-if="!ejecutando" class="flex items-center gap-1.5 rounded-lg bg-pri px-4 py-1.5 font-bold text-noche hover:bg-caf"
                  @click="correr">▶ Run</button>
          <button v-else class="flex items-center gap-1.5 rounded-lg bg-red-400 px-4 py-1.5 font-bold text-noche hover:bg-red-300"
                  @click="detener">■ Stop</button>
          <button class="rounded-lg border border-white/20 px-4 py-1.5 text-sm text-white hover:bg-white/10"
                  @click="abrirEditor">Abrir en el editor ↗</button>
        </div>
      </div>

      <div class="grid lg:grid-cols-2">
        <!-- código: números y texto en el MISMO contenedor con scroll -->
        <div class="flex min-w-0 flex-col">
          <div class="h-72 overflow-auto">
            <div class="flex min-w-full">
              <div class="select-none border-r border-white/10 px-4 py-5 text-right font-mono text-sm leading-6 text-white/30">
                <div v-for="n in lineas" :key="n">{{ n }}</div>
              </div>
              <textarea v-model="codigo" spellcheck="false" wrap="off" :rows="lineas" :maxlength="MAX_CHARS"
                @keydown.ctrl.enter.prevent="correr"
                class="min-w-0 flex-1 resize-none overflow-y-hidden bg-transparent py-5 pl-4 pr-5 font-mono text-sm leading-6 text-aqu outline-none"></textarea>
            </div>
          </div>
          <p class="border-t border-white/10 px-5 py-1 text-right font-mono text-[10px] text-white/30">
            {{ codigo.length }}/{{ MAX_CHARS }}
          </p>
        </div>

        <!-- salida interactiva -->
        <TerminalSalida class="h-72 border-t border-white/10 text-white lg:border-l lg:border-t-0"
          :segmentos="segmentos" :esperando="esperando" @enviar="enviar" />
      </div>
    </div>
  </section>
</template>