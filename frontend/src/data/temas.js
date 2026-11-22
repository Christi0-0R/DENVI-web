import { BookOpen, Box, Equal, Calculator, GitBranch, Repeat, Keyboard, Braces, Shapes, Gamepad2 } from 'lucide-vue-next'

export const temas = [
  { id: 'intro', titulo: 'Introducción y sintaxis básica', icono: BookOpen, color: 'text-pri bg-crema',
    texto: '...',
    ejemplos: [
      { nombre: 'Hola mundo', codigo: '// Hola mundo en DENVI\n' },
      { nombre: 'Comentarios', codigo: '// Esto es un comentario\n' },
    ] },
  { id: 'tipos', titulo: 'Tipos de datos y variables', icono: Box, color: 'text-mor bg-mor/15', texto: '...', ejemplos: [{ nombre: 'Ejemplo 1', codigo: '' }] },
  { id: 'asignacion', titulo: 'Asignación y operadores', icono: Equal, color: 'text-azu bg-aqu/25', texto: '...', ejemplos: [{ nombre: 'Ejemplo 1', codigo: '' }] },
  { id: 'expresiones', titulo: 'Expresiones aritméticas y lógicas', icono: Calculator, color: 'text-pri bg-crema', texto: '...', ejemplos: [{ nombre: 'Ejemplo 1', codigo: '' }] },
  { id: 'decision', titulo: 'Estructuras de decisión', icono: GitBranch, color: 'text-mor bg-mor/15', texto: '...', ejemplos: [{ nombre: 'Ejemplo 1', codigo: '' }] },
  { id: 'repeticion', titulo: 'Estructuras de repetición', icono: Repeat, color: 'text-azu bg-aqu/25', texto: '...', ejemplos: [{ nombre: 'Ejemplo 1', codigo: '' }] },
  { id: 'entrada', titulo: 'Entradas y salidas', icono: Keyboard, color: 'text-pri bg-crema', texto: '...', ejemplos: [{ nombre: 'Ejemplo 1', codigo: '' }] },
  { id: 'funciones', titulo: 'Métodos y funciones', icono: Braces, color: 'text-mor bg-mor/15', texto: '...', ejemplos: [{ nombre: 'Ejemplo 1', codigo: '' }] },
  { id: 'clases', titulo: 'Clases', icono: Shapes, color: 'text-azu bg-aqu/25', texto: '...', ejemplos: [{ nombre: 'Ejemplo 1', codigo: '' }] },
  { id: 'escenarios', titulo: 'Escenarios y eventos', icono: Gamepad2, color: 'text-pri bg-crema', texto: '...', ejemplos: [{ nombre: 'Ejemplo 1', codigo: '' }] },
]