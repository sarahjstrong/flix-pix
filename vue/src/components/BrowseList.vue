<template>
    <movie-card class="card" v-for="(movie, index) in movies" v-bind:key=index v-bind:movie="movie"></movie-card>
</template>

<script>
    import MovieCard from './MovieCard.vue';

    export default {
        props: ['movies'],
        components: {
            MovieCard
        },
        
    }
</script>

<style scoped>
    template {
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        align-items: stretch;
    }
</style>