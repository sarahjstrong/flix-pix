<template>
<body>
    <div class="main-img">
        <!-- Image will be of theater or popcorn. Buttons will go over the image and centered -->
        <!-- Adding app name that could be placed over the photo as well, along with a tagline -->
        <!-- Basically the photo will cover most of the page (under the nav bar) and the app name, tagline, and the two buttons will be on top of the photo -->
     <!-- need to add popcorn image in background  -->
     <div>
        <h1 class="title-text">Flix Pix</h1>
        <h3 class="tagline-text">Your favorite online pal for searching for the next best flick for you</h3>
    </div> 
    </div>
    <router-link :to="{ name: 'login' }">
        <button class="header-btn">Login</button>
    </router-link>

    <router-link :to="{ name: 'register' }">
        <button class="header-btn">Register</button>
    </router-link>
</body>
</template>

<script>

</script>

<style scoped>

    .main-img {
        display: flex;
        justify-content: center;
        align-items: center;
        background-image: url('../assets/images/theater.jpg');
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        width: 100%;
        height: 100vh;
        border-bottom-right-radius: 10%  10%;
        border-bottom-left-radius: 10%  10%;
}

    

    .title-text {
        font-size: 5em;
        color: #dbbe4b ;
        text-shadow: 4px 4px 4px #000000;
        text-align: center;
    }

    .tagline-text {
        font-size: 2em;
        color: #dbbe4b;
        text-shadow: 4px 4px 4px #000000;

    }

    .header-btn {
        
        font-size: 1.5em;
        padding: 10px 20px;
        margin: 10px;
        border-radius: 10px;
        background-color: #893222;
        color: white;
        border: none;
        cursor: pointer;
    }

    .header-btn:hover {
        background-color: #6d271b;
    }

    
</style>