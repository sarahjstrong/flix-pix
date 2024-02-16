<template>
    <div class="card-list" v-show="totalResults > 0">
        <admin-movie-card class="card" v-for="(movie, index) in movies" v-bind:key=index v-bind:movie="movie"></admin-movie-card>
    </div>

    <div class="no-results" v-show="totalResults ===0">
        <h3>No movies match your search</h3>
    </div>
    </template>

<script>
    import AdminMovieCard from './AdminMovieCard.vue';

    export default {
        props: ['movies'],
        components: {
            AdminMovieCard
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