<template>
    <form class="profile" v-show="show">
          <!-- I don't think we need the email since it's not in our database. I was thinking we could add a bio section. -->
          <!-- After the form we could have a friends list and save/favorited movies -->
          <h1 style="font-family: 'mont'; margin-left: 10%;">Edit Profile</h1>
      <div class = "form-info-container" >
          <div class="form-group">
            <label for="username" >Username: </label>
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
          </div>
          <button class="save-btn" style="margin-left: 15%;"    @click="saveChanges">Save</button>
          <button class="cancel-btn"  @click="cancelEdit">Cancel</button>
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

<style scoped>
  @font-face {
    font-family: 'mont';
    src: url(../assets/fonts/MontereyFLF.ttf);

  }
  @font-face {
    font-family: 'roboto';
    src: url(../assets/fonts/Roboto-Regular.ttf);
  }
  .form-info-container{
    /* border: 2px solid #000000; */
    justify-items: left;
    font-family: 'roboto';

  }

  .form-group {
    margin-bottom: 1rem;

  }
    .save-btn{
        font-size: 1.2em;
        font-family: 'mont';
        background-color: #893222;
        color: #dbbe4b;
        border: none;
        cursor: pointer;
        border-radius: 50px;
        margin-right: 2%;
        outline: none;
        cursor: pointer;
        position: relative;
        overflow: hidden;
        transition: transform 0.3s;
}

      .save-btn:hover {
        background-color: #6d271b;
        transform: scale(1.2);  
      }

      .cancel-btn{
        font-size: 1.2em;
        font-family: 'mont';
        background-color: #893222;
        color: #dbbe4b;
        border: none;
        cursor: pointer;
        border-radius: 50px;
        margin-right: 2%;
        outline: none;
      
        position: relative;
        overflow: hidden;
        transition: transform 0.3s;
      
      }

      .cancel-btn:hover {
        background-color: #6d271b;
        transform: scale(1.2);  
      }


        .add-director-btn{  
        font-family: 'mont';
        background-color: #893222;
        color: #dbbe4b;
        /* border-radius: 20px; */
        outline: none;
        cursor: pointer;
    
        overflow: hidden;
    
        
        }

    </style>