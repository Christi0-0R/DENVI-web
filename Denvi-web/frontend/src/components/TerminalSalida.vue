<script setup>
import { ref, watch, nextTick } from 'vue'

const props = defineProps({
  segmentos: { type: Array, default: () => [] },
  esperando: Boolean,
  cabecera: { type: Boolean, default: true },
  vacio: { type: String, default: '' },
  relleno: { type: String, default: 'p-5' },
})
const emit = defineEmits(['enviar'])

const caja = ref(null)
const campo = ref(null)
const texto = ref('')
const colores = { salida: '', entrada: 'text-pri', error: 'text-red-400', info: 'text-white/50' }

function bajar() {
  nextTick(() => { if (caja.value) caja.value.scrollTop = caja.value.scrollHeight })
}
watch(() => props.segmentos, bajar, { deep: true })
watch(() => props.esperando, async (v) => {
  if (v) { await nextTick(); campo.value?.focus(); bajar() }
})

function enviar() {
  emit('enviar', texto.value)
  texto.value = ''
}
</script>

<template>
  <div ref="caja" class="overflow-auto font-mono text-sm leading-6" :class="relleno" @click="campo?.focus()">
    <div v-if="cabecera" class="text-white/50">$ consola</div>
    <p v-if="!segmentos.length && !esperando && vacio" class="opacity-60">{{ vacio }}</p>
    <pre class="whitespace-pre-wrap break-words"><span v-for="(s, i) in segmentos" :key="i" :class="colores[s.tipo]">{{ s.texto }}</span><input v-if="esperando" ref="campo" v-model="texto" @keydown.enter.prevent="enviar" spellcheck="false" class="w-48 border-b border-pri/60 bg-transparent text-pri caret-current outline-none" /></pre>
  </div>
</template>