<template>
    <div class="search-bar">
        <h2>Find Your Next Favorite Film...</h2>
        <search-bar></search-bar>
        <!--TODO : Debug remove-->
        <!-- {{ filteredMovies }} -->
    </div>
    <div class="movies-list">
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
            movies: [],
        }
    },
    computed: {
        filteredMovies() {
            const searchTerm = this.$store.state.browseSearchTerm.toLowerCase();
            const filterBy = this.$store.state.filterBy;
            if(filterBy === 'director') {
                let filtered = this.movies.filter( movie => {
                    return movie.director.toLowerCase().includes(searchTerm)
                });
                return filtered;
            } else if(filterBy === "title") {
                let filtered = this.movies.filter( movie => {
                    return movie.title.toLowerCase().includes(searchTerm)
                });
                return filtered;
            } else {
                let filtered = this.movies.filter( movie => {
                    return (movie.director.toLowerCase().includes(searchTerm) || movie.title.toLowerCase().includes(searchTerm))
                });
                return filtered;
            }
        },
    },
    methods: {
    },
    created() {
        MovieService.getMovies().then( response => {
            this.movies = response.data;
        })
    }
    
}

</script>

<style scoped>
    h2{
        color: #dbbe4b;
        text-align: center;
    }
</style>