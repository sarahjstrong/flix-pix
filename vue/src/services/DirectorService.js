import axios from 'axios';

export default {

    getAllUserDirectors(userId) {
        return axios.get('/user-director/' + userId);
    },

    addNewDirector(userDirector) {
        return axios.post('/add-user-director', userDirector);
    },

    deleteDirector(userDirectorId) {
        return axios.delete('/user-director/' + userDirectorId);
    }

}