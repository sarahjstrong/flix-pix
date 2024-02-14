<template>
    <h2 style="text-decoration: underline; font-family:'mont';">Profile</h2>
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

</style>