<template>
    <div class = "form-info-container">
    <h2 style="text-decoration: underline; font-family:'mont'; ">Profile</h2>
    <img src="../assets/images/useravatar.jpg"  alt="User Avatar" style="width: 100px; height: 100px; border-radius: 50%; margin-bottom: 10px;">

        <div class="user-info">
        <p style="font-family: 'roboto';"><strong>Username:</strong> {{ user.username }}</p>
        <div class="user-location">
            <p style="font-family: 'roboto';"><strong>Location: </strong> {{ user.location }}</p>
        </div>

        <p style="font-family: 'roboto';"><strong>About Me:</strong> {{ user.bio }}</p>

        <div>
            <p style="font-family: 'roboto';"><strong>Favorite Genres:</strong></p>
        <ul>
          <li v-for="genre in userGenres" :key='genre.id'>{{ genre }}</li>
        </ul>
        </div>
        <p style="font-family: 'roboto';"><strong>Favorite Directors:</strong></p>
        <ul>
          <li v-for="(director, index) in userDirectors" :key='index'>{{ director }}</li>
        </ul>
        </div>
        </div>
</template>

<script>
    export default {
        props: ['user'],
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
</style>