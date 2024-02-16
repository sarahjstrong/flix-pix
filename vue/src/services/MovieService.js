import axios from "axios";

const movieAPI = axios.create();

export default {

    // searchOMDBAPIbyID(imdbId) {
    //     return movieAPI.get(`http://www.omdbapi.com/?!=${imdbId}&type=movie&apikey=bac84920`);
    // }

    // searchOMDBAPIbyTitle(title, page) {
    //     return movieAPI.get(`http://www.omdbapi.com/?s=${title}&type=movie&apikey=bac84920`);
    // }



    getMovies() {
        return axios.get('/all-movies');
    },

    getMoviesByGenre(genre) {
        return axios.get('/genres')
    }
}