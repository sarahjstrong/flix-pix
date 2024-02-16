<template>
    <div class="search-bar">
        <h2>Find Your Next Favorite Film...</h2>
        <search-bar></search-bar>
        <!--TODO : Debug remove-->
        <!-- <div>HI{{ filteredMovies }}</div> -->
    </div>
    <div class="movies-list" v-show="activeSearch">
        <browse-list v-bind:movies="filteredMovies"></browse-list>
    </div>
    
    
</template>

<script>
import SearchBar from '../components/SearchBar.vue'
import BrowseList from '../components/BrowseList.vue';

export default {
    components: {
        SearchBar,
        BrowseList
    },
    computed: {
        filteredMovies() {
            const searchTerm = this.$store.state.searchTerm;
            const matchText = searchTerm.toLowerCase();
            const filterBy = this.$store.state.filterBy;
            if(filterBy === 'Director') {
                return this.movies.filter( movie => {
                    return movie.director.toLowerCase().includes(matchText);
                })
            } else if(filterBy === "Title") {
                return this.movies.filter( movie => {
                    return movie.title.toLowerCase().includes(matchText);
                })
            } else {
                return this.movies;
            }
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
        addMoviesFromDatabase() {
            // Call store method to add movies from our database
        }
    },
    created() {
        this.addMoviesFromDatabase();
    }
    
}

</script>

<style scoped>
    h2{
        color: #dbbe4b;
        text-align: center;
    }
</style>