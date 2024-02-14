<template>
    <form class="profile-form" v-show="show">
          <!-- I don't think we need the email since it's not in our database. I was thinking we could add a bio section. -->
          <!-- After the form we could have a friends list and save/favorited movies -->
          <h2>Edit Profile</h2>

          <div class="form-group">
            <label for="username">Username: </label>
            <input type="text" id="username" v-model="user.username">
          </div>

          <div>
            <label for="bio">Bio: </label>
            <input type="text" id="bio" v-model="user.bio">
          </div>

          <div class="form-group">
            <label for="genres">Genres: </label>
            <div class="genre-checkboxes">
              <div v-for="genre in genres" :key="genre.id">
                <input type="checkbox" :id="genre.id" :value="genre.name" v-model="selectedGenres">
                <label :for="genre.id">{{ genre.name }}</label>
              </div>
            </div>
          </div>

          <div class="form-group">
            <label for="director">Favorite Directors: </label>
            <input type="text" id="director" v-model="currentDirector">
            <button class="add-director-btn" v-on:click="addDirector">Add</button>
            <div class="user-directors" v-for="(director, index) in userDirectors" v-bind:key="index">
                <span>{{ director }} | </span>
            </div>
          </div>
          <button @click="saveChanges">Save</button>
          <button @click="cancelEdit">Cancel</button>
        </form>
</template>

<script>

    export default{
        data() {
            return {
                user: this.$store.state.user,
                show: true,
                selectedGenres: [],
                genres: [
                    { id: 1, name: 'Action' },
                    { id: 2, name: 'Comedy' },
                    { id: 3, name: 'Drama' },
                    { id: 4, name: 'Horror' },
                    { id: 5, name: 'Sci-Fi' },
                    { id: 6, name: 'Thriller' }
        ],
            currentDirector: '',
            }
        },
        methods: {
            addDirector() {
                if(!this.currentDirector === '') {
                    this.$store.commit('ADD_DIRECTOR', this.currentDirector);
                }
                this.currentDirector = '';
            },
            saveChanges() {
                // Save changes to the backend here
                // call services to update user and genres table (director is already updated through add button)
                this.show = false; //exit
            },

            cancelEdit() {
                // Reset form fields to original values
                this.show = false; 
            }
        },
        computed: {
            userDirectors() {
                // Call to user-director service to receive list of all favorited directors
                return null;
            }
        }
    }

</script>