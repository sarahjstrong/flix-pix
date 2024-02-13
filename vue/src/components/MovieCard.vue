<template>
    <div class="movie-card">
        <h3 class="movie-title">{{ movie.title }}</h3>
        <p class="movie-director">Dir. {{ movie.director }}</p>
        <p class="movie-year">r. {{ movie.releaseYear }}</p>
        <img class="movie-thumbnail" :src="movie.img" alt="">
        <button class="info-btn" v-on:click="moreInfo">More info</button>
    </div>


</template>

<script>
    export default {
        props: ["movie"],
        methods: {
           moreInfo(id) {
                this.$router.push( {name: 'movie', params: { movieId: id}} );
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
        flex: 1;
    }

    .movie-thumbnail{
        height: 600px;
        width: 400px;
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