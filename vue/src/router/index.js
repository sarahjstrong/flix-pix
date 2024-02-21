import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

// Import components
import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import BrowseView from '../views/BrowseView.vue';
import ProfileView from '../views/ProfileView.vue';
import FavoritesView from '../views/FavoritesView.vue';
import MovieView from '../views/MovieView.vue';
import RecommendedView from '../views/RecommendedView.vue'
import AdminView from '../views/AdminView.vue'
import UserView from '../views/UserView.vue'

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/logout",
    name: "logout",
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/browse",
    name: "browse",
    component: BrowseView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/profile",
    name: "profile",
    component: ProfileView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/favorites",
    name: "favorites",
    component: FavoritesView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/browse/:movieId",
    name: "movie",
    component: MovieView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/user/:userId",
    name: "user",
    component: UserView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/recommended",
    name: "recommended",
    component: RecommendedView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/admin",
    name: "admin",
    component: AdminView,
    meta: {
      requiresAuth: true
    }
  }
];

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});

router.beforeEach((to) => {

  // Get the Vuex store
  const store = useStore();

  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return {name: "login"};
  }
  // Otherwise, do nothing and they'll go to their next destination
});

export default router;
