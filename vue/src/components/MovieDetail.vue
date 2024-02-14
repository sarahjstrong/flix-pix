<template>
    <div class="movie-img">
        <img :src="movie.img" alt="">
    </div>

    <div class="movie-info">
        <h1>{{ movie.title }}</h1>
        <h2>{{ movie.director }}</h2>
        <h3>{{ movie.releaseYear }}</h3>
        <!-- Try and get stars to display rating -->
        <div>{{ movie.rating }}</div>
        <p>{{ movie.synopsis }}</p>
    </div>

    <div class="user-rating" v-show="userRated">
        <h4>You rated this movie: {{ rating }}</h4>
        <p>{{ review }}</p>
    </div>

    <div class="favorite" v-on:click="favoriteMovie">
        <img src="../assets/images/heart.png" alt="heart">
        <p>{{ favoriteStatus }}</p>
    </div>
</template>

<script>

    export default{
        props: ['movie'],
        data() {
            return {
                userRating: [],
                userRated: false,
            }
        },
        methods: {
            getRating() {
                // Make call to rating service to get object for user rating for current movie
                // if(!response.data === null) {
                //     const userRatingObject = response.data;
                //     this.userRated = true;
                // } else {
                //     this.userRated = false;
                // }
                return null;
            },
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
            this.getRating();
        }
    }

</script>