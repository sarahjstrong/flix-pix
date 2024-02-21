<template>
<body>
    <div>
     <!-- Mobile menu icon, shown only on small screens -->
     <input hidden class="check-icon" id="check-icon" name="check-icon" type="checkbox">
    <label class="icon-menu" for="check-icon">
      <div class="bar bar--1"></div>
      <div class="bar bar--2"></div>
      <div class="bar bar--3"></div>
    </label>


   <!-- Navigation bar -->
   <nav class="navbar" :class="{ 'show-menu': isMenuOpen }">
      <ul>
        <li><router-link to="/">Home</router-link></li>
        <li><router-link to="/browse">Browse</router-link></li>
        <li v-if="this.$store.state.token !== ''"><router-link to="/recommended">Recommended</router-link></li>
        <!-- Profile and logout links are not included in the menu icon -->
        <li v-if="this.$store.state.token !== ''"><router-link to="/profile">Profile</router-link></li>
        <li v-if="this.$store.state.token !== ''"><router-link to="/logout">Logout</router-link></li>
      </ul>
    </nav>

    </div>
    <div class="main-img">
        <!-- Image will be of theater or popcorn. Buttons will go over the image and centered -->
        <!-- Adding app name that could be placed over the photo as well, along with a tagline -->
        <!-- Basically the photo will cover most of the page (under the nav bar) and the app name, tagline, and the two buttons will be on top of the photo -->
     <div class="content-container">
        <h1 class="title-text">FLIX PIX</h1>
        <img src="../assets/images/logo.png" alt="popcorn" class="popcorn-img">
        <div class="button-container">
            <router-link :to="{ name: 'login' }" v-show="this.$store.state.token === ''">
                <button class="header-btn">Login</button>
            </router-link>

            <router-link :to="{ name: 'register' }" v-show="this.$store.state.token === ''">
                <button class="header-btn">Register</button>
            </router-link>
        </div>
        <h3 class="tagline-text">Your Favorite Online Pal For Searching For The Next Best Flick For You </h3>
    </div> 
</div>
</body>
</template>

<script>
export default {
  data() {
    return {
      isMenuOpen: false
    };
  },
  mounted() {
    this.toggleMenu();
    window.addEventListener('resize', this.handleResize);
  },
beforeUnmount() {
    window.removeEventListener('resize', this.handleResize);
  },
  methods: {
    toggleMenu() {
      this.isMenuOpen = !this.isMenuOpen;
    },
    handleResize() {
      if (window.innerWidth <= 768) {
        this.isMenuOpen = true; 
      } else {
        this.isMenuOpen = false; 
    }
  }
}
};
</script>

<style scoped>

@media only screen and (max-width: 768px) {
  .navbar ul {
    display: none;
  }
  .navbar.show-menu ul {
    display: block;
  }
}
.icon-menu {
  --gap: 5px;
  --height-bar: 2.5px;
  --pos-y-bar-one: 0;
  --pos-y-bar-three: 0;
  --scale-bar: 1;
  --rotate-bar-one: 0;
  --rotate-bar-three: 0;
  width: 25px;
  display: flex;
  flex-direction: column;
  gap: var(--gap);
  cursor: pointer;
  position: relative;
}

.bar {
  position: relative;
  height: var(--height-bar);
  width: 100%;
  border-radius: .5rem;
  background-color: #9941fc;
}

.bar--1 {
  top: var(--pos-y-bar-one);
  transform: rotate(var(--rotate-bar-one));
  transition: top 200ms 100ms, transform 100ms;
}

.bar--2 {
  transform: scaleX(var(--scale-bar));
  transition: transform 150ms 100ms;
}

.bar--3 {
  bottom: var(--pos-y-bar-three);
  transform: rotate(var(--rotate-bar-three));
  transition: bottom 200ms 100ms, transform 100ms;
}

.check-icon:checked + .icon-menu > .bar--1 {
  transition: top 200ms, transform 200ms 100ms;
}

.check-icon:checked + .icon-menu > .bar--3 {
  transition: bottom 200ms, transform 200ms 100ms;
}

.check-icon:checked + .icon-menu {
  --pos-y-bar-one: calc(var(--gap) + var(--height-bar));
  --pos-y-bar-three: calc(var(--gap) + var(--height-bar));
  --scale-bar: 0;
  --rotate-bar-one: 45deg;
  --rotate-bar-three: -45deg;
}

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
        /* text-shadow: 2px 2px 2px #000000; */
        text-align: center;
        font-family: 'mont';
        padding-top: 30%; /* Adjusted padding-top value */
        background: linear-gradient(to right, #ffffff, #dbbe4b,  #ffffff, #dbbe4b );
        background-size: 200% 100%;
        animation: gradientMove 2s linear infinite;
        -webkit-background-clip: text;
        background-clip: text;
        -webkit-text-fill-color: transparent; 
    }
    @keyframes gradientMove {
        0% {
            background-position: 0% 50%; 
        }
        50% {
            background-position: 100% 50%; 
        }
        100% {
            background-position: 0% 50%; 
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
        margin-top: 10px; 
    }
    .button-container {
        display: flex;
        justify-content: center;
        margin-top: 20px; 
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
