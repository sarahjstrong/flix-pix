<template>
    <!-- {{ this.$store.state.user.id }} {{ movie.movieId }} -->
    <movie-detail v-bind:movie="movie"></movie-detail>
</template>

<script>
    import MovieService from '../services/MovieService';
    import MovieDetail from '../components/MovieDetail.vue';
    export default {
        data() {
            return {
                movie: {},
            }
        },
        components: {
            MovieDetail,
        },
        created() {
            MovieService.getMovieById(this.$route.params.movieId).then( response => {
                this.movie = response.data;
            })
        }
    
    }
</script>

<style scoped>

</style>