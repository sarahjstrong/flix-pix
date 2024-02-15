<template>
    <h2>Add Movie To Site: </h2>
    <search-bar></search-bar>
    <admin-browse-list v-bind:movies="filteredMovies" v-show="activeSearch"></admin-browse-list>
</template>

<script>
    import SearchBar from '../components/SearchBar.vue'
    import AdminBrowseList from '../components/AdminBrowseList.vue'

    export default {
        components: {
            SearchBar,
            AdminBrowseList
        },
        computed: {
            filteredMovies() {
                const allMovies = this.$store.state.apiMovies;
                const matchText = this.$store.state.searchTerm.toLowerCase();
                return allMovies.filter( curMovie => {
                    curMovie.title.toLowerCase().contains(matchText);
                })
            },
            activeSearch() {
                if(this.$store.state.searchTerm != '') {
                    return true;
                } else {
                    return false;
                }
            }
        },
        methods: {
            addApiMovies() {
                // Call store method to add movies from api
            }
        },
        created() {
            this.addApiMovies;
        }
    }
</script>

<style scoped>
    h2{
        color: #dbbe4b;
        text-align: center;
    }

</style>