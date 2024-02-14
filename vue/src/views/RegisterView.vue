<template>
  <div id="register" class="text-center">
    <form v-on:submit.prevent="register">
      <h1 style="font-family: 'mont'; text-decoration: underline;">Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>

      <h3><div class="form-input-group">
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div></h3>
     <h3> <div class="form-input-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="user.password" required />
      </div></h3>
     <h4> <div class="form-input-group">
        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div></h4>
      <button class="submit-btn" type="submit">Create Account</button>
      <p class="link"><router-link v-bind:to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    </form>
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
@font-face {
  font-family: 'mont';
  src: url(../assets/fonts/MontereyFLF.ttf);
}

@font-face {
  font-family: 'roboto';
  src: url(../assets/fonts/Roboto-Regular.ttf);
}




#register {
  border: 5px solid #dbdbdb; 
  border-radius: 7px;
  background-color: rgb(255, 252, 244);
  max-width: 400px; 
  max-height: 700px; 
  margin: auto; 
  text-align: center;
  padding: 20px; 
  box-sizing: border-box;
  box-shadow: 20px 20px 20px rgba(0, 0, 0, 0.1);

}
.form-input-group {
  margin-bottom: 1rem;
  font-size: 15px;

}

.submit-btn{
        font-size: 1.1em;
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
        box-shadow: 20px 20px 20px rgba(0, 0, 0, 0.1);
        overflow: hidden;
        transition: transform 0.3s;
}

.submit-btn:hover {
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
