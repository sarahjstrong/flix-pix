<template>
  <div id="login">
    <form v-on:submit.prevent="login">
      <h1  style="font-family: 'mont'; text-decoration: underline; ">Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
     <h4><div class="form-input-group">
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div></h4>
      <h4><div class="form-input-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="user.password" required />
      </div></h4>
      <button class="sign-btn" type="submit">Sign in</button>
      <p class="link">
      <router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>

@font-face {
  font-family: 'mont';
  src: url('../assets/fonts/MontereyFLF.ttf');
}
@font-face {
  font-family: 'roboto';
  src: url('../assets/fonts/Roboto-Regular.ttf');
}


#login{
  border: 5px solid #dbdbdb; 
  border-radius: 7px;
  background-color: rgb(255, 252, 244);
  max-width: 400px; 
  max-height: 700px; 
  margin: auto; 
  text-align: center;
  margin-top: 10%;
  padding: 20px; 
  box-sizing: border-box;
  box-shadow: 20px 20px 20px rgba(0, 0, 0, 0.1);

}

.form-input-group {
  
  margin-bottom: 1rem;
  font-size: 15px;

}

.sign-btn {
  font-size: 1.1em;
        font-family: 'mont';
        padding: 10px 15px;
        margin: 10px;
        background-color: #893222;
        color: #dbbe4b;
        border: none;
        cursor: pointer;
        outline: none;
        cursor: pointer;
        position: relative;
        box-shadow: 20px 20px 20px rgba(0, 0, 0, 0.1);
        overflow: hidden;
        transition: transform 0.3s;
        border-radius: 50px;

}

.sign-btn:hover {
        background-color: #6d271b;
        transform: scale(1.2);
}

.link:hover{  
  color: #893222;
  text-decoration: underline;
  transition: transform 0.3s;
  transform: scale(1.1);


}



label {
  margin-right: 0.5rem;
}
</style>