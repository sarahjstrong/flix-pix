<template>
    <div class="container">
        <button class="friend-btn" v-show="showFriendSearch === false" v-on:click="showFriendSearch = true">Add New Friend</button>

        <div class="search-section" v-show="showFriendSearch">
            <input class="search-bar" type="text" placeholder="Add Friend" v-model="searchName" v-on:keyup="updateSearchName">
            <button class="search-btn" v-on:click="addFriend">Add</button>
            <button class= "search-btn" v-on:click="showFriendSearch = false">Cancel</button>   
        </div>

        <p v-show="!responseMessage === ''">{{ responseMessage }}</p>
    </div>
    
</template>

<script>

    export default{
        data() {
            return {
                searchName: '',
                showFriendSearch: false,
                responseMessage: '',
            }
        },
        methods: {
            updateSearchName() {
                this.$store.commit('UPDATE_SEARCH_NAME', this.searchName);
            },
            addFriend() {
            const friendUsername = this.$store.state.searchName;
            // call user service to check if user exists
            // if user exists && !this.friends.contain(friendUsername)
                // Call friend service to add friend connection between both users
                // this.responseMessage = 'Added!'
                // this.showFriendSearch = false
                // this.searchName = ''
            // else
                // this.response.message = 'Username does not exist'
                // 

        }
        }
    }

</script>

<style scoped>

    .friend-btn {
        font-size: 1.2em;
        font-family: 'mont';
        padding: 5px 10px;
        background-color: #893222;
        color: #dbbe4b;
        border: none;
        cursor: pointer;
        border-radius: 50px;
        outline: none;
        cursor: pointer;
        position: relative;
        /* box-shadow: 20px 20px 20px rgba(0, 0, 0, 0.1); */
        overflow: hidden;
        transition: transform 0.3s;
    }

    .search-bar{
        width: 200px;
        height: 30px;
        font-size: 16px;
        margin-left: 10px;
        background-color: #ffffff
    }

    .search-btn{
        font-family: 'mont';
        background-color: #893222;
        color: #dbbe4b;
        height: 36px;
        /* border-radius: 20px; */
        outline: none;
        cursor: pointer;
    
        overflow: hidden;
    }

    .search-section{
        display: flex;
        justify-content: center;
        align-content: center;
    }

</style>