<template>
    <div class="container">
    <div v-if="!editMode" class="profile-card">
      
      <div class="profileShown">
        <h2 style="text-decoration: underline; font-family:'mont';">Profile</h2>
        <p style="font-family: 'roboto';"><strong>Username:</strong> {{ username }}</p>
        <p style="font-family: 'roboto';"><strong>Email:</strong> {{ email }}</p>
        <p style="font-family: 'roboto';"><strong>Password:</strong> ********</p>
        <p style="font-family: 'roboto';"><strong>Genres:</strong></p>
        <ul>
          <li v-for="genre in selectedGenres" :key='genre.id'>{{ genre.name }}</li>
        </ul>
        <p><strong>Favorite Director:</strong> {{ director }}</p>
        <button @click="editMode = true">Edit</button>
      </div>
    </div>
      <div v-else>
        <form class="profile-form">
          <h2>Edit Profile</h2>
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
              <div v-for="genre in genres" :key="genre.id">
                <input type="checkbox" :id="genre.id" :value="genre" v-model="selectedGenres">
                <label :for="genre.id">{{ genre.name }}</label>
              </div>
            </div>
          </div>
          <div class="form-group">
            <label for="director">Favorite Director</label>
            <input type="text" id="director" v-model="director">
          </div>
          <button @click="saveChanges">Save</button>
          <button @click="cancelEdit">Cancel</button>
        </form>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        editMode: false,
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
    },
    methods: {
      saveChanges() {
        // Save changes to the backend here
        this.editMode = false; //exit
      },
      cancelEdit() {
        // Reset form fields to original values
        this.editMode = false; 
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
     
    .container {
     display: flex;
     justify-content: center;
    align-items: center; 
    height: 100vh; 
}
    .profile-card {
    border: 5px solid #dbdbdb;
    background-color: aliceblue;
    border-radius: 7px;
    width: 300px;
    height: 350px;
    box-shadow: 20px 20px 20px rgba(0, 0, 0, 0.1);
    }
    .profileShown {
        text-align: center; 
    }

    </style>
    