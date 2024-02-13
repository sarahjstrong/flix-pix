<template>
  <div id="capstone-app">
    <!-- Nav -->
    <header id="nav">
      
      <router-link class="nav-link" v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link class="nav-link" :to="{name: 'browse'}">Browse</router-link>
      <router-link class="nav-link" :to="{name: 'recommended'}">Recommended</router-link>
      <router-link class="nav-link" :to="{name: 'profile'}">Profile</router-link>
      
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
  font-family: 'roboto';

}

#nav {
  background-color: #893222;
  display: flex;
  justify-content: center;
  align-items: center;
  padding-bottom: 10px;
  height: 100%;
  margin: 0;
}

.nav-link {
  color: rgb(0, 0, 0);
  margin: 0 20px;
  text-decoration: none;
  font-size: 35px;
  font-family: 'mont';
  
}

.logo img {
  width: 70px; 
  justify-content: flex-end;
}
/* need to add logo */
html {
  background-color: #fff7dc;

}

</style>
