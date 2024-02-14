<template>
    <div class="recommended-header">
        <h2>Here are some recommendations based on your favorite genres!</h2>
    </div>
    <div class="movies-list">
        <browse-list v-bind:movies="filteredMovies"></browse-list>
    </div>
</template>

<script>
    import BrowseList from '../components/BrowseList.vue';
    import MovieService from '../services/MovieService';

    export default {
        components: {
            BrowseList
        },
        computed: {
            movies() {
                return this.$store.state.movies;
            },
            userGenres() {
                return this.$store.state.genres;
            },
            userDirectors() {
                return this.$store.state.directors;
            },
            filteredMovies() {
                let mergedList =[];
                this.userGenres.forEach(curGenre => {
                    const moviesForCurGenre = MovieService.getMoviesByGenre(curGenre);
                    mergedList = mergedList.concat(moviesForCurGenre);
                });

                this.userDirectors.forEach(curDirector => {
                    const moviesForCurDirector = MovieService.getMoviesByDirector(curDirector);
                    mergedList = mergedList.concat(moviesForCurDirector);
                })

                const favoritedMovies = this.$store.state.favorites;
                return mergedList.filter(curMovie => {
                    !favoritedMovies.contains(curMovie);
                });

            }
        }
    }
</script>