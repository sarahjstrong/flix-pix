<template>
    <div class="movie-img">
        <img :src="movie.poster" alt="">
    </div>

    <div class="movie-info">
        <h1>{{ movie.title }}</h1>
        <h2>{{ movie.director }}</h2>
        <h3>{{ movie.releaseYear }}</h3>
        <!-- Try and get stars to display rating -->
        <p>{{ movie.synopsis }}</p>
    </div>

    <div>
        <!-- Rating component here -->
    </div>


    <div class="favorite" v-on:click="favoriteMovie">
        <img src="../assets/images/heart.png" alt="heart" class="favorite-heart">
        <p>{{ favoriteStatus }}</p>
    </div>
</template>

<script>
    export default{
        props: ['movie'],
        data() {
            return {

            }
        },
        methods: {
            favoriteMovie() {
                if(this.$store.state.token != '') {
                    if(this.favoriteStatus === 'Favorite') {
                        this.$store.commit('ADD_MOVIE_TO_FAV', movie.id);
                    } else {
                        this.$store.commit('DELETE_MOVIE_FROM_FAV', movie.id);
                    }
                } else {
                    this.$router.push({ name: 'register' })
                }
            }
        },
        computed: {
            favoriteStatus() {
                // Make call to favorite service to receive list of all favorited movies
                // If favorited list DOES NOT contain current movie
                    return 'Favorite'
                // if not
                    // return '✓'
            }
        },
        created() {

        }
    }

</script>

<style scoped>
    .favorite-heart{
        width: 3%;
    }
</style>