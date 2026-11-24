import { defineStore } from 'pinia'

export const useEditorStore = defineStore('editor', {
  state: () => ({ codigo: '', entradas: [] }),
  actions: {
    cargar(codigo, entradas = []) {
      this.codigo = codigo
      this.entradas = entradas
    },
  },
})