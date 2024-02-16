<template>
        <div class="movie-card">
            <h2 class="movie-title">{{ movie.title }}</h2>
            <p class="movie-director">Dir. {{ movie.director }}</p>
            <p class="movie-year">r. {{ movie.releaseYear }}</p>
            <img class="movie-thumbnail" :src="movie.img" alt="">
            <button v-on:click="updateMoviesOnSite">addBtn</button>
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
                if(this.$store.state.movies.contains(this.movie)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        
    }
</script>

<style scoped>
    .movie-year{
        font-style: italic;
    }

    .movie-card{
        display: flex;
        flex-direction: column;
        width: 20%;
        margin: 25px;
        padding: 20px;
        border: 2px solid #893222;
        border-radius: 1%;
        align-items: center;
        justify-items: center;
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