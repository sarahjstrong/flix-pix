<template>
        <h3 class="movie-title">{{ movie.title }}</h3>
        <p class="movie-year">{{ movie.year }}</p>
        <img class="movie-thumbnail" :src="movie.image" alt="">
        <button class="info-btn" v-on:click="moreInfo">More info</button>

</template>

<script>
    export default {
        props: ["movie"],
        methods: {
           moreInfo(id) {
                this.$router.push( {name: 'movie', params: { movieId: id}} );
           }
        }
        
    }
</script>

<style scoped>

</style>