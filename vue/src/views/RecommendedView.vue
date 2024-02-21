<template>
    <div class="recommended-header">
        <h2>Recommendations based on your saved genres and directors!</h2>
    </div>
    <div class="movies-list">
        <browse-list v-bind:movies="filteredMovies"></browse-list>
    </div>
</template>

<script>
    import BrowseList from '../components/BrowseList.vue';
    import MovieService from '../services/MovieService';
    import GenreService from '../services/GenreService';
    import DirectorService from '../services/DirectorService';

    export default {
        data() {
            return {
                allMovies: [],
                targetGenres: [],
                targetDirectors: []
            }
        },
        components: {
            BrowseList
        },
        computed: {
            filteredMovies() {
                const filtered = [];
                this.allMovies.forEach(movie => {
                    const director = movie.director.toLowerCase();
                    const genres = movie.genre.toLowerCase();
                    let genreMatch = false;
                    let directorMatch = false;

                    this.targetGenres.forEach(gen => {
                        if(genres.includes(gen.toLowerCase())) {
                            genreMatch = true;
                        }
                    });

                    this.targetDirectors.forEach(dir => {
                        if(director.includes(dir.toLowerCase())) {
                            directorMatch = true;
                        }
                    });

                    if(genreMatch === true || directorMatch === true) {
                        filtered.push(movie);
                    }
                });
                return filtered;
            }
        },

        created() {
            MovieService.getMovies().then( response => {
                if(response.status === 200) {
                    this.allMovies = response.data;
                }
            });

            GenreService.getUserGenres(this.$store.state.user.username).then(response => {
                if(response.status === 200) {
                    if(response.data.length > 0) {
                        this.targetGenres = response.data.map(gen => gen.genre);
                    }
                }
            });

            DirectorService.getAllUserDirectors(this.$store.state.user.id).then(response => {
                if(response.status === 200) {
                    if(response.data.length > 0) {
                        this.targetDirectors = response.data.map(dir => dir.directorName);
                    }
                }
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