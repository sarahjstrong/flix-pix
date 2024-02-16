<template>
    <h2>Add Movie To Site: </h2>
    <admin-search-bar></admin-search-bar>
    <div v-show="this.$store.state.apiMovie.title != '' && this.$store.state.apiMovie != ''">
        <admin-movie-detail v-bind:movie="this.$store.state.apiMovie"></admin-movie-detail>
    </div>

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
    h2{
        color: #dbbe4b;
        text-align: center;
    }

    h4{
        color: #dbbe4b;
        text-align: center;
    }

</style>