import { reactive } from 'vue'

// Reemplazo de confirm() y prompt() del navegador, con el diseño de DENVI.
// Uso:
//   const { confirmar, pedirTexto } = useDialogo()
//   if (await confirmar({ titulo: '¿Salir?', texto: '...', tono: 'peligro' })) { ... }
//   const nombre = await pedirTexto({ titulo: 'Nuevo archivo', valor: 'nuevo.dnv' })  // null si cancela

const base = {
  tipo: 'confirmar',      // 'confirmar' | 'texto'
  titulo: '',
  texto: '',
  aceptar: 'Aceptar',
  cancelar: 'Cancelar',
  tono: 'normal',         // 'normal' | 'peligro'
  icono: 'pregunta',      // 'pregunta' | 'peligro' | 'archivo'
  valor: '',
  placeholder: '',
}

const estado = reactive({ ...base, abierto: false })
let resolverActual = null

function abrir(opciones) {
  // si ya había uno abierto, se cancela
  if (resolverActual) resolverActual(opciones.tipo === 'texto' ? null : false)
  return new Promise((resolve) => {
    resolverActual = resolve
    Object.assign(estado, base, opciones, { abierto: true })
  })
}

function resolver(valor) {
  estado.abierto = false
  const r = resolverActual
  resolverActual = null
  r?.(valor)
}

export function useDialogo() {
  return {
    estado,
    resolver,
    confirmar: (o = {}) => abrir({ ...o, tipo: 'confirmar', icono: o.icono ?? (o.tono === 'peligro' ? 'peligro' : 'pregunta') }),
    pedirTexto: (o = {}) => abrir({ ...o, tipo: 'texto', icono: o.icono ?? 'archivo' }),
  }
}