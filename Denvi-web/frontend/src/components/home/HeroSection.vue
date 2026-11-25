<script setup>
import { Play, BookOpen, Sparkles, MousePointer2 } from 'lucide-vue-next'
</script>

<template>
  <section id="inicio" class="relative overflow-hidden pt-36 pb-24">
    <div class="pixeles left-10 top-40"></div>
    <div class="pixeles right-24 top-28"></div>
    <div class="pixeles bottom-10 left-1/2"></div>

    <div class="relative mx-auto grid max-w-7xl 2xl:max-w-[1600px] items-center gap-12 px-8 lg:grid-cols-2">
      <div class="relative">
        <span class="inline-flex items-center gap-2 rounded-lg bg-mor/15 px-4 py-1.5 font-bold text-noche">
          <Sparkles :size="16" class="text-mor" /> Lenguaje para crear juegos
        </span>

        <div class="relative mt-4">

          <div class="pointer-events-none absolute -left-8 top-6 h-40 w-[115%] -rotate-12 rounded-[50%] border-2 border-mor/50"></div>
          
          <span class="brillo absolute -top-4 left-[78%] text-5xl text-pri">✦</span>
          
          <img src="/img/DENVI-LOGO.png" alt="Logo DENVI" class="h-67 w-auto" />

        </div>

        <p class="mt-4 max-w-xl text-2xl text-noche/80">
          Programar también es <span class="font-titulo text-[25px] rounded bg-crema px-2 font-bold">jugar</span>.
          Aprende las reglas y crea las tuyas.
        </p>

        <div class="mt-8 flex flex-wrap gap-4">
          <RouterLink :to="{ path: '/', hash: '#prueba' }"
            class="flex items-center gap-2 rounded-xl bg-pri px-7 py-3.5 text-lg font-bold text-caf shadow-[0_5px_0_var(--color-caf)] transition hover:-translate-y-0.5 active:translate-y-1 active:shadow-none">
            <Play :size="18" fill="currentColor" /> Try start
          </RouterLink>
          
          <RouterLink to="/tutoriales"
            class="flex items-center gap-2 rounded-xl bg-white px-7 py-3.5 text-lg font-bold text-mor shadow-[0_5px_0_var(--color-mor)] transition hover:-translate-y-0.5 active:translate-y-1 active:shadow-none">
            <BookOpen :size="18" /> Ver tutoriales
          </RouterLink>
        </div>
        <span class="brillo absolute -left-6 bottom-0 text-2xl text-mor">✦</span>
      </div>

      <div class="relative">
        
        <!-- <div class="absolute inset-0 translate-x-5 translate-y-5 rounded-2xl bg-mor/25"></div> -->
        
        <!-- AQUÍ VA EL DIBUJO: hero-paisaje.png -->
        <img src="/img/DENVI-1.png" alt="Logo DENVI" class="h-120 w-auto" />

        <!-- <div class="relative overflow-hidden rounded-2xl border-4 border-noche bg-noche shadow-2xl">
          <div class="flex gap-2 px-4 py-3">
            <span class="h-3.5 w-3.5 rounded-full bg-red-400"></span>
            <span class="h-3.5 w-3.5 rounded-full bg-pri"></span>
            <span class="h-3.5 w-3.5 rounded-full bg-green-400"></span>
          </div>
          
          
          <div class="grid aspect-[16/10] place-items-center bg-gradient-to-b from-azu/60 to-aqu/60 font-titulo text-xl text-white">

            
            
          </div>

        </div> -->


        <div class="font-titulo absolute -bottom-8 right-30 rotate-[-5deg] rounded-xl bg-noche px-5 py-3 font-mono text-lg text-white shadow-xl">
          <span class="text-pri">Jugador</span>.<span class="text-aqu">DENVI</span>()<span class="cursor"></span>
        </div>
        <MousePointer2 class="absolute -bottom-14 -right-4 text-noche" :size="44" fill="white" />
        <span class="brillo absolute -left-10 bottom-4 text-3xl text-mor">✦</span>
      </div>
    </div>
  </section>
</template>