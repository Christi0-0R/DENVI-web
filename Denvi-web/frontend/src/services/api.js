// PETICIÓN  POST /api/ejecutar   body: { codigo, entradas }
// RESPUESTA { ok, salida, error: { categoria, detalle, ayuda, linea, columna, archivo, traza } | null }
//
// Devuelve:
//   salida  -> texto impreso
//   error   -> objeto de error del backend (o null)
//   errores -> arreglo [{ tipo, linea, mensaje }] (compatibilidad con componentes antiguos)

const API_URL = import.meta.env.VITE_API_URL || '/api/ejecutar'

function aLista(error) {
  if (!error) return []
  return [{
    tipo: (error.categoria ?? 'error').toLowerCase(),
    linea: error.linea || null,
    mensaje: error.traza ?? error.detalle ?? 'Error desconocido',
  }]
}

export async function ejecutarCodigo(codigo, entradas = []) {
  try {
    const res = await fetch(API_URL, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ codigo, entradas }),
    })
    if (!res.ok) throw new Error(`HTTP ${res.status}`)
    const data = await res.json()
    const error = data.error ?? null
    return { salida: data.salida ?? '', error, errores: aLista(error) }
  } catch (e) {
    const error = {
      categoria: 'Conexión',
      detalle: 'No se pudo conectar con el servidor de DENVI. ¿Está corriendo el backend?',
      traza: null,
      linea: 0,
    }
    return { salida: '', error, errores: aLista(error) }
  }
}