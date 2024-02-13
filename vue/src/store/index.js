import { createStore as _createStore } from 'vuex';
import axios from 'axios';
import MovieService from '../services/MovieService';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      genres: [],
      favorites: [],
      movies: [
        {
          title: "Example Movie",
          director: "Director Name",
          releaseYear: 2017,
          rating: 4,
          id: 1,
          img: "//www.html.am/images/image-codes/milford_sound_t.jpg"
        },
        {
          title: "Example Movie",
          director: "Director Name",
          releaseYear: 2017,
          rating: 4,
          id: 2,
          img: "//www.html.am/images/image-codes/milford_sound_t.jpg"
        },
        {
          title: "Example Movie",
          director: "Director Name",
          releaseYear: 2017,
          rating: 4,
          id: 3,
          img: "//www.html.am/images/image-codes/milford_sound_t.jpg"
        },
        {
          title: "Example Movie",
          director: "Director Name",
          releaseYear: 2017,
          rating: 4,
          id: 4,
          img: "//www.html.am/images/image-codes/milford_sound_t.jpg"
        },
        {
          title: "Example Movie",
          director: "Director Name",
          releaseYear: 2017,
          rating: 4,
          id: 5,
          img: "//www.html.am/images/image-codes/milford_sound_t.jpg"
        },
        {
          title: "Example Movie",
          director: "Director Name",
          releaseYear: 2017,
          rating: 4,
          id: 6,
          img: "//www.html.am/images/image-codes/milford_sound_t.jpg"
        }
      ],
      filterBy : '',
      searchTerm: ''
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
        state.favorites.add({
          movieId: movieId,
          user: state.user
        })
      },
      ADD_MOVIES(state) {
        MovieService.getMovies( response => {
          state.movies = response.data;
        })
      }
    },
  });
  return store;
}
