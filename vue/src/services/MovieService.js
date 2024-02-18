import axios from "axios";

export default {

    getMovieFromAPIByTitle(title) {
        return axios.get('/api/' + title);
    },

    getMovies() {
        return axios.get('/movies');
    },

    getMoviesByGenre(genre) {
        return axios.get('/genres');
    },

    addNewMovie(movie) {
        return axios.post('/movies', movie);
    },

    deleteMovie(id) {
        return axios.delete('/movies/' + id);
    },

    getMovieById(id) {
        return axios.get('/movies/' + id);
    }
}