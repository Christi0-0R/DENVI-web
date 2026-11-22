<script setup>
import NavBar from './components/layout/NavBar.vue'
import FooterBar from './components/layout/FooterBar.vue'
</script>

<template>
  <NavBar />
  <main><RouterView /></main>
  <FooterBar />
</template>