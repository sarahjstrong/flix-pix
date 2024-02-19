import axios from "axios";

export default {

    getMovieRatingsByUsername(username) {
        return axios.get('/user-ratings/' + username);
    },

    deleteReviewByReviewId(ratingId) {
        return axios.delete('/delete-user-rating/' + ratingId);
    },

    updateReview(updatedRating) {
        return axios.put('/update-user-rating', updatedRating);
    },

    addReview(newReview) {
        return axios.post('/add-user-rating', newReview);
    }

}