<template>
    <!-- {{ isFavorited }}

    {{ thisFav }} -->
    <div class="movie-container">
            <img  class="movie-img" :src="movie.poster" alt="">

        <div class="movie-info">
            <div class="favorite">
                <h1 :class="(isFavorited) ? 'heart fav' : 'heart reg'" v-on:click="toggleFavorite">❤︎</h1>
                <p class="btn-status" style="margin-left: 2%;">{{ textStatus }}</p>
            </div>

            <div class="movie-text">
                <h1 style="font-family: 'mont';">{{ movie.title }}</h1>
                <h3>{{ movie.releaseYear }} • Directed by</h3>
                <h2>{{ movie.director }}</h2>
            </div>
        

        <!-- Try and get stars to display rating -->
            <p>{{ movie.plot }}</p>
        </div>

    <div class="rating-component">
        <!-- Rating component here -->
        <rating-area v-bind:movie="movie"></rating-area>
    </div>
    </div>



</template>

<script>
    import FavService from '../services/FavService'
    import RatingArea from './RatingArea.vue';
    export default{
        props: ['movie'],
        components: {
            RatingArea
        },
        data() {
            return {
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
        font-size: 4rem;
        cursor: pointer;
        max-width: 60px;
        /* margin-bottom: 15px; */
    }

    .heart.reg{
        color: rgb(243, 174, 174);
        opacity: 50%;
        transition: transform 0.3s;
        /* outline: orangered solid 2px; */

        

    }
    .heart.reg:hover{
        transform:scaleY(1.3)
    }

    .heart.fav{
        color: maroon;

    }
    

    .movie-container{
        display: flex;
        justify-content: space-between;
        padding-top: 40px;
        padding-left: 50px;
        padding-right: 50px;
    }

    .movie-img{
        width: 20%;

        box-shadow: 20px 20px 20px  rgba(0, 0, 0, 0.1);
        border-radius: 1vh;
        border: 5px solid #dbdbdb;
    }

    .movie-info{
        width: 30%;
        display: flex;
        flex-direction: column;
        background-color: #FFF6D7;
        padding-left: 50px;
        padding-right: 50px;
        padding-top: 10px;
        box-shadow: 20px 20px 20px  rgba(0, 0, 0, 0.1);
        border-radius: 1vh;
        border: 5px solid #dbdbdb;
    }

    p{
        font-size: 1.4em;
        margin-top: 60px;
        margin-bottom: 60px;
    }

    .btn-status{
        margin-top: 0px;
        font-size: 1.2rem;
    }



    .favorite{
        display: flex;
        flex-direction: column;
        
    }

    .rating-component{
        width: 30%;
        height: fit-content;
        display: flex;
        flex-direction: column;
        background-color: #FFF6D7;
        padding-left: 50px;
        padding-right: 50px;
        padding-top: 10px;
        box-shadow: 20px 20px 20px  rgba(0, 0, 0, 0.1);
        border-radius: 1vh;
        border: 5px solid #dbdbdb;

    }



</style>