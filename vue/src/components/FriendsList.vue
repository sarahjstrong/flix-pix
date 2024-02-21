<template>
    <h2 style="text-decoration: underline; font-size: 50px; font-family:'mont';">Friends</h2>
    <div class="friends-list" v-for="(friend, index) of friends" v-bind:key="index">
        <friend-card v-bind:friend="friend"></friend-card>
    </div>

    <div class="friend-search">
        <friend-search-bar></friend-search-bar>
    </div>

</template>

<script>

import FriendCard from './FriendCard.vue';
import FriendSearchBar from './FriendSearchBar.vue';

export default{
    data() {
        return {
            friends: this.$store.state.friends,
        }
    },
    components: {
        FriendCard,
        FriendSearchBar,
    },
    methods: {

    }

}

</script>