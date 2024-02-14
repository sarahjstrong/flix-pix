<template>
    <!-- Profile contain a form to update information on your profile. Checkboxes to select genres. Text input field where you can type director name and click submit to save the director. -->
    <!-- Genre info and director info will be saved in the store for now. -->
    <!-- Second part: Favorited section that will list all the favorited movies.  -->

    
    <form class="profile-form">
        <h2>Profile</h2>
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" v-model="username">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" v-model="email">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" v-model="password">
        </div>

        <div class="form-group">
            <label for="genres">Genres</label>
            <div class="genre-checkboxes">
                <div v-for="genre in genres" v-bind:key="genre.id">
                    <input type="checkbox" v-bind:id="genre.id" v-bind:value="genre.id" v-model="selectedGenres">
                    <label v-bind:for="genre.id">{{ genre.name }}</label>
                </div>
            </div>
        </div>
        
        <div class="form-group">
            <label for="director">Favorite Director</label>
            <input type="text" id="director" v-model="director">
        </div>
        <div class="favorited-section">
            <h2>Favorited Movies</h2>
            <ul>
                <li v-for="movie in favoritedMovies" v-bind:key="movie.id">{{ movie.title }}</li>
            </ul>
        </div>
        


    </form>




</template>

<script>

export default {
    data() {
        return {
            username: '',
            email: '',
            password: '',
            genres: [
                { id: 1, name: 'Action' },
                { id: 2, name: 'Comedy' },
                { id: 3, name: 'Drama' },
                { id: 4, name: 'Horror' },
                { id: 5, name: 'Sci-Fi' },
                { id: 6, name: 'Thriller' }
            ],
            selectedGenres: [],
            director: ''
        }
    }
}
</script>





<style scoped>
    .profile-form {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin-top: 50px;
    }

    .form-group {
        display: flex;
        flex-direction: column;
        margin-bottom: 20px;
    }

    .genre-checkboxes {
        display: flex;
        flex-direction: column;
    }

    .favorited-section {
        margin-top: 50px;
    }
</style>