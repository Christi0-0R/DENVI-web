import { defineStore } from 'pinia'

const CLAVE = 'denvi-progreso'

function leer() {
  try { return JSON.parse(localStorage.getItem(CLAVE)) ?? {} } catch { return {} }
}

// estrellas: { [idNivel]: 1..3 }  -> si existe la clave, el nivel está completado
export const useProgresoStore = defineStore('progreso', {
  state: () => {
    const g = leer()
    return { estrellas: g.estrellas ?? {}, xp: g.xp ?? 0 }
  },
  actions: {
    guardar() {
      try { localStorage.setItem(CLAVE, JSON.stringify({ estrellas: this.estrellas, xp: this.xp })) } catch { /* sin almacenamiento */ }
    },
    // Devuelve true si es la primera vez que se completa (da todo el XP);
    // si se repite, solo da 5 XP para no regalar puntos infinitos.
    completar(id, estrellas, xp) {
      const primera = !(id in this.estrellas)
      this.estrellas[id] = Math.max(this.estrellas[id] ?? 0, estrellas)
      this.xp += primera ? xp : 5
      this.guardar()
      return primera
    },
    reiniciar() {
      this.estrellas = {}
      this.xp = 0
      this.guardar()
    },
  },
})