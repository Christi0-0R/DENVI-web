// PETICIÓN  POST VITE_API_URL   body: { "codigo": "..." }
// RESPUESTA { "salida": "texto impreso", "errores": [ { "tipo": "sintáctico", "linea": 3, "mensaje": "..." } ] }
// tipo puede ser: léxico, sintáctico, semántico o ejecución

const API_URL = import.meta.env.VITE_API_URL || 'http://localhost:8080/api/ejecutar'

export async function ejecutarCodigo(codigo) {
  try {
    const res = await fetch(API_URL, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ codigo }),
    })
    if (!res.ok) throw new Error(`HTTP ${res.status}`)
    const data = await res.json()
    return { salida: data.salida ?? '', errores: data.errores ?? [] }
  } catch (e) {
    return {
      salida: '',
      errores: [{ tipo: 'conexión', linea: null, mensaje: 'No se pudo conectar con el servidor de DENVI. ¿Está corriendo el backend?' }],
    }
  }
}