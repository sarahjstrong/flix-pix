<template>
    <div class="card-list" v-show="totalResults > 0">
        <movie-card class="movie-card" v-for="(movie, index) in movies" v-bind:key=index v-bind:movie="movie"></movie-card>
    </div>

    <div class="no-results" v-show="totalResults === 0 && this.$store.state.browseSearchTerm != ''">
        <h3>No movies match your search</h3>
    </div>
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


    .card{
        margin: 5vh;
        width: 10vh;
        padding: 20vh;
        height: 2vh;
    }
    .card-list {
        display: flex;
        /* border: 5px solid #fff6d7;  */
        border-radius: 7px;
        /* background-color: #ededed; */
        /* margin: 40px;  */
        text-align: center;
        padding: 1px; 
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