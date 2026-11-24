<script setup>
// Mascota de DENVI. Tres estados:
//  - 'actual'    : saluda y salta (es el nivel al que toca ir)
//  - 'hecho'     : celebra con los brazos arriba
//  - 'bloqueado' : duerme (zzz)
// Si tienes tu propio dibujo, pasa src="/mascota.png" (archivo en /public) y se usa la
// imagen con las mismas animaciones en lugar del monito dibujado aquí.
defineProps({
  estado: { type: String, default: 'actual' },
  src: { type: String, default: null },
  tam: { type: Number, default: 100 },
})
</script>

<template>
  <div class="monito pointer-events-none select-none" :class="'est-' + estado"
    :style="{ width: tam + 'px', height: tam + 'px' }" aria-hidden="true">

    <img v-if="src" :src="src" alt="" class="monito-cuerpo monito-img h-full w-full object-contain" />

    <svg v-else viewBox="0 0 100 110" class="monito-cuerpo h-full w-full overflow-visible">
      <!-- cola -->
      <g class="cola">
        <path d="M64 94 Q94 94 90 66 Q88 56 96 50" fill="none" stroke="#8b5a2b" stroke-width="7" stroke-linecap="round" />
      </g>

      <!-- piernas y cuerpo -->
      <ellipse cx="40" cy="102" rx="10" ry="6" fill="#8b5a2b" />
      <ellipse cx="60" cy="102" rx="10" ry="6" fill="#8b5a2b" />
      <ellipse cx="50" cy="82" rx="19" ry="21" fill="#8b5a2b" />
      <ellipse cx="50" cy="86" rx="12" ry="14" fill="#f3d9b1" />

      <!-- brazos (con mano) -->
      <g class="brazoI">
        <path d="M36 70 Q24 80 26 94" fill="none" stroke="#8b5a2b" stroke-width="9" stroke-linecap="round" />
        <circle cx="26" cy="95" r="5.5" fill="#f3d9b1" />
      </g>
      <g class="brazoD">
        <path d="M64 70 Q76 80 74 94" fill="none" stroke="#8b5a2b" stroke-width="9" stroke-linecap="round" />
        <circle cx="74" cy="95" r="5.5" fill="#f3d9b1" />
      </g>

      <!-- bufanda morada -->
      <path d="M33 64 Q50 76 67 64 L65 72 Q50 82 35 72 Z" fill="#8b5cf6" />
      <path d="M58 76 L65 92 L56 89 Z" fill="#7c3aed" />

      <!-- cabeza -->
      <g class="cabeza">
        <circle cx="23" cy="42" r="9" fill="#8b5a2b" />
        <circle cx="23" cy="42" r="5" fill="#f3d9b1" />
        <circle cx="77" cy="42" r="9" fill="#8b5a2b" />
        <circle cx="77" cy="42" r="5" fill="#f3d9b1" />
        <circle cx="50" cy="40" r="26" fill="#8b5a2b" />
        <ellipse cx="50" cy="47" rx="19" ry="16" fill="#f3d9b1" />
        <path d="M37 36 Q43 29 50 35 Q57 29 63 36 Q63 46 50 47 Q37 46 37 36 Z" fill="#f3d9b1" />

        <!-- mejillas -->
        <circle cx="35" cy="51" r="3.5" fill="#f4a4a4" opacity=".6" />
        <circle cx="65" cy="51" r="3.5" fill="#f4a4a4" opacity=".6" />

        <!-- ojos -->
        <template v-if="estado !== 'bloqueado'">
          <ellipse class="ojo" cx="42" cy="42" rx="3.2" ry="4" fill="#2b1d12" />
          <ellipse class="ojo" cx="58" cy="42" rx="3.2" ry="4" fill="#2b1d12" />
          <circle cx="43" cy="40.5" r="1.1" fill="#fff" />
          <circle cx="59" cy="40.5" r="1.1" fill="#fff" />
        </template>
        <template v-else>
          <path d="M38 43 Q42 47 46 43" fill="none" stroke="#2b1d12" stroke-width="2" stroke-linecap="round" />
          <path d="M54 43 Q58 47 62 43" fill="none" stroke="#2b1d12" stroke-width="2" stroke-linecap="round" />
        </template>

        <!-- nariz y boca -->
        <ellipse cx="46.5" cy="50" rx="1.2" ry="1.6" fill="#2b1d12" />
        <ellipse cx="53.5" cy="50" rx="1.2" ry="1.6" fill="#2b1d12" />
        <path v-if="estado === 'actual'" d="M42 55 Q50 62 58 55" fill="none" stroke="#2b1d12" stroke-width="2.2" stroke-linecap="round" />
        <path v-else-if="estado === 'hecho'" d="M41 54 Q50 68 59 54 Z" fill="#7a2e2e" stroke="#2b1d12" stroke-width="1.6" stroke-linejoin="round" />
        <path v-else d="M45 57 Q50 59 55 57" fill="none" stroke="#2b1d12" stroke-width="2" stroke-linecap="round" />
      </g>
    </svg>

    <!-- zzz mientras duerme -->
    <template v-if="estado === 'bloqueado'">
      <span class="zz font-titulo text-mor" style="right: -2px; top: 4px; font-size: 18px">z</span>
      <span class="zz font-titulo text-mor" style="right: -14px; top: -8px; font-size: 14px; animation-delay: .8s">z</span>
    </template>

    <!-- destellos al celebrar -->
    <template v-if="estado === 'hecho'">
      <span class="destello text-pri" style="left: -8px; top: 2px; font-size: 18px">✦</span>
      <span class="destello text-mor" style="right: -8px; top: -6px; font-size: 14px; animation-delay: .5s">✦</span>
    </template>
  </div>
