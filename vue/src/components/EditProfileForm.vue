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

          <div class="form-group">
            <label for="bio">Bio: </label>
            <input type="text" id="bio" v-model="user.bio">
          </div>

          <div class="form-group genres">
            <label for="genres">Genres: </label>
            <div class="genre-checkboxes">
              <div class="items" v-for="genre in genres" :key="genre.id">
                <input type="checkbox" :id="genre.id" :value="genre.name" v-model="selectedGenres">
                <label class="genre-name" :for="genre.id">{{ genre.name }}</label>
              </div>
            </div>
          </div>

          <div class="form-group director-section">
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


  .form-group {
    display: flex;
    align-items: center;
    margin-bottom: 1rem;
    font-size: 19px;

  }

  .form-info-container{
    /* border: 2px solid #000000; */
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    

  }

  .genres {
    align-items: flex-start;
  }

  .genre-checkboxes{
    display: flex;
    flex-direction: column;
    justify-content: space-between;
  }


  .items {
    display: flex;
    justify-content: flex-start;
  }
    .save-btn{
        font-size: 1.2em;
        font-family: 'mont';
        padding: 5px 10px;
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
        margin-right: 5px;
}

      .save-btn:hover {
        background-color: #6d271b;
        transform: scale(1.2);  
      }

      .cancel-btn{
        font-size: 1.2em;
        font-family: 'mont';
        padding: 5px 10px;
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
        margin-left: 5px;
      
      }

      .cancel-btn:hover {
        background-color: #6d271b;
        transform: scale(1.2);  
      }


        .add-director-btn{  
          font-family: 'mont';
        background-color: #893222;
        color: #dbbe4b;
        height: 36px;
        /* border-radius: 20px; */
        outline: none;
        cursor: pointer;
    
        overflow: hidden;
    
        
        }

        input {
        width: 200px;
        height: 30px;
        font-size: 16px;
        margin-left: 10px;
        background-color: #ffffff
        }

        

    </style>