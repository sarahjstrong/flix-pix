<template>
    <h2>Add Movie To Site: </h2>
    <admin-search-bar></admin-search-bar>
    <transition name="fade" v-show="this.$store.state.apiMovie.title != '' && this.$store.state.apiMovie != ''">
        <admin-movie-detail v-bind:movie="this.$store.state.apiMovie" class="movie-card"></admin-movie-detail>
    </transition>

    <div v-show="this.$store.state.apiMovie.title === ''">
        <h4>No movies match your search</h4>
    </div>
</template>

<script>
    import AdminSearchBar from '../components/AdminSearchBar.vue'
    import AdminMovieDetail from '../components/AdminMovieDetail.vue'

    export default {
        components: {
            AdminSearchBar,
            AdminMovieDetail
        },
        methods: {

        }
    }
</script>

<style scoped>
    .fade-enter-from{
        opacity: 0;
    }

    .fade-enter-to{
        opacity: 1;
    }

    .fade-enter-active{
        transition: all .5s ease;
    }

    .fade-leave-from{
        opacity: 1;
}

    .fade-leave-to{
        opacity: 0;
    }

    .fade-leave-active{
        transition: all .5s ease;
    }

    h2{
        color: #dbbe4b;
        text-align: center;
    }

    h4{
        color: #dbbe4b;
        text-align: center;
    }

    .movie-card{
        display: flex;
        margin: 100px;
    }

</style>