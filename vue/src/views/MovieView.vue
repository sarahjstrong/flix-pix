<template>
    <h2>{{ movie.title }}</h2>
    <h3>Director: {{ movie.director }}</h3>
    <div class="rating">
        <h3>Rating: {{ movie.rating }}</h3>
    </div>
    <img :src="movie.img" alt="">
    <h3>Release Year: {{movie.year}}</h3>
    <div class="favorite-movie" v-on:click="favoriteMovie">
        <img src="../assets//images/heart.png" alt="heart">
        <p>{{ favorite }}</p>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                isFavorited: false
            }
        },
        computed: {
            movie() {
                const movieId = this.$route.params.movieId;
                return this.$store.state.movies.find(movie => movie.id === parseInt(movieId));
            },
            favorite() {
                if(this.isFavorited === false) {
                    return 'Favorite';
                } else {
                    return '✓';
                }
            }
        },
        methods: {
            favoriteMovie() {
                if(this.$store.state.token != '') {
                    if(this.isFavorited === false) {
                        this.$store.commit('ADD_MOVIE_TO_FAV', this.$route.params.movieId);
                        this.isFavorited = true;
                    } else {
                        this.$router.push({ name: 'register' })
                    }
                    

                }
            }
        }
    }
</script>

<style scoped>

</style>