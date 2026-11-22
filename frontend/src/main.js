import './assets/main.css'
import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import router from './router'

import '@fontsource/nunito/400.css'
import '@fontsource/nunito/700.css'
import '@fontsource/nunito/900.css'
import '@fontsource/pixelify-sans/400.css'
import '@fontsource/pixelify-sans/700.css'
import '@fontsource/press-start-2p'
import '@fontsource/jetbrains-mono'

import '@fontsource/space-grotesk/400.css'
import '@fontsource/space-grotesk/500.css'
import '@fontsource/space-grotesk/700.css'


createApp(App).use(createPinia()).use(router).mount('#app')