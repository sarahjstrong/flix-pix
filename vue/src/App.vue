<template>
  <div id="capstone-app">


    <!-- Nav -->
    <header id="nav">
      <div class="logo">
        <img src="./assets/images/logo.png" alt="logo">
      </div>

      <div class="all-nav-links">

        <div class="left-nav-links">
          <router-link class="nav-link home" v-bind:to="{ name: 'home' }">Home</router-link>
          <router-link class="nav-link browse" :to="{name: 'browse'}">Browse</router-link>
          <!-- !-- This div will only be rendered if the token in the Vuex store is not an empty string -->
          <router-link v-if="this.$store.state.token != '' && isAdmin === false" class="nav-link recommended" :to="{name: 'recommended'}">Recommended</router-link>
        </div>



      <div v-if="this.$store.state.token != ''" class="right-nav-links">
          <div v-if="isAdmin === true">
            <router-link :to="{ name: 'admin' }" class="nav-link admin" v-show="isAdmin">Admin</router-link>
          </div>

          <div v-if="isAdmin === false">
            <router-link class="nav-link profile" :to="{name: 'profile'}">Profile</router-link>

          </div>

          <router-link class="nav-link logout" v-bind:to="{ name: 'logout' }">Logout</router-link>
      </div>
  
      </div>


      
    </header>
  
        <router-view />
      </div>
</template>

<script>

  export default{
    computed: {
      isAdmin() {
        // call to user service to receive role info
        // if role === admin return TRUE
        // else return FALSE
        return true;
      }
    }
  }

</script>

<style>
@font-face {
  font-family: 'mont';
  src: url(./assets/fonts/MontereyFLF.ttf);
}

@font-face {
  font-family: 'roboto';
  src: url(./assets/fonts/Roboto-Regular.ttf);
}

body{
  margin: 0;
  font-family: 'roboto', 'mont';

}

#nav {
  display: flex;
  background-color: #893222;
  /* justify-content: space-between; */
  align-items: center;
  height: 100%;
  padding-bottom: 5px;
  /* border-bottom: 2px solid #000000; */
}

.all-nav-links{
  display: flex;
  flex-grow: 1;
  justify-content: space-between;
  align-items: center;
}

.right-nav-links{
  display: flex;
}




.nav-link {
  color: #dbbe4b;
  text-decoration: none;
  font-size: 25px;
  font-family: 'mont';
  transition: transform 0.3s;
  margin: 0px 15px;
}

.nav-link.home:hover {
  color: #212121;
  transform: scale(1.2);
}

.nav-link.browse:hover {
  color: #212121;
  transform: scale(1.2);
}

.nav-link.profile:hover {
  color: #212121;
  transform: scale(1.2);
}

.nav-link.logout:hover {
  color: #212121;
  transform: scale(1.2);
}

.nav-link.recommended:hover {
  color: #212121;
  transform: scale(1.2);
}



.logo img {
  padding-left: 5%;
  width: 35px;
  height: 40%;
}

/* need to add logo */
html {
  background-color: #893222;

}

</style>
