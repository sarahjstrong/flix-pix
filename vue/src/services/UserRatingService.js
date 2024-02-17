import axios from "axios";

export default {

    getMovieRatingsByUsername(username) {
        return axios.get('/user-ratings/' + username);
    },

}