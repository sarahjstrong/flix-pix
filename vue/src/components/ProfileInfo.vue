<template>
    <div class = "form-info-container">
        <h1 style="font-family: 'mont';">Profile</h1>
    <img src="../assets/images/useravatar.jpg"  alt="User Avatar" style="width: 100px; height: 100px; border-radius: 50%; margin-bottom: 10px; border: 2px solid #893222">
        <div class="user-info">
        <p style="font-family: 'roboto';"><strong>Username:</strong> {{ user.username }}</p>
        <div class="user-location">
            <p style="font-family: 'roboto';"><strong>Location: </strong> {{ user.location }}</p>
        </div>

        <p style="font-family: 'roboto';"><strong>About Me:</strong> {{ user.aboutMe }}</p>

        <div>
            <p style="font-family: 'roboto';"><strong>Favorite Genres:</strong></p>
            <span v-for="(genre, index) in genres" v-bind:key="index">{{ genre }}&nbsp;&nbsp;&nbsp;</span>
        <ul>
          <li v-for="genre in userGenres" :key='genre.id'>{{ genre }}</li>
        </ul>
        </div>
        <p style="font-family: 'roboto';"><strong>Favorite Directors:</strong></p>
        <span v-for="(director, index) in directors" v-bind:key="index">{{ director }}&nbsp;&nbsp;&nbsp;</span>

        </div>
        </div>
        <div class="ticket"><img src="../assets/images/goldticket.png" alt="ticket" width="110"></div>

</template>

<script>
    import UserService from '../services/UserService';
    import GenreService from '../services/GenreService';
    import DirectorService from '../services/DirectorService';
    export default {
        data() {
            return {
                user: {},
                genres: [],
                directors: [],
            }
        },
        computed: {
            userGenres(username) {
                // Call user-genre service to get list of genres based on userid
                return null;
            },

            userDirectors(username) {
                // Call user-director service to get list of directors based on userid
                return null;
            }
        },
        created() {
            UserService.getUserById(this.$store.state.user.id).then( response => {
              if(response.status === 200) {
                this.user = response.data;
              }
          });

          GenreService.getUserGenres(this.$store.state.user.username).then( response => {
            if(response.status === 200) {
                if(response.data.length > 0) {
                    const userGenres = response.data;
                    this.genres = userGenres.map( cur => cur.genre);
                }
                
            }
          });

          DirectorService.getAllUserDirectors(this.$store.state.user.id).then( response => {
            if(response.status === 200) {
                if(response.data.length > 0) {
                    const userDirectors = response.data;
                    this.directors = userDirectors.map( cur => cur.directorName);
                }
            }
          });

        }
    }
</script>

<style>
    .form-info-container{
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        margin-top: 5%;
        margin-left: 32%;
        /* padding: 2%; */
        padding-bottom: 0%;
        /* border: 2px solid #000000; */
        /* border-radius: 10px solid #000000; */
        /* background-color: #FFF6D7; */
        width: 50%;
    }

    .user-info{
        font-size: large;
    }
    .ticket {
        position: absolute;
        margin-top: 60px;
        /* bottom: 100px; */
        margin-left: 42%;      
    }
    .ticket2 {
        position: absolute;
        top: 80px;
    }
</style>