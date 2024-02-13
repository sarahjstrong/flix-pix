<template>
  <div id="capstone-app">
    <!-- Nav -->
    <header id="nav">
<<<<<<< HEAD
      
      <router-link class="nav-link" v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link class="nav-link" :to="{name: 'browse'}">Browse</router-link>
      <router-link class="nav-link" :to="{name: 'recommended'}">Recommended</router-link>
      <router-link class="nav-link" :to="{name: 'profile'}">Profile</router-link>
      
=======
      <div class="logo">
        <img src="./assets/images/logo.png" alt="logo">
        </div>
        <div class="nav-links">
      <router-link class="nav-link home" v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link class="nav-link browse" :to="{name: 'browse'}">Browse</router-link>
      <router-link class="nav-link profile" :to="{name: 'profile'}">Profile</router-link>
        </div>
>>>>>>> c66ecbd84b25fc7d2c3429ecbdff2f140c0747b9
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
  justify-content: space-between;
  align-items: center;
  height: 100%;
  padding-left: 5px;
  padding-bottom: 5px;
}
.nav-links {
  display: flex;
  justify-content: center; /* Center the items horizontally */
  align-items: center;
}

.nav-link {
  color: #000000;
  text-decoration: none;
  font-size: 30px;
  font-family: 'mont';
  transition: transform 0.3s;
  margin: 0 15px;
}

.nav-link.home:hover {
  color: #dbbe4b;
  transform: scale(1.2);
}

.nav-link.browse:hover {
  color: #dbbe4b;
  transform: scale(1.2);
}

.nav-link.profile:hover {
  color: #dbbe4b;
  transform: scale(1.2);
}

.nav-link.logout:hover {
  color: #dbbe4b;
  transform: scale(1.2);
}
.logo img {
  padding-left: 10%;
  width: 35%;
  height: 40%;
}
/* need to add logo */
html {
  background-color: #fff7dc;

}

</style>
