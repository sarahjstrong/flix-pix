<template>
    <form class="profile" v-show="show" v-on:submit.prevent="saveChanges">
          <!-- I don't think we need the email since it's not in our database. I was thinking we could add a bio section. -->
          <!-- After the form we could have a friends list and save/favorited movies -->
          <h1 style="font-family: 'mont'; margin-left: 10%;">Edit Profile</h1>
      <div class = "form-info-container" >
          <div class="form-group">
            <label for="location" >Location: </label>
            <input type="text" id="location" v-model="userEdit.location">
          </div>

          <div class="form-group">
            <label for="bio">About me: </label>
            <input type="text" id="bio" v-model="userEdit.aboutMe">
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
            <input type="text" id="director" v-model="directorType">
            <button class="add-director-btn" v-on:click.prevent="addDirector">Add</button>
            <div class="user-directors" v-for="(director, index) in selectedDirectors" v-bind:key="index">
                <span><div> {{ director.directorName }} <span>ⓧ</span></div></span>
            </div>
            </div>
          </div>
          <button class="save-btn" style="margin-left: 15%;">Save</button>
        </form>

        <div v-show="show === false">
          <h3>Changes saved!</h3>
        </div>
</template>

<script>
  import UserService from '../services/UserService'
  import GenreService from '../services/GenreService'
  import DirectorService from '../services/DirectorService'
    export default{
        data() {
            return {
                userEdit: {
                  id: '',
                  aboutMe: '',
                  location: ''
                },
                show: true,
                currentGenres: [],
                selectedGenres: [],
                userGenres: [],
                toAddGenre: {
                  userId: 0,
                  genre: ''
                },
                genres: [
                    { id: 1, name: 'Action' },
                    { id: 2, name: 'Comedy' },
                    { id: 3, name: 'Drama' },
                    { id: 4, name: 'Horror' },
                    { id: 5, name: 'Sci-Fi' },
                    { id: 6, name: 'Thriller' },
                    { id: 7, name: 'Crime' },
                    { id: 8, name: 'Romance' },
                    { id: 9, name: 'Fantasy' },
                    { id: 10, name: 'Family' },
                    { id: 11, name: 'Documentary' },
                    { id: 12, name: 'Musical' },
                ],
                userDirectors: [],
                selectedDirectors: [],
                directorType: '',
                toAddDirector: {
                  userId: 0,
                  directorName: ''
                },
            }
        },
        methods: {
            addDirector() {
              this.toAddDirector.userId = this.$store.state.user.id;
              this.toAddDirector.directorName = this.directorType;
              this.directorsToAdd.push(this.toAddDirector);
            },
            saveChanges() {
                UserService.updateUser(this.userEdit).then( response => {
                  if(response.status === 200) {
                    this.show = false;
                  }
                }).catch(err => {
                })



                this.selectedGenres.forEach(newGen => {
                  if(!this.currentGenres.includes(newGen)) {
                    this.toAddGenre.userId = this.$store.state.user.id;
                    this.toAddGenre.genre = newGen;
                    console.log(this.toAddGenre);
                    GenreService.addNewGenre(this.toAddGenre).then(response => {
                      if(response.status === 201) {
                        this.currentGenres.push(newGen);
                        this.userGenres.push(this.toAddGenre);
                      }
                    }).catch(err => {

                    })
                  }
                });

                this.userGenres.forEach(curGen => {
                  if(!this.selectedGenres.includes(curGen.genre)) {
                    GenreService.deleteGenre(curGen.userGenreId).then(response => {
                    });
                  }
                });



            },
        },
        computed: {

        },
        created() {
          UserService.getUserById(this.$store.state.user.id).then( response => {
              if(response.status === 200) {
                this.userEdit.id = response.data.id;
                this.userEdit.location = response.data.location;
                this.userEdit.aboutMe = response.data.aboutMe;
              }
          });

          GenreService.getUserGenres(this.$store.state.user.username).then( response => {
            if(response.status === 200) {
                this.userGenres = response.data;
                this.selectedGenres = this.userGenres.map( cur => cur.genre);
                this.currentGenres = this.selectedGenres;
            }
          });

          DirectorService.getAllUserDirectors(this.$store.state.user.id).then( response => {
            if(response.status === 200) {
                if(response.data.length > 0) {
                    const data = response.data;
                    this.userDirectors = data;
                    this.selectedDirectors = data;
                }
            }
          });

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
    font-size: xx-large;

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
        padding: 5px 18px;
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