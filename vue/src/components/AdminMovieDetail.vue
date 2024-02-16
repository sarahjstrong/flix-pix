<template>
        <div class="movie-card">
            <img class="movie-thumbnail" src='https://m.media-amazon.com/images/M/MV5BMDQ0NjgyN2YtNWViNS00YjA3LTkxNDktYzFkZTExZGMxZDkxXkEyXkFqcGdeQXVyODE5NzE3OTE@._V1_SX300.jpg' alt="">
            <div class="info-container">
                <div class="movie-text">
                    <h1 style="font-family: 'mont';">{{ movie.title }}</h1>
                    <h3 class="movie-year">{{ movie.releaseYear }} • Directed by</h3>
                    <h2 class="movie-director">{{ movie.director }}</h2>
                    <h4 class="movie-genre">Genre</h4>
                    <p class="movie-plot">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Magnam sapiente dolorem pariatur explicabo quia, hic tenetur est. Ut quidem atque, officia corrupti iusto ea recusandae ratione, quos, quam cumque culpa. Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolor consequatur fugit tempore asperiores sit obcaecati beatae eius doloribus eligendi officia cum, explicabo eaque nesciunt cumque ab deserunt facere inventore? Fugit.</p>
                </div>
                <div class="btn-container">
                    <button class="btn" v-on:click="updateMoviesOnSite">{{addBtn}}</button>
                </div>

            </div>
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


    .movie-card{
        display: flex;
        justify-content: space-around;
        /* display: flex;
        justify-items: flex-start;

        border-radius: 1vh;
        box-shadow: 20px 20px 20px  rgba(0, 0, 0, 0.1);
        margin-bottom: 12vh;
        text-align: center;
        border: 5px solid #dbdbdb; */
        /* flex: 1; */
    }
    .info-container{
        display: flex;
        flex-direction: column;
        background-color: #FFF6D7;
        width: 50%;
        padding-left: 50px;
        padding-right: 50px;
        padding-top: 40px;
        box-shadow: 20px 20px 20px  rgba(0, 0, 0, 0.1);
        border-radius: 1vh;
        border: 5px solid #dbdbdb;
    }

    img{
        width: 25%;
        box-shadow: 20px 20px 20px  rgba(0, 0, 0, 0.1);
        border-radius: 1vh;
        border: 5px solid #dbdbdb;
    }

    .btn {
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 1.2em;
        font-family: 'mont';
        width: 50%;
        height: 10%;
        background-color: #893222;
        color: #dbbe4b;
        border: none;
        cursor: pointer;
        border-radius: 50px;
        outline: none;
        cursor: pointer;
        position: relative;
        /* box-shadow: 20px 20px 20px rgba(0, 0, 0, 0.1); */
        overflow: hidden;
        transition: transform 0.3s;
        margin-top: 30px;
    }

    .btn-container{
        display: flex;
        flex-grow: 1;
        justify-content: center;
    }

    p{
        font-size: 1.4em;
        margin-top: 60px;
        margin-bottom: 60px;
    }

    h4{
        font-style: italic;
    }

    .movie-genre{
        margin-top: 60px;
    }


</style>