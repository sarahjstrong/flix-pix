<template>
        <div class="movie-card">
            <div class="img">
                <img class="movie-thumbnail" :src="movie.poster" alt="">
            </div>
            <div class="info">
                <h2 class="movie-title">{{ movie.title }}</h2>
                <p class="movie-director">Dir. {{ movie.director }}</p>
                <p class="movie-year">r. {{ movie.releaseYear }}</p>
            </div>
            <div class="info-btn">
                <button v-on:click="getMoreDetails">More Details</button>
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
.movie-card {
    display: flex;
    /* width: 100%; */
    /* margin-bottom: 20px; */
    border: 2px solid #893222;
    border-radius: 10px;
    overflow: hidden;
}

.img {
    margin-right: 40px; 
    max-width: 250px;
    margin-left: 0px;
    border-radius: 10px 0 0 10px;
    /* margin-bottom: 90vh; */
}

.info {
    flex: 0 0 60%;

    padding: 0px;
}

.movie-title {
    margin-top: 0;
    margin-bottom: 10px;
    font-size: 20px;
}

.movie-details {
    margin-bottom: 10px;
}

.more-info-btn {
    padding: 10px 20px;
    font-size: 16px;
    background-color: #893222;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.more-info-btn:hover {
    background-color: #6e261b;
}
</style>