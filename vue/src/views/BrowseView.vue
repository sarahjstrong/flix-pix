<template>
    <div class="search-bar">
        <search-bar></search-bar>
        <!--TODO : Debug remove-->
        <!-- <div>HI{{ filteredMovies }}</div> -->
    </div>
    <div class="movies-list">
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
        movies() {
                return this.$store.state.movies;
            },
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
        }
    }
    
}

</script>

<style scoped>

</style>