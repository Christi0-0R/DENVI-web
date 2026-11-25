<script setup>
import { ref } from 'vue'
import { Download, Archive, MousePointerClick, Sparkles, Trash2, Copy, Check, FolderOpen, ShieldAlert, Play } from 'lucide-vue-next'

const urlDescarga = 'https://github.com/Christi0-0R/DENVI-web/raw/main/DENVI-Windows.zip'

const pasos = [
  { icono: Download, titulo: 'Descarga', texto: 'Baja el archivo .zip de DENVI.', color: 'text-mor bg-mor/15' },
  { icono: Archive, titulo: 'Extrae', texto: 'Clic derecho y "Extraer todo".', color: 'text-white bg-noche' },
  { icono: MousePointerClick, titulo: 'Instala', texto: 'Doble clic en instalar-denvi.bat.', color: 'text-pri bg-pri/15' },
]

const comandos = [
  {
    etiqueta: 'Comprobar',
    cmd: 'denvi',
    salida: `   ____   _____  _   _ __     __ ___ 
  |  _ \\ | ____|| \\ | |\\ \\   / /|_ _|
  | | | ||  _|  |  \\| | \\ \\ / /  | | 
  | |_| || |___ | |\\  |  \\ V /   | | 
  |____/ |_____||_| \\_|   \\_/   |___|

  DENVI esta instalado y listo para usar
  Version 1.0`,
    esCodigo: true,
  },
  {
    etiqueta: 'Ver dónde quedó instalado',
    cmd: 'Get-Command denvi',
    salida: `CommandType  Name       Source
-----------  ----       ------
Application  denvi.cmd  C:\\Users\\TU_USUARIO\\AppData\\Local\\Programs\\DENVI\\bin\\denvi.cmd`,
    esCodigo: true,
  },
]

// Ejemplo de cómo correr un programa escrito en DENVI
const usos = [
  { titulo: 'Escribe tu código', texto: 'Guárdalo en un archivo, por ejemplo mi_programa.dnv.' },
  { titulo: 'Ejecútalo', texto: 'Abre PowerShell en la carpeta del archivo y escribe:', cmd: 'denvi mi_programa.dnv' },
]

const copiado = ref(null)
async function copiar(texto) {
  try {
    await navigator.clipboard.writeText(texto)
    copiado.value = texto
    setTimeout(() => (copiado.value = null), 1800)
  } catch {
    copiado.value = null
  }
}
</script>

