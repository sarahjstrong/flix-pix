<template>
        <div class="movie-card">
            <img class="movie-thumbnail" :src='movie.poster' alt="">
            <div class="info-container">
                <div class="movie-text">
                    <h1 style="font-family: 'mont';">{{ movie.title }}</h1>
                    <h3 class="movie-year">{{ movie.releaseYear }} • Directed by</h3>
                    <h2 class="movie-director">{{ movie.director }}</h2>
                    <p class="movie-plot">{{ movie.plot }}</p>
                    <h4 class="movie-genre">{{movie.genre}}</h4>
                </div>
                <div class="btn-container">
                    <button class="btn" v-on:click="updateMoviesOnSite">{{addBtn}}</button>
                </div>

            </div>
        </div>


</template>

<script>
    import MovieService from '../services/MovieService';
    export default {
        props: ["movie"],
        data() {
            return {
                movies: [],
                movieToAdd: {
                    title: this.movie.title,
                    releaseYear: this.movie.releaseYear,
                    genre: this.movie.genre,
                    director: this.movie.director,
                    poster: this.movie.poster,
                    plot: this.movie.plot,
                },
            }
        },
        methods: {
           updateMoviesOnSite() {
                MovieService.addNewMovie(this.movieToAdd).then(response => {

                }).catch( error => {

                })
           }
        },
        computed: {
            addBtn() {
                return 'Add Movie';
            },

        },
        created() {
            MovieService.getMovies().then( response => {
                if(response === 200) {
                    this.movies = response.data;
                }
            })
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
        width: 40%;
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
        margin-top: 50px;
    }

    .btn-container{
        display: flex;
        flex-grow: 1;
        justify-content: center;
        margin-top: 40px;
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