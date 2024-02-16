import axios from "axios";

export default {

    getMovieFromAPIByTitle(title) {
        return axios.get('/api/' + title);
    },

    getMovies() {
        return axios.get('/all-movies');
    },

    getMoviesByGenre(genre) {
        return axios.get('/genres')
    }
}