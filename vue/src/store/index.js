import { createStore as _createStore } from 'vuex';
import axios from 'axios';
import MovieService from '../services/MovieService';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      genres: [],
      directors: [],
      favorites: [],
      friends: [],
      movies: [],
      apiMovies: [],
      filterBy : '',
      searchTerm: '',
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
      UPDATE_SEARCH_TERM(state, newSearch) {
        state.searchTerm = newSearch;
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
      ADD_MOVIES_FROM_DATABASE(state) {
        MovieService.getMovies( response => {
          state.movies = response.data;
        })
      },
      ADD_MOVIES_FROM_API(state) {
        //
      },
      UPLOAD_USER_DATA(state) {
        // Call to receive all user data and reassign user (this will include bio, location, etc)
        // Call receive all fav genres from table
        // Call to receive all fav directors from table
        // Call to receive all favorite movie from table
        // Call to receive all friends from the table
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