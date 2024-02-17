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
        return axios.post('/movies');
    }
}