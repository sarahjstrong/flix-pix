<template>
    <div>

            <img src="../assets/images/useravatar.jpg"  alt="User Avatar" style="width: 100px; height: 100px; border-radius: 50%; margin-bottom: 10px;">
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
</style>

