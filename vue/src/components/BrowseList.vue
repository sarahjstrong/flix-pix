<template>
    <div class="card" v-for="curMovie in filteredMovies" v-bind:key="curMovie.id"></div>
    <movie-card v-bind:movie="curMovie"></movie-card>
</template>

<script>
    import MovieCard from './MovieCard.vue';

    export default {
        components: {
            MovieCard
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
        },
        created() {
            this.$store.commit('ADD_MOVIES');
        }
    }
</script>

<style scoped>

</style>