<template>
    <div class="card">
        <router-link :to="{ name: 'user', params: {userId: userId}}">
            <img src="../assets/images/useravatar.jpg"  alt="User Avatar" style="width: 100px; height: 100px; border-radius: 50%; margin-bottom: 10px; border: 2px solid #893222">
        </router-link>
        
        <p>{{ user.username }}</p>
    </div>
</template>

<script>
import UserService from '../services/UserService';
export default{
    props: ['userId'],
    data() {
        return {
            user: {}
        }
    },
    created(){
        UserService.getUserById(this.userId).then(response => {
            if(response.status === 200) {
                this.user = response.data;
            }
        })
    }

}

</script>

<style scoped>
    img {
        cursor: pointer;
    }

    .card{
       display: flex;
       flex-direction: column;
    }
</style>

