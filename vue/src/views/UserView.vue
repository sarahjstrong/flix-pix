<template>
    <div class="container">
        <div class="profile-info">
            <div class="profile-image">
                <img src="../assets/images/useravatar.jpg"  alt="User Avatar" style="width: 200px; height: 200px; border-radius: 50%; margin-bottom: 10px; border: 2px solid #893222;">
            </div>
            
            <h1 class="fav-header" style="font-family: 'mont';">{{ user.username }}</h1>
            <h3>{{ user.location }}</h3>
            <h3 class="about-me">{{ user.aboutMe }}</h3>
            <h4>Favorite Genres: </h4>
            <span v-for="(genre, index) in genres" v-bind:key="index">{{ genre }}&nbsp;&nbsp;</span>
            <h4>Favorite Directors: </h4>
            <span v-for="(director, index) in directors" v-bind:key="index">{{ director }}&nbsp;&nbsp;</span>
        </div>

        <div class="favorites-list">
            <h1 class="fav-header" style="font-family: 'mont';">Favorites</h1>
            <div class="movie-cards">
                <img v-for="movie in favorites" v-bind:key="movie.movieId" class="poster" :src="movie.poster" alt="movie-poster" v-on:click="goToMovie(movie.movieId)">
            </div>
        </div>

    </div>
</template>

<script>
    import UserService from '../services/UserService';
    import GenreService from '../services/GenreService';
    import DirectorService from '../services/DirectorService';
    import FavService from '../services/FavService';
    import MovieService from '../services/MovieService';

    export default{
        data() {
            return {
                user: {},
                genres: [],
                directors: [],
                favorites: []
            }
        },
        methods: {
            goToMovie(id) {
                this.$router.push({name: 'movie', params: {movieId: id}})
            }
        },
        created() {
            UserService.getUserById(this.$route.params.userId).then( response => {
              if(response.status === 200) {
                this.user = response.data;

                GenreService.getUserGenres(this.user.username).then( response => {
                    if(response.status === 200) {
                        if(response.data.length > 0) {
                            const userGenres = response.data;
                            this.genres = userGenres.map( cur => cur.genre);
                        }

                    }
                });

                DirectorService.getAllUserDirectors(this.user.id).then( response => {
                    if(response.status === 200) {
                        if(response.data.length > 0) {
                            const userDirectors = response.data;
                            this.directors = userDirectors.map( cur => cur.directorName);
                         }
                    }
                });

                FavService.getFavsByUserId(this.user.id).then(response => {
                if(response.status === 200) {
                        const favInfoList = response.data;
                        favInfoList.forEach(fav => {
                            MovieService.getMovieById(fav.movieId).then(response => {
                                if(response.status === 200) {
                                    this.favorites.push(response.data);
                                }
                            })
                        });
                }
            })
              }
          });





        }
    }
</script>

<style scoped>
    .favorites-list{
        display: flex;
        flex-direction: column;
        text-align: center;
        flex-wrap: wrap;
        border: 5px solid #dbdbdb;
        background-color: #FFF6D7;
        border-radius: 1vh;
        width: 50%;
        box-shadow: 20px 20px 20px rgba(0, 0, 0, 0.1);
        padding: 50px;
    }

    .about-me{
        margin-bottom: 70px;
    }

    .profile-image{
        text-align: center;
        margin-bottom: 70px;
    }

    .fav-header{
        margin-bottom: 50px;
    }

    .movie-cards{
        display: flex;
        flex-wrap: wrap;
        justify-content: space-around;
    }

    .profile-info{
        border: 5px solid #dbdbdb;
        background-color: #FFF6D7;
        border-radius: 1vh;
        width: 30%;
        box-shadow: 20px 20px 20px rgba(0, 0, 0, 0.1);
        padding: 50px;
        height: fit-content;
    }

    .container{
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        margin: 100px
    }


    .poster{
        width: 40%;
        border-radius: 10px;
        margin-bottom: 50px;
        cursor: pointer;
    }





</style>