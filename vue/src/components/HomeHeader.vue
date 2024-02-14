<template>
<body>
    <div class="main-img">
        <!-- Image will be of theater or popcorn. Buttons will go over the image and centered -->
        <!-- Adding app name that could be placed over the photo as well, along with a tagline -->
        <!-- Basically the photo will cover most of the page (under the nav bar) and the app name, tagline, and the two buttons will be on top of the photo -->
     <!-- need to add popcorn image in background  -->
     <div class="content-container">
        <h1 class="title-text">FLIX PIX</h1>
        <img src="../assets/images/logo.png" alt="popcorn" class="popcorn-img">
        <div class="button-container">
            <router-link :to="{ name: 'login' }">
                <button class="header-btn">Login</button>
            </router-link>

            <router-link :to="{ name: 'register' }">
                <button class="header-btn">Register</button>
            </router-link>
        </div>
        <h3 class="tagline-text">Your Favorite Online Pal For Searching For The Next Best Flick For You </h3>
    </div> 
</div>
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

.content-container {
    display: flex;
    flex-direction: column;
    align-items: center;
}

    
    
    .title-text {
        font-size: 5em;
        color: #dbbe4b ;
        /* text-shadow: 2px 2px 2px #dbbe4b; */
        text-align: center;
        font-family: 'mont';
        padding-top: 20%; /* Adjusted padding-top value */
        background: linear-gradient(to right, #ffffff, #dbbe4b,  #000000, #dbbe4b );
        background-size: 200% 100%;
        animation: gradientMove 3s linear infinite;
        -webkit-background-clip: text;
        background-clip: text;
        -webkit-text-fill-color: transparent; 
    }
    @keyframes gradientMove {
        0% {
            background-position: 0% 50%; /* Start position */
        }
        50% {
            background-position: 100% 50%; 
        }
        100% {
            background-position: 0% 50%; /* End position */
        }
    }


    .tagline-text {
        font-size: 2em;
        color: #dbbe4b;;
        text-shadow: 4px 4px 4px #000000;

    }
    .popcorn-img {
        width: 100px;
        height: 100px;
        margin-top: 10px; /* Adjusted margin-top value */
    }
    .button-container {
        display: flex;
        justify-content: center;
        margin-top: 20px; /* Adjust as needed */
        padding-left: 2%;
        padding-bottom: 5%;
    }

    .header-btn {
        font-size: 1.5em;
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
        box-shadow: 0 15px 30px rgba(0, 0, 0, 0.5);
        overflow: hidden;
        transition: transform 0.3s;

    }

  
    .header-btn:hover {
        background-color: #6d271b;
        transform: scale(1.2);
    }

    
</style>
