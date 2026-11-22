import { defineStore } from 'pinia'

export const useEditorStore = defineStore('editor', {
  state: () => ({ codigo: '' }),
  actions: {
    cargar(codigo) { this.codigo = codigo },
  },
})