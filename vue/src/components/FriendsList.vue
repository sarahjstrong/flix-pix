<template>
    <div class="container">
        <div class="search-area">
            <button v-show="activeSearch === false" class="add-friend-btn" v-on:click="activeSearch = true">Add Friend</button>
            <div class="response-messages">
                <p v-show="showSuccess">User added!</p>
                <p v-show="showNoUsersExist">Username doesn't exist</p>
            </div>
            <div class="active-search" v-show="activeSearch === true">
                <input class="search-bar" type="text" name="friend-search" id="friend-search" placeholder="Search username" v-model="searchName">
                <button class="add-btn" v-on:click="addFriend">Add</button>
                <button class="cancel-search" v-on:click="cancelSearch">Cancel</button>
            </div>
        </div>

        <div class="friend-list">
            Hello
            <div v-for="(friend, index) in friendsList" v-bind:key="index">
                <friend-card v-bind:userId="friend.userId2"></friend-card>
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
    .active-search{
        display: flex;
    }



</style>