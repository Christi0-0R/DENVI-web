import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

export default createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', name: 'home', component: HomeView },
    { path: '/tutoriales', name: 'tutoriales', component: () => import('../views/TutorialesView.vue') },
    { path: '/editor', name: 'editor', component: () => import('../views/EditorView.vue') },
  ],
  scrollBehavior(to) {
    if (to.hash) return { el: to.hash, behavior: 'smooth' }
    return { top: 0 }
  },
})