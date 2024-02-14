<template>
  <div id="register" class="text-left"> <!-- Align everything to the left -->
    <form v-on:submit.prevent="register">
      <h1 style="font-family: 'mont'; text-decoration: underline;">Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>

      <div class="form-input-group">
        <label for="username">Username:</label><br> 
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>

      <div class="form-input-group">
        <label for="password">Password:</label><br> 
        <input type="password" id="password" v-model="user.password" required />
      </div>

      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password:</label><br> 
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>

      <button class="submit-btn" type="submit">Create Account</button>
      <p class="link"><router-link v-bind:to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    </form>
    <div class="overlay-card">
      <!-- <img src="@/assets/images/horizontallogo.png" class="logo" alt="Logo">  -->
      <!-- Content of the overlaying card goes here -->
      <p class="quote">Unlock A World A Movie Magic</p>
    </div>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
#register {
  position: relative; 
  background-color: #dbdbdb;
  border-radius: 7px;
  max-width: 800px; 
  max-height: 800px;
  margin: auto; 
  padding: 40px 10px 60px 10px; 
  box-sizing: border-box;
  box-shadow: 20px 20px 20px rgba(0, 0, 0, 0.1);
  margin-top: 50px; 
}

.overlay-card {
  position: absolute;
  top: 50%; 
  right: 0; 
  transform: translateY(-50%); 
  width: 50%; 
  height: 50%; 
  border: 2px solid #ccc;
  border-radius: 5px;
  background: url('@/assets/images/popcorn.jpg') no-repeat center center; 
  background-size: cover; 
  padding: 20px 0px 210px 8px;
}

/* .logo {
  position: absolute;
  top: 20px; 
  left: 20px; 
  width: 150px; 
} */

.form-input-group {
  margin-bottom: 1rem;
}

.submit-btn {
  font-size: 1.1em;
  font-family: 'mont';
  padding: 10px 20px;
  margin: 10px;
  background-color: #893222;
  color: #dbbe4b;
  border: none;
  cursor: pointer;
  border-radius: 50px;
  outline: none;
  position: relative;
  box-shadow: 20px 20px 20px rgba(0, 0, 0, 0.1);
  overflow: hidden;
  transition: transform 0.3s;
}

.submit-btn:hover {
  background-color: #6d271b;
  transform: scale(1.2);
}

/* .link:hover {  
  color: #893222;
  text-decoration: underline;
  transition: transform 0.3s;
  transform: scale(1.1);
} */

.quote{
  font-size: 20px;
  font-family: 'mont';
  color: #000000;
  text-shadow: 4px 4px 4px #000000;
  align-items: center;
  justify-content: center;
  margin-top: 10px;
  margin-left: 35px;

}

label {
  margin-right: 0.5rem;
}
</style>
