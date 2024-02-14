<template>
        <div>
            <h2 style="text-decoration: underline; font-family:'mont';">Favorited</h2>

            <div v-for="movie in favoriteMovies" v-bind:key="movie.id">
                <movie-card v-bind:movie="movie"></movie-card>
            </div>
        </div>


</template>

<script>

import MovieCard from '../components/MovieCard.vue'

    export default {
        data() {
            return {
                favoriteMovies: this.$store.state.favorites,
            }
        },
        components: {
            MovieCard
        }
    }
</script>

<style scoped>



</style>