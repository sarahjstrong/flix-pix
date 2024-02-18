import axios from "axios";

export default {
    getFavsByUserId(userId) {
        return axios.get('/user-favorites/' + userId);
    },

    addFavorite(favorite) {
        return axios.post('/add-favorite', favorite);
    },

    deleteFavorite(favoriteId) {
        return axios.delete('/delete-favorite/' + favoriteId);
    }
}