<template>
    <div class="friend-info-container">
        <h1 style="font-family: 'mont';">Friends</h1>
        <div class="friend-list">
            <div v-for="(friend, index) in friendsList" v-bind:key="index">
                <div class="friend-card">
                    <friend-card v-bind:userId="friend.userId2"></friend-card>
                </div>
                
            </div>
            
        </div>

        <div>
            <button v-show="activeSearch === false" class="add-friend-btn" v-on:click="activeSearch = true">Add Friend</button>
            <div class="response-messages">
                <p v-show="showSuccess">User added!</p>
                <p v-show="showNoUsersExist">Username doesn't exist</p>
            </div>
            <div class="active-search" v-show="activeSearch === true">
                <input class="search-bar" type="text" name="friend-search" id="friend-search" placeholder="Search username" v-model="searchName">
                <button class="search-btn" v-on:click="addFriend">Add</button>
                <button class="search-btn" v-on:click="cancelSearch">Cancel</button>
            </div>
        </div>
        
            
    </div>
</template>

<script>
    import FriendCard from '../components/FriendCard.vue'
    import UserService from '../services/UserService'
    import FriendService from '../services/FriendService'

    export default{
        data() {
            return {
                friendsList: [],
                allUsers: [],
                usernames: [],
                activeSearch: false,
                searchName: '',
                showNoUsersExist: false,
                showSuccess: false
            }
        },
        components: {
            FriendCard
        },
        methods: {
            cancelSearch() {
                this.searchName = '';
                this.activeSearch = false;
                this.showNoUsersExist = false;
            },
            addFriend() {
                if(this.usernames.includes(this.searchName.toLowerCase())) {
                    this.allUsers.forEach(user => {
                        if(user.username === this.searchName.toLowerCase()) {
                            FriendService.addFriend( { userId1: this.$store.state.user.id, userId2: user.id} ).then(response => {
                                if(response.status === 200) {
                                    this.friendsList.push({ userId1: this.$store.state.user.id, userId2: user.id });
                                    this.showSuccess = true;
                                }
                            })
                        }
                    });
                } else {
                    this.showNoUsersExist = true;
                }
            }
        },
        created() {
            UserService.getAllUsers().then(response => {
                if(response.status === 200) {
                    if(response.data.length > 0) {
                        this.allUsers = response.data;
                        this.usernames = response.data.map(user => user.username);
                    }
                }
            });

            FriendService.getAllFriends().then(response => {
                if(response.status === 200) {
                    if(response.data.length > 0) {
                        this.friendsList = response.data.filter(friend => friend.user1Id = this.$store.state.user.id);
                    }
                }
            })
        }
    }
</script>

<style scoped>

.friend-info-container{
        display: flex;
        flex-direction: column;
        justify-content: center;
    }
    .active-search{
        display: flex;
        justify-content: center;
        margin-top: 20px;
    }

    .friend-list{
        display: flex;
        justify-content: center;
        margin-bottom: 30px;
        margin-top: 30px;
        flex-wrap: wrap;
        justify-content: space-around;
    }

    .friend-card{

    }

    .add-friend-btn{

        font-size: 1.2em;
        font-family: 'mont';
        padding: 5px 10px;
        margin-top: 20px;
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
        width: 20%;
    }

    input {
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



</style>