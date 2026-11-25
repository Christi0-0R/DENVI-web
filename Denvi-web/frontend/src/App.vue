<script setup>
import NavBar from './components/layout/NavBar.vue'
import FooterBar from './components/layout/FooterBar.vue'
import DialogoDenvi from './components/DialogoDenvi.vue'
</script>

<template>
  <NavBar />
  <main><RouterView /></main>
  <FooterBar v-if="$route.name !== 'editor'" />
  <DialogoDenvi />
</template>