<template>
  <section id="instalacion" class="mx-auto max-w-5xl px-8 py-16">
    <div class="flex flex-wrap items-end justify-between gap-4">
      <div>
        <h2 class="flex items-center gap-3 font-titulo text-4xl font-bold md:text-5xl">
          <Sparkles class="text-mor" :size="32" /> Instalación
        </h2>
        <p class="mt-2 text-noche/70">En solo unos pasos, estarás listo para crear.</p>
      </div>

      <a
        :href="urlDescarga"
        download
        class="inline-flex items-center gap-2 rounded-xl bg-noche px-5 py-2.5 text-sm font-semibold text-white transition hover:bg-mor focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-mor"
      >
        <Download :size="18" /> Descargar para Windows
      </a>
    </div>

    <!-- Pasos -->
    <ol class="mt-8 grid gap-3 sm:grid-cols-3">
      <li
        v-for="(p, i) in pasos"
        :key="i"
        class="relative flex items-start gap-3 rounded-xl border border-noche/10 bg-white p-4 transition hover:border-mor/40 hover:shadow-md"
      >
        <span class="absolute -left-2 -top-2 grid h-6 w-6 place-items-center rounded-full bg-mor/20 text-xs font-bold text-mor">{{ i + 1 }}</span>
        <div class="grid h-10 w-10 shrink-0 place-items-center rounded-lg" :class="p.color">
          <component :is="p.icono" :size="20" />
        </div>
        <div>
          <h3 class="text-sm font-bold">{{ p.titulo }}</h3>
          <p class="mt-0.5 text-xs leading-snug text-noche/60">{{ p.texto }}</p>
        </div>
      </li>
    </ol>

    <!-- Cómo ejecutar un programa -->
    <div class="mt-3 rounded-xl border border-noche/10 bg-white p-4">
      <h3 class="flex items-center gap-2 text-sm font-bold">
        <Play :size="16" class="text-pri" /> Cómo ejecutar un programa en DENVI
      </h3>
      <div class="mt-3 grid gap-2 md:grid-cols-2">
        <div v-for="(u, i) in usos" :key="u.titulo" class="rounded-lg bg-noche/5 p-3">
          <p class="text-xs font-bold">{{ i + 1 }}. {{ u.titulo }}</p>
          <p class="mt-0.5 text-xs leading-snug text-noche/60">{{ u.texto }}</p>
          <div
            v-if="u.cmd"
            class="mt-2 flex items-center justify-between gap-2 rounded-md bg-noche px-2.5 py-1.5"
          >
            <code class="truncate font-mono text-xs text-pri">PS&gt; {{ u.cmd }}</code>
            <button
              type="button"
              class="grid h-6 w-6 shrink-0 place-items-center rounded text-white/70 transition hover:bg-white/15 hover:text-white focus-visible:outline focus-visible:outline-2 focus-visible:outline-pri"
              :aria-label="`Copiar ${u.cmd}`"
              @click="copiar(u.cmd)"
            >
              <Check v-if="copiado === u.cmd" :size="14" />
              <Copy v-else :size="14" />
            </button>
          </div>
        </div>
      </div>
    </div>

    <!-- Verificar, desinstalar, notas -->
    <div class="mt-3 grid gap-3 lg:grid-cols-[1.3fr_1fr]">
      <article class="rounded-xl bg-noche p-4 text-white">
        <h3 class="text-sm font-bold">Comprueba que quedó instalado</h3>
        <div class="mt-3 grid gap-3">
          <div v-for="c in comandos" :key="c.cmd">
            <p class="mb-1 text-xs text-white/50">{{ c.etiqueta }}</p>
            <div class="flex items-center justify-between gap-2 rounded-lg bg-white/10 px-3 py-2">
              <code class="font-mono text-xs text-pri">PS&gt; {{ c.cmd }}</code>
              <button
                type="button"
                class="grid h-6 w-6 shrink-0 place-items-center rounded text-white/70 transition hover:bg-white/15 hover:text-white focus-visible:outline focus-visible:outline-2 focus-visible:outline-pri"
                :aria-label="`Copiar ${c.cmd}`"
                @click="copiar(c.cmd)"
              >
                <Check v-if="copiado === c.cmd" :size="14" />
                <Copy v-else :size="14" />
              </button>
            </div>
            <p class="mt-1.5 text-xs text-white/50">Salida esperada:</p>
            <pre v-if="c.esCodigo" class="mt-1 overflow-x-auto rounded-lg bg-black/30 px-3 py-2 font-mono text-xs leading-relaxed text-white/80">{{ c.salida }}</pre>
            <p v-else class="mt-1 rounded-lg bg-black/30 px-3 py-2 text-xs leading-relaxed text-white/80">{{ c.salida }}</p>
            <p class="mt-3 rounded-lg bg-white/10 px-3 py-2 text-xs text-white/70">
              Si al escribir <code class="font-mono text-pri">denvi</code> después de instalar marca error, cierra y vuelve a abrir la terminal.
            </p>
          </div>
        </div>
      </article>

      <article class="flex items-start gap-3 rounded-xl border border-noche/10 bg-white p-4">
        <div class="grid h-10 w-10 shrink-0 place-items-center rounded-lg bg-noche/10 text-noche">
          <Trash2 :size="20" />
        </div>
        <div>
          <h3 class="text-sm font-bold">Desinstalar</h3>
          <p class="mt-0.5 text-xs leading-snug text-noche/60">
            Doble clic en <code class="font-mono text-noche">desinstalar-denvi.bat</code>. Borra DENVI y lo quita del PATH.
          </p>
        </div>
      </article>
    </div>

    <div class="mt-3 grid gap-3 md:grid-cols-2">
      <p class="flex items-start gap-2 rounded-xl bg-mor/10 px-4 py-3 text-xs text-noche/70">
        <FolderOpen :size="16" class="mt-0.5 shrink-0 text-mor" />
        <span>Se instala en <code class="font-mono text-noche">%LOCALAPPDATA%\Programs\DENVI</code>. No pide permisos de administrador.</span>
      </p>
      <p class="flex items-start gap-2 rounded-xl bg-pri/10 px-4 py-3 text-xs text-noche/70">
        <ShieldAlert :size="16" class="mt-0.5 shrink-0 text-pri" />
        <span>Si Windows muestra una advertencia, elige <strong class="text-noche">Más información</strong> y luego <strong class="text-noche">Ejecutar de todas formas</strong>.</span>
      </p>
    </div>
  </section>
</template>