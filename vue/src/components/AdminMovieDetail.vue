<template>
        <div class="movie-card">
            <div class="movie-text">
                <h1 class="movie-title">{{ movie.title }}</h1>
                <h2 class="movie-director">Directed by: {{ movie.director }}</h2>
                <h3 class="movie-year">Release year: {{ movie.releaseYear }}</h3>
                <p>{{ movie. }}</p>
            </div>
            <img class="movie-thumbnail" :src="movie.img" alt="">
            <button v-on:click="updateMoviesOnSite">{{addBtn}}</button>
        </div>


</template>

<script>
    export default {
        props: ["movie"],
        methods: {
           updateMoviesOnSite() {
            if(this.isAdded === false) {
                // Call api movie service to add this selected movie to database to appear on site
            } else {
                // Call api movie service to remove this selected movie from database so it doesn't appear on site
            }
            
           }
        },
        computed: {
            addBtn() {
                if(this.isAdded === false) {
                    return 'Add To Site';
                } else {
                    return 'Remove From Site';
                }
            },
            isAdded() {
                // if(this.$store.state.movies.contains(this.movie)) {
                    return false;
                // } else {
                    // return false;
                }
            }
        }
        
</script>

<style scoped>
    .movie-year{
        font-style: italic;
    }

    .movie-card{
        background-color: #FFF6D7;
        border-radius: 1vh;
        width: 100%;
        height: 100%;
        max-width: 35vw;
        max-height: 500vh;
        box-shadow: 20px 20px 20px  rgba(0, 0, 0, 0.1);
        margin-right: 5%;
        margin-bottom: 12vh;
        padding-left: 15vh;
        text-align: center;
        padding-right: 20%;
        border: 5px solid #dbdbdb;
        /* flex: 1; */
    }

    .movie-thumbnail{
        height: 50%;
        widows: 50%;
    }

    .info-btn{
        margin-top: 10px;
        width: 400px;
        height: 30px;
        font-size: 16px;
    }

    .movie-title{
        margin-bottom: 0px;
    }

    .movie-director{
        margin-bottom: 0px;
    }

</style>