<template>
        <div>
            <h2 style="text-decoration: underline; font-family:'mont';">Favorited</h2>

            <div class="favorites">
                    <img class="fav-movie" :src="movie.poster" alt="movie-poster" v-for="movie in favMovies" v-bind:key="movie.movieId" v-on:click="goToMovie(movie.movieId)">
            </div>
        </div>


</template>

<script>

import FavService from '../services/FavService'
import MovieService from '../services/MovieService'

    export default {
        data() {
            return {
                favMovies: [],
            }
        },
        methods: {
           goToMovie(movieId) {
                this.$router.push({ name: 'movie', params: { movieId: movieId }})
           }
        },
        created() {
            FavService.getFavsByUserId(this.$store.state.user.id).then(response => {
                if(response.status === 200) {
                        const favInfoList = response.data;
                        favInfoList.forEach(fav => {
                            MovieService.getMovieById(fav.movieId).then(response => {
                                if(response.status === 200) {
                                    this.favMovies.push(response.data);
                                }
                            })
                        });
                }
            })
        }
    }
</script>

<style scoped>
    .favorites{
        display: flex;
        flex-wrap: wrap;
        justify-content: space-around;
    }

    .fav-movie{
        width: 15%;
        margin: 20px;
        cursor: pointer;
        border-radius: 10px;
    }


</style>