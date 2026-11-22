<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { useEditorStore } from '../../stores/editor'

const API = 'http://localhost:8080/api/ejecutar'
const codigo = ref('// Hola mundo en DENVI\n')
const salida = ref('')
const error = ref(false)
const cargando = ref(false)
const router = useRouter()
const editor = useEditorStore()

async function ejecutar() {
  cargando.value = true
  error.value = false
  try {
    const res = await fetch(API, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ codigo: codigo.value }),
    })
    const data = await res.json()
    error.value = data.errores?.length > 0
    salida.value = error.value ? data.errores.join('\n') : data.salida
  } catch {
    error.value = true
    salida.value = 'No se pudo conectar con el servidor de DENVI.'
  } finally {
    cargando.value = false
  }
}

function abrirEditor() {
  editor.cargar(codigo.value)
  router.push('/editor')
}
</script>


<template>
  <section id="prueba" class="relative mx-auto max-w-7xl px-8 py-20">
    <!-- AQUÍ VA TU DIBUJO: mascota-asomada.png -->
    <div class="absolute right-16 top-8 grid h-20 w-28 place-items-center rounded-t-2xl border-2 border-dashed border-pri text-xs text-pri">mascota-asomada</div>

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
          <button class="flex items-center gap-1.5 rounded-lg bg-pri px-4 py-1.5 font-bold text-noche hover:bg-caf"
                  :disabled="cargando" @click="ejecutar">▶ Run</button>
          <button class="rounded-lg border border-white/20 px-4 py-1.5 text-sm text-white hover:bg-white/10"
                  @click="abrirEditor">Abrir en el editor ↗</button>
        </div>
      </div>
      <div class="grid lg:grid-cols-2">
        <div class="flex">
          <div class="select-none border-r border-white/10 px-4 py-5 text-right font-mono text-white/30">
            <div v-for="n in codigo.split('\n').length" :key="n">{{ n }}</div>
          </div>
          <textarea v-model="codigo" spellcheck="false"
            class="h-64 flex-1 resize-none bg-transparent p-5 font-mono text-aqu outline-none"></textarea>
        </div>
        <pre class="h-64 overflow-auto border-t border-white/10 p-5 font-mono lg:border-l lg:border-t-0"
             :class="error ? 'text-red-400' : 'text-white'"><span class="text-white/50">$ consola</span>
<span class="text-pri">&gt;</span> {{ cargando ? 'Ejecutando...' : salida }}</pre>
      </div>
    </div>
  </section>
</template>

