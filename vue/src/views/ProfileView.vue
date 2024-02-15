<template>

  <!-- To properly make this page items within a flex box, we should make the profile card and profile form separate components that are used in the profile view -->
    <div class="container">
      <div v-if="!editMode" class="profile-info">
        <div class="profileShown">
          <profile-info v-bind:user="this.$store.state.user"></profile-info>
          <button class= "edit-btn" @click="editMode = true" >Edit</button>
        </div>
      </div>
      <div v-else class="profile-info">
        <edit-profile-form></edit-profile-form>
      </div>

    <div class="profile-favs">
      <favorites-list></favorites-list>
    </div>

    <div class="profile-friends">
      <friends-list></friends-list>
    </div>

  </div>

  </template>
  
  <script>
  import FavoritesList from '../components/FavoritesList.vue'
  import ProfileInfo from '../components/ProfileInfo.vue';
  import EditProfileForm from '../components/EditProfileForm.vue'
  import FriendsList from '../components/FriendsList.vue';

  export default {
    data() {
      return {
        editMode: false,
        username: this.$store.state.username,

      }
    },
    components: {
      FavoritesList,
      ProfileInfo,
      EditProfileForm,
      FriendsList
    },
    methods: {

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
      height: 100vh;
     display: grid;
     grid-template-columns: 1fr, 1fr, 1fr;
     grid-template-rows: 1fr, 1fr, 1fr;
     grid-template-areas:
     "info info friends"
     "info info friends"
     "fav fav fav"
     ;
     justify-items: center;
    align-items: center; 
    height: 100vh;
    margin: 100px;
}
    .profile-favs {
      grid-area: fav;
    border: 5px solid #dbdbdb;
    background-color: rgb(255, 252, 244);
    border-radius: 7px;
    width: 100%;
    height: 100%;
    box-shadow: 20px 20px 20px rgba(0, 0, 0, 0.1);
    text-align: center;
    margin-top: 40px
    }

    .profile-info {
      grid-area: info;
    border: 5px solid #dbdbdb;
    background-color: rgb(255, 252, 244);
    border-radius: 2vh;
    width: 100%;
    height: 100%;
    max-width: 88vh;
    max-height: 500vh;
    box-shadow: 20px 20px 20px  rgba(0, 0, 0, 0.1);
    margin-right: 25%;
    margin-bottom: 70px;
    text-align: center
    }

    .profile-friends {
      grid-area: friends;
    border: 5px solid #dbdbdb;
    background-color: rgb(255, 252, 244);
    border-radius: 7px;
    width: 100%;
    height: 100%;
    box-shadow: 20px 20px 20px rgba(0, 0, 0, 0.1);
    text-align: center;
    margin-bottom: 70px

    }
    
/* tweaked btn */
    .edit-btn{
        font-size: 1.2em;
        font-family: 'mont';
        padding: 5px 10px;
        margin: 10px;
        background-color: #893222;
        color: #dbbe4b;
        border: none;
        cursor: pointer;
        border-radius: 50px;
        outline: none;
        cursor: pointer;
        position: relative;
        box-shadow: 20px 20px 20px rgba(0, 0, 0, 0.1);
        overflow: hidden;
        transition: transform 0.3s;
}

.edit-btn:hover {
        background-color: #6d271b;
        transform: scale(1.2);  
      }


    </style>
    