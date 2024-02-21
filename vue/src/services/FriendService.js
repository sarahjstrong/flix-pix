import axios from 'axios';

export default {

    getUserFriends(userId) {
        return axios.get('/friends/' + userId);
    },

    addFriend(connection) {
        return axios.post('/add-friend', connection);
    },

    getAllFriends() {
        return axios.get('/friends');
    }
}