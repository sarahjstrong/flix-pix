<template>
    <h3 class="movie-title">{{ movie.title }}</h3>
    <p class="movie-year">{{ movie.year }}</p>
    <img class="movie-thumbnail" :src="movie.image" alt="">
</template>

<script>
    export default {
        props: ["movie"]
        
    }
</script>

<style scoped>

</style>