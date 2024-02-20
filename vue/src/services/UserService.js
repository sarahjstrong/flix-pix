import axios from 'axios';

export default {

    updateUser(editedUser) {
        return axios.put('/update-user/' + editedUser.id, editedUser);
    },

    getAllUsers() {
        return axios.get('/users');
    },

    getUserById(userId) {
        return axios.get('/user/' + userId);
    }

}