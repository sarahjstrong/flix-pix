<template>
    <!-- {{ isFavorited }}

    {{ thisFav }} -->
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

    <div class="rating-component">
        <!-- Rating component here -->
    </div>


    <div class="favorite">
        <h1 :class="(isFavorited) ? 'heart fav' : 'heart reg'" v-on:click="toggleFavorite">♥</h1>
        <p>{{ textStatus }}</p>
    </div>
</template>

<script>
    import FavService from '../services/FavService'
    export default{
        props: ['movie'],
        data() {
            return {
                hasReview: '',
                thisFav: '',
                isFavorited: false,

            }
        },
        methods: {
            toggleFavorite() {
                if(this.isFavorited === false) {
                    const newFav = {};
                    newFav.userId = this.$store.state.user.id;
                    newFav.movieId = this.movie.movieId;
                    FavService.addFavorite(newFav).then(response => {
                        this.isFavorited = true;
                    }).catch(error => {

                    });
                } else {
                    FavService.deleteFavorite(parseInt(this.thisFav.favoriteId)).then(response => {
                        if(response.status === 204) {
                            this.isFavorited = false;
                        }
                    });
                }
            }
        },
        computed: {
            textStatus() {
                if(this.isFavorited === true) {
                    return '✓ Added'
                } else {
                    return 'Add'
                }
            },
        },
        created() {
            FavService.getFavsByUserId(this.$store.state.user.id).then( response => {
                    if(response.status === 200) {
                        const userFavs = response.data;
                        let match = userFavs.find(curFav => curFav.movieId === this.movie.movieId);
                        if(match != undefined) {
                            this.isFavorited = true;
                        }
                        this.thisFav = match;

                    }
                    });
                    
      
        }
    }

</script>

<style scoped>
    .heart{
        font-size: 5rem;
        cursor: pointer;
    }


</style>