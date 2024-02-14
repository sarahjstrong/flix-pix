<template>
    <div class="card-list">
        <movie-card class="card" v-for="(movie, index) in movies" v-bind:key=index v-bind:movie="movie"></movie-card>

    </div>
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
    .card-list {
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        align-items: stretch;
    }

    .movie-card{
        
    }
</style>