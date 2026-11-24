<script setup>
import { ref, onMounted, onUnmounted } from 'vue'
import { useRoute } from 'vue-router'
import { Home, Github, Play, Menu } from 'lucide-vue-next'

const githubUrl = 'https://github.com/Christi0-0R/denvi-web'
const route = useRoute()
const abierto = ref(false)
const activa = ref('inicio')
const secciones = [
  { id: 'inicio', label: 'Inicio' },
  { id: 'instalacion', label: 'Instalación' },
  { id: 'descripcion', label: 'Descripción' },
  { id: 'prueba', label: 'Prueba' },
]

let observer
onMounted(() => {
  observer = new IntersectionObserver(
    (entries) => entries.forEach((e) => { if (e.isIntersecting) activa.value = e.target.id }),
    { rootMargin: '-50% 0px -50% 0px' }
  )
  secciones.forEach((s) => { const el = document.getElementById(s.id); if (el) observer.observe(el) })
})
onUnmounted(() => observer?.disconnect())
</script>

<template>
  <header class="fixed inset-x-0 top-3 z-50 px-4">
    <nav class="mx-auto flex max-w-7xl 2xl:max-w-[1600px] items-center gap-6 rounded-2xl bg-noche px-5 py-3 text-white shadow-lg">
      <RouterLink to="/" class="flex items-center gap-3">
        <div class="grid h-9 w-12 place-items-center rounded-md border border-dashed border-pri text-[10px] text-pri">logo</div>
        <span class="font-titulo text-2xl tracking-wider">DENVI</span>
      </RouterLink>
      <div class="hidden h-7 w-px bg-white/20 md:block"></div>

      <ul class="hidden items-center gap-1 md:flex">
        <li v-for="s in secciones" :key="s.id">
          <RouterLink :to="{ path: '/', hash: '#' + s.id }"
            class="flex items-center gap-1.5 rounded-full px-4 py-1.5 text-sm transition"
            :class="route.path === '/' && activa === s.id ? 'bg-mor font-bold' : 'text-white/75 hover:text-white'">
            <Home v-if="s.id === 'inicio'" :size="15" />{{ s.label }}
          </RouterLink>
        </li>
        <li><RouterLink to="/tutoriales" class="px-4 text-sm text-white/75 hover:text-white">Tutoriales</RouterLink></li>
        <li>
          <a :href="githubUrl" target="_blank" class="flex items-center gap-1.5 px-4 text-sm text-white/75 hover:text-white">
            <Github :size="15" /> GitHub
          </a>
        </li>
      </ul>

      <RouterLink v-if="route.name !== 'editor'" to="/editor"
        class="ml-auto hidden items-center gap-2 rounded-xl bg-crema px-5 py-2.5 text-sm font-bold text-noche transition hover:-translate-y-0.5 hover:bg-pri md:flex">
        <Play :size="15" fill="currentColor" /> Abrir editor
      </RouterLink>

      <button class="ml-auto md:hidden" @click="abierto = !abierto"><Menu /></button>
    </nav>

    <div v-if="abierto" class="mx-auto mt-2 flex max-w-7xl flex-col gap-3 rounded-2xl bg-noche p-4 text-white md:hidden" @click="abierto = false">
      <RouterLink v-for="s in secciones" :key="s.id" :to="{ path: '/', hash: '#' + s.id }">{{ s.label }}</RouterLink>
      <RouterLink to="/tutoriales">Tutoriales</RouterLink>
      <RouterLink v-if="route.name !== 'editor'" to="/editor" class="rounded-xl bg-pri py-2 text-center font-bold text-noche">Abrir editor</RouterLink>
    </div>
  </header>
</template>