</template>

<style scoped>
.monito { position: relative; }
.monito-cuerpo { transform-origin: 50% 100%; }
/* el personaje es pixel art: se escala sin suavizar los bordes */
.monito-img { image-rendering: pixelated; }
.est-bloqueado .monito-img { filter: grayscale(.85) brightness(.85); }

.est-actual .monito-cuerpo { animation: salto 1.1s ease-in-out infinite; }
.est-hecho .monito-cuerpo { animation: baile 1.2s ease-in-out infinite; }
.est-bloqueado .monito-cuerpo { animation: respira 3.2s ease-in-out infinite; opacity: .85; }

.cola { transform-origin: 64px 94px; animation: cola 1.6s ease-in-out infinite; }
.brazoI { transform-origin: 36px 70px; }
.brazoD { transform-origin: 64px 70px; }
.cabeza { transform-origin: 50px 66px; }
.ojo { transform-box: fill-box; transform-origin: center; animation: parpadeo 4s infinite; }

.est-actual .brazoD { animation: saludo .7s ease-in-out infinite alternate; }
.est-hecho .brazoI { animation: arribaI .6s ease-in-out infinite alternate; }
.est-hecho .brazoD { animation: arribaD .6s ease-in-out infinite alternate; }
.est-bloqueado .cabeza { transform: rotate(8deg); }
.est-bloqueado .cola { animation: none; }

.zz { position: absolute; font-weight: 900; opacity: 0; animation: subirz 2.4s ease-in infinite; }
.destello { position: absolute; animation: destello 1.2s ease-in-out infinite; }

@keyframes salto {
  0%, 100% { transform: translateY(0) scale(1, 1); }
  15% { transform: translateY(0) scale(1.05, .95); }
  45% { transform: translateY(-12px) scale(.97, 1.03); }
  75% { transform: translateY(0) scale(1, 1); }
}
@keyframes baile { 0%, 100% { transform: rotate(-5deg); } 50% { transform: rotate(5deg) translateY(-4px); } }
@keyframes respira { 50% { transform: scale(1.03); } }
@keyframes cola { 0%, 100% { transform: rotate(-8deg); } 50% { transform: rotate(10deg); } }
@keyframes saludo { from { transform: rotate(-130deg); } to { transform: rotate(-95deg); } }
@keyframes arribaI { from { transform: rotate(150deg); } to { transform: rotate(115deg); } }
@keyframes arribaD { from { transform: rotate(-150deg); } to { transform: rotate(-115deg); } }
@keyframes parpadeo { 0%, 92%, 100% { transform: scaleY(1); } 96% { transform: scaleY(.1); } }
@keyframes subirz { 0% { transform: translateY(8px) scale(.6); opacity: 0; } 30% { opacity: 1; } 100% { transform: translateY(-14px) scale(1.1); opacity: 0; } }
@keyframes destello { 0%, 100% { transform: scale(.5) rotate(0); opacity: .2; } 50% { transform: scale(1.2) rotate(30deg); opacity: 1; } }

@media (prefers-reduced-motion: reduce) {
  .monito *, .monito-cuerpo, .zz, .destello { animation: none !important; }
  .zz { opacity: 1; }
}
</style>