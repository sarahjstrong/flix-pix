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
import MovieService from '../services/MovieService';

export default {
    components: {
        SearchBar,
        BrowseList
    },
    data() {
        return {
            movies: this.$store.state.movies,
        }
    },
    computed: {
        filteredMovies() {
            const searchTerm = this.$store.state.browseSearchTerm;
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
                return this.movies.filter( movie => {
                    return movie.director.toLowerCase().includes(matchText) || movie.title.toLowerCase().includes(matchText);
                });
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
            this.$store.commit('ADD_MOVIES_FROM_DATABASE')
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