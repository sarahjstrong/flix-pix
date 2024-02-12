<template>
  <div id="capstone-app">
    
    
    <div id="nav">
      <router-link class="nav-link" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;&nbsp;
      <router-link class="nav-link" :to="{name: 'browse'}">Browse</router-link>&nbsp;&nbsp;
      <router-link class="nav-link" :to="{name: 'profile'}">Profile</router-link>&nbsp;&nbsp;
    </div>
    <div>
      <router-link class="nav-link" v-bind:to="{ name: 'logout' }" v-if="this.$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>
