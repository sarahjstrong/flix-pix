<template>
        <div class="card" v-for="(movie, index) in movies" v-bind:key=index>
                <movie-card class="card" v-bind:movie="movie"></movie-card>
        </div>
        



        <h3>No movies match your search</h3>

    </template>

<script>
    import MovieCard from './MovieCard.vue';

    export default {
        props: ['movies'],
        components: {
            MovieCard
        },
        computed: {
            totalResults() {
                return this.movies.length;
            }
        }
        
    }
</script>

<style scoped>
    .card-list {
        display: flex;
        border: 5px solid #fff6d7; 
        border-radius: 7px;
        background-color: #fff6d7;
        margin: 50px; 
        text-align: center;
        padding: 20px; 
        box-sizing: border-box;
        box-shadow: 20px 20px 20px rgba(0, 0, 0, 0.1);
        flex-wrap: wrap;
        justify-content: space-around;

    }

    h3{
        color: #dbbe4b;
        text-align: center;
    }





</style>