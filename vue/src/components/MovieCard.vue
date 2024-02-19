<template>
    <div class="movie-card">
        <div class="img">
            <img class="movie-thumbnail" :src="movie.poster" alt="">
        </div>
        <div class="info">
            <h2 class="movie-title">{{ movie.title }}</h2>
            <p class="movie-director">Dir. {{ movie.director }}</p>
            <p class="movie-year">r. {{ movie.releaseYear }}</p>
                <button class= "info-btn" v-on:click="getMoreDetails">More Details</button>
        </div>
    </div>
</template>
<script>
    export default {
        props: ["movie"],
        methods: {
           getMoreDetails() {
                this.$router.push( {name: 'movie', params: { movieId: this.movie.movieId}} );
           }
        }
    }
</script>
<style scoped>
@font-face {
    font-family: 'mont';
    src: url(../assets/fonts/MontereyFLF.ttf);
}
.movie-card {
    position: relative;
    display: flex;
    width: 30%;
    margin-right: 2%;
    border: 5px solid #dcdcdc;
    background-color: #FFF6D7;
    margin-top: 10vh;
    border-radius: 10px;
    overflow: hidden;
}

@media  (max-width: 768px) {
    .movie-card {
        width: 30vh; 
    }
}

@media (max-width: 480px) {
    .movie-card {
        width: 30vh; 
    }
}

.img {
    width: 30vh; 
    height: 375px;    
    overflow: hidden;
    border-radius: 10px;
}

.movie-thumbnail {
    width: 100%;
    height: auto;
}

.info {
    display: flex;
    flex-direction: column;
    justify-content: space-evenly; 
    padding: 20px;
    width: 60%; 
}

.movie-title {
    margin-top: 0;
    margin-bottom: 5px;
    font-size: 35px;
    font-family: 'mont';
}

.movie-director,
.movie-year {
    margin: 0;
    font-style: italic;
}

.info-btn {
    align-self: center ;
    font-size: 1.2em;
    font-family: 'mont';
    margin-left: 13%;
    background-color: #893222;
    color: #dbbe4b;
     border: none;
    cursor: pointer;
    border-radius: 50px;
    margin-right: 10%;
    transition: transform 0.3s;

}


.info-btn:hover {
    background-color: #6d271b;
        transform: scale(1.2);  
}
</style>
