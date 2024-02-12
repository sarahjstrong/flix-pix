<template>
    <div class="header-img">
        <!-- Image will be of theater or popcorn. Buttons will go over the image and centered -->
        <!-- Adding app name that could be placed over the photo as well, along with a tagline -->
        <!-- Basically the photo will cover most of the page (under the nav bar) and the app name, tagline, and the two buttons will be on top of the photo -->
        <img src="placeholder" alt="">
    </div>

    <div>
        <h1 class="title-text">Flix Pix</h1>
        <h3 class="tagline-text">Your favorite online pal for searching for the next best flick for you</h3>
    </div>

    <router-link :to="{ name: 'login' }">
        <button class="header-btn">Login</button>
    </router-link>

    <router-link :to="{ name: 'register' }">
        <button class="header-btn">Register</button>
    </router-link>
</template>

<script>

</script>

<style scoped>

</style>