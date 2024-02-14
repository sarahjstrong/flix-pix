<template>
    <h2 style="text-decoration: underline; font-family:'mont';">Friends</h2>
    <div class="friends-list" v-for="(friend, index) of friends" v-bind:key="index">
        <friend-card v-bind:friend="friend"></friend-card>
    </div>
</template>

<script>

import FriendCard from './FriendCard.vue';

export default{
    components: {
        FriendCard,
    },
    data() {
        return {
            friends: this.$store.state.friends,
        }
    }
}

</script>