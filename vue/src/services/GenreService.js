import axios from 'axios';

export default {
    getUserGenres(username) {
        return axios.get('/user-genres/' + username);
    },

    addNewGenre(newGenre) {
        return axios.post('/add-user-genre', newGenre);
    },

    deleteGenre(genreId) {
        return axios.delete('/user-genres/' + genreId);
    }
}