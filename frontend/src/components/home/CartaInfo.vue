<script setup>
import { ref, onMounted } from 'vue'

defineProps({
  titulo: String, texto: String, nivel: Number,
  color: String,   // clase de borde, ej. 'border-nar'
  fondo: String,   // clase de fondo, ej. 'bg-nar'
  retraso: { type: Number, default: 0 },
})

const carta = ref(null)
const visible = ref(false)

onMounted(() => {
  const obs = new IntersectionObserver(([e]) => {
    if (e.isIntersecting) { visible.value = true; obs.disconnect() }
  }, { threshold: 0.3 })
  obs.observe(carta.value)
})
</script>

<template>
  <article
    ref="carta"
    class="group rounded-3xl border-2 bg-white/5 p-8 backdrop-blur transition-all duration-700 ease-out hover:-translate-y-3 hover:bg-white/10"
    :class="[color, visible ? 'translate-x-0 opacity-100' : '-translate-x-24 opacity-0']"
    :style="{ transitionDelay: visible ? '0ms' : retraso + 'ms' }"
  >
    <div class="flex items-center justify-between">
      <h3 class="text-2xl font-black text-white">{{ titulo }}</h3>
      <span class="rounded-lg px-3 py-1 font-pixel text-xs text-noche" :class="fondo">LVL {{ nivel }}</span>
    </div>
    <div class="mt-6 grid h-48 place-items-center rounded-2xl text-noche transition group-hover:scale-105" :class="fondo">
      Mascota
    </div>
    <p class="mt-6 text-lg text-gray-300">{{ texto }}</p>
    <div class="mt-6 h-3 rounded-full bg-white/10">
      <div class="h-3 rounded-full" :class="fondo" :style="{ width: nivel * 33 + '%' }"></div>
    </div>
    <p class="mt-2 text-right font-pixel text-[10px] text-gray-500">XP {{ nivel * 33 }}/100</p>
  </article>
</template>