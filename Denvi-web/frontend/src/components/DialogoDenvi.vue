<script setup>
import { ref, watch, nextTick, onMounted, onUnmounted } from 'vue'
import { TriangleAlert, CircleHelp, FilePlus } from 'lucide-vue-next'
import { useDialogo } from '../composables/useDialogo'

const { estado, resolver } = useDialogo()
const campo = ref(null)
const btnAceptar = ref(null)
const btnCancelar = ref(null)

const iconos = { peligro: TriangleAlert, pregunta: CircleHelp, archivo: FilePlus }

watch(() => estado.abierto, async (v) => {
  if (!v) return
  await nextTick()
  if (estado.tipo === 'texto') { campo.value?.focus(); campo.value?.select() }
  else if (estado.tono === 'peligro') btnCancelar.value?.focus()   // lo más seguro primero
  else btnAceptar.value?.focus()
})

function aceptar() { resolver(estado.tipo === 'texto' ? estado.valor.trim() : true) }
function cancelar() { resolver(estado.tipo === 'texto' ? null : false) }

// Se escucha en la fase de captura para que Enter/Esc no lleguen a la lección ni al editor
function teclas(e) {
  if (!estado.abierto) return
  if (e.key === 'Escape') {
    e.preventDefault(); e.stopPropagation(); cancelar()
  } else if (e.key === 'Enter') {
    e.stopPropagation()
    if (e.target?.tagName === 'BUTTON') return   // el botón enfocado hace su propio clic
    e.preventDefault(); aceptar()
  }
}
onMounted(() => window.addEventListener('keydown', teclas, true))
onUnmounted(() => window.removeEventListener('keydown', teclas, true))
</script>

<template>
  <Teleport to="body">
    <Transition name="dlg">
      <div v-if="estado.abierto" class="fixed inset-0 z-[300] grid place-items-center bg-noche/60 px-4 backdrop-blur-sm"
        @mousedown.self="cancelar">
        <div role="dialog" aria-modal="true" :aria-label="estado.titulo"
          class="dlg-caja w-full max-w-md rounded-3xl border-2 border-noche/10 bg-white p-7 shadow-2xl">
          <div class="flex items-start gap-4">
            <div class="grid h-14 w-14 shrink-0 place-items-center rounded-2xl"
              :class="estado.tono === 'peligro' ? 'bg-red-100 text-red-500' : 'bg-crema text-pri'">
              <component :is="iconos[estado.icono] ?? CircleHelp" :size="30" />
            </div>
            <div class="min-w-0 flex-1">
              <h2 class="font-titulo text-3xl font-bold leading-tight">{{ estado.titulo }}</h2>
              <p v-if="estado.texto" class="mt-2 text-lg leading-snug text-noche/70">{{ estado.texto }}</p>
            </div>
          </div>

          <input v-if="estado.tipo === 'texto'" ref="campo" v-model="estado.valor" spellcheck="false"
            :placeholder="estado.placeholder"
            class="mt-5 w-full rounded-2xl border-2 border-noche/15 bg-white px-4 py-3 font-mono text-lg outline-none transition focus:border-mor" />

          <div class="mt-7 flex flex-wrap justify-end gap-3">
            <button ref="btnCancelar"
              class="rounded-2xl border-2 border-b-4 border-noche/20 px-6 py-3 font-black uppercase tracking-wide text-noche/70 transition hover:bg-noche/5 active:translate-y-0.5 active:border-b-2"
              @click="cancelar">{{ estado.cancelar }}</button>
            <button ref="btnAceptar" :disabled="estado.tipo === 'texto' && !estado.valor.trim()"
              class="rounded-2xl border-b-4 px-6 py-3 font-black uppercase tracking-wide text-white transition active:translate-y-0.5 active:border-b-0 disabled:cursor-not-allowed disabled:opacity-40"
              :class="estado.tono === 'peligro'
                ? 'border-red-700 bg-red-500 hover:bg-red-400'
                : 'border-green-700 bg-green-500 hover:bg-green-400'"
              @click="aceptar">{{ estado.aceptar }}</button>
          </div>
        </div>
      </div>
    </Transition>
  </Teleport>
</template>

<style scoped>
.dlg-enter-active, .dlg-leave-active { transition: opacity .2s ease; }
.dlg-enter-from, .dlg-leave-to { opacity: 0; }
.dlg-enter-active .dlg-caja { animation: dlg-pop .35s cubic-bezier(.34, 1.56, .64, 1); }

@keyframes dlg-pop { from { transform: scale(.85) translateY(12px); opacity: 0; } to { transform: none; opacity: 1; } }

@media (prefers-reduced-motion: reduce) {
  .dlg-enter-active .dlg-caja { animation: none; }
}
</style>