<template>
  <div id="capstone-app">
    <!-- Nav -->
    <header id="nav">

      <div class="logo">
        <img src="./assets/images/logo.png" alt="logo">
        </div>
        <div class="nav-links">
      <router-link class="nav-link home" v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link class="nav-link browse" :to="{name: 'browse'}">Browse</router-link>
      <router-link class="nav-link recommended" :to="{name: 'recommended'}">Recommended</router-link>
      <router-link class="nav-link profile" :to="{name: 'profile'}">Profile</router-link>
        </div>

     <!-- This div will only be rendered if the token in the Vuex store is not an empty string -->
      <div v-if="this.$store.state.token != ''">
        <router-link class="nav-link" v-bind:to="{ name: 'logout' }">Logout</router-link>
      </div>
      
    </header>
  
        <router-view />
      </div>
</template>

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
  background-color: #893222;
  display: flex;
  /* justify-content: space-between; */
  align-items: center;
  height: 100%;
  padding-bottom: 5px;
  /* border-bottom: 2px solid #000000; */

}
.nav-links {
  display: flex;
  justify-content: center;
  align-items: center;
  padding-left: 7;

  
}

.nav-link {
  color: #dbbe4b;
  text-decoration: none;
  font-size: 30px;
  font-family: 'mont';
  transition: transform 0.3s;
  margin: 0px 15px;
}

.nav-link.home:hover {
  color: #000000;
  transform: scale(1.2);
}

.nav-link.browse:hover {
  color: #000000;
  transform: scale(1.2);
}

.nav-link.profile:hover {
  color: #000000;
  transform: scale(1.2);
}

.nav-link.logout:hover {
  color: #000000;
  transform: scale(1.2);
}

.nav-link.recommended:hover {
  color: #000000;
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
