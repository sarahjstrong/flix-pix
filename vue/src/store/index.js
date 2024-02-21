import { createStore as _createStore } from 'vuex';
import axios from 'axios';
import MovieService from '../services/MovieService';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      apiMovie: '',
      filterBy : '',
      adminSearchTerm: '',
      browseSearchTerm: '',
      searchName: '',
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      },
      UPDATE_BROWSE_SEARCH_TERM(state, newSearch) {
        state.browseSearchTerm = newSearch;
      },
      UPDATE_ADMIN_SEARCH_TERM(state, newSearch) {
        state.adminSearchTerm = newSearch;
      },
      SET_FILTER_BY(state, newFilter) {
        state.filterBy = newFilter;
      },
      ADD_MOVIE_TO_FAV(state, movieId) {
        // Call to favorite service and add movie to favorites
      },
      DELETE_MOVIE_FROM_FAV(state, movieId) {
        // Call to favorite service and delete movie from favorites
      },
      SET_MOVIE_FROM_API(state, movie) {
        state.apiMovie = movie;
      },
      UPDATE_USER_DATA(state, updatedUser) {
        console.log("aaaa");
        console.log(updatedUser);
        state.user = updatedUser;
        console.log(state.user);
      },
      ADD_DIRECTOR(state, directorsToAdd) {
        // Call user-director service to save the directors into database
      },

    },
  });
  return store;
}


// {
//   title: "Example Movie",
//   director: "Director Name",
//   releaseYear: 2017,
//   rating: 4,
//   id: 1,
//   img: "//www.html.am/images/image-codes/milford_sound_t.jpg"
// },
// {
//   title: "Example Movie",
//   director: "Director Name",
//   releaseYear: 2017,
//   rating: 4,
//   id: 2,
//   img: "//www.html.am/images/image-codes/milford_sound_t.jpg"
// },
// {
//   title: "Example Movie",
//   director: "Director Name",
//   releaseYear: 2017,
//   rating: 4,
//   id: 3,
//   img: "//www.html.am/images/image-codes/milford_sound_t.jpg"
// },
// {
//   title: "Example Movie",
//   director: "Director Name",
//   releaseYear: 2017,
//   rating: 4,
//   id: 4,
//   img: "//www.html.am/images/image-codes/milford_sound_t.jpg"
// },
// {
//   title: "Example Movie",
//   director: "Director Name",
//   releaseYear: 2017,
//   rating: 4,
//   id: 5,
//   img: "//www.html.am/images/image-codes/milford_sound_t.jpg"
// },
// {
//   title: "Example Movie",
//   director: "Director Name",
//   releaseYear: 2017,
//   rating: 4,
//   id: 6,
//   img: "//www.html.am/images/image-codes/milford_sound_t.jpg"
// }