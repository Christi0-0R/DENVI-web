<script setup>
import { Github } from 'lucide-vue-next'
const githubUrl = 'https://github.com/Christi0-0R/DENVI-web'
const anio = new Date().getFullYear()
</script>

<template>
  <footer class="bg-noche text-white">
    <div class="mx-auto flex max-w-7xl 2xl:max-w-[1600px] flex-col items-center gap-4 px-8 py-8 sm:flex-row sm:gap-10">
      <RouterLink to="/" class="flex items-center gap-3">
        
        <img src="/img/DENVI-APP.png" alt="Logo DENVI" class="h-9 w-auto" />
        <img src="/img/DENVI-NAME.png" alt="DENVI" class="h-7 w-auto" />
        
      </RouterLink>

      <div class="flex items-center gap-6 text-sm text-white/75 sm:ml-auto">
        <a :href="githubUrl" target="_blank" rel="noopener" class="flex items-center gap-1.5 transition hover:text-white">
          <Github :size="16" /> GitHub
        </a>
        <span>© {{ anio }} Equipo DENVI</span>
      </div>
    </div>
  </footer>
</template>