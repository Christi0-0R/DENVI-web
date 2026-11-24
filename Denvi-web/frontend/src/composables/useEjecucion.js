import { ref, onUnmounted } from 'vue'

const WS_URL = import.meta.env.VITE_WS_URL
  || `${location.protocol === 'https:' ? 'wss' : 'ws'}://${location.host}/ws/ejecutar`

export function useEjecucion() {
  const segmentos = ref([])      // [{ tipo: 'salida'|'entrada'|'error'|'info', texto }]
  const ejecutando = ref(false)
  const esperando = ref(false)   // true = el programa espera que el usuario escriba
  let ws = null

  function escribir(tipo, texto) {
    const ultimo = segmentos.value.at(-1)
    if (ultimo && ultimo.tipo === tipo && tipo === 'salida') ultimo.texto += texto
    else segmentos.value.push({ tipo, texto })
  }

  function cerrar() {
    if (ws) { const w = ws; ws = null; w.close() }
    ejecutando.value = false
    esperando.value = false
  }

  function limpiar() { segmentos.value = [] }

  function reiniciar() { cerrar(); limpiar() }

  function ejecutar(codigo) {
    cerrar()
    ejecutando.value = true
    const w = new WebSocket(WS_URL)
    ws = w
    let termino = false

    w.onopen = () => w.send(JSON.stringify({ tipo: 'ejecutar', codigo }))

    w.onmessage = (e) => {
      if (ws !== w) return
      const m = JSON.parse(e.data)
      if (m.tipo === 'salida') escribir('salida', m.texto)
      else if (m.tipo === 'entrada') esperando.value = true
      else if (m.tipo === 'error') {
        const er = m.error
        escribir('error', '\n' + (er.traza ?? `${er.categoria}: ${er.detalle}`) + '\n')
      } else if (m.tipo === 'fin') {
        termino = true
        cerrar()
      }
    }

    w.onerror = () => {
      if (ws !== w) return
      termino = true
      escribir('error', 'No se pudo conectar con el servidor de DENVI. ¿Está corriendo el backend?\n')
      cerrar()
    }

    w.onclose = () => {
      if (ws !== w) return
      if (!termino) escribir('error', '\nSe perdió la conexión con el servidor.\n')
      cerrar()
    }
  }

  function enviar(texto) {
    if (!ws || !esperando.value) return
    ws.send(JSON.stringify({ tipo: 'entrada', texto }))
    escribir('entrada', texto + '\n')
    esperando.value = false
  }

  function detener() {
    if (!ejecutando.value) return
    cerrar()
    escribir('info', '\n[ejecución detenida]\n')
  }

  onUnmounted(cerrar)

  return { segmentos, ejecutando, esperando, ejecutar, enviar, detener, limpiar, reiniciar, escribir }
}