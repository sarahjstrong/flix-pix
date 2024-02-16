<template>
    <div class="container">
        <input class="search-bar" type="text" placeholder="Search for Movies" v-model="searchTitle">
        <button v-on:click="search">Search</button>
        <button v-on:click="clear">Clear</button>
    </div>
</template>

<script>
    import MovieService from '../services/MovieService';
    export default {
        data() {
            return {
                searchTitle: '',
            }
        },
        methods: {
            search() {
                this.$store.commit('UPDATE_ADMIN_SEARCH_TERM', this.searchTitle);
                MovieService.getMovieFromAPIByTitle(this.$store.state.adminSearchTerm).then( response => {
                    if(response.status === 200) {
                        this.$store.commit('SET_MOVIE_FROM_API', response.data);
                    } 
                });
                },
                clear() {
                    this.searchTitle = ''
                    this.$store.commit('UPDATE_ADMIN_SEARCH_TERM', this.searchTitle);
                    this.$store.commit('SET_MOVIE_FROM_API', '');
                }
            }

        }

</script>

<style scoped>

.container{
    display: flex;
    flex-grow: 1;
    justify-content: center;
}

button {
    font-family: 'mont';
        background-color: #dbbe4b;
        font-size: 18px;
        font-weight: 600;
        color: #893222;
        height: 36px;
        /* border-radius: 20px; */
        outline: none;
        cursor: pointer;
    
        overflow: hidden;
}

.search-bar {
    width: 400px;
    height: 30px;
    font-size: 16px;
    margin-left: 10px;
    background-color: #fff6d7
}

</style>