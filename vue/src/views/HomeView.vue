<template>
  <home-header></home-header>
  <!--  -->
</template>

<script>
import HomeHeader from '../components/HomeHeader.vue'
export default {
  components: {
    HomeHeader
  },
  created() {
    this.$store.commit('ADD_MOVIES');
 }
};
</script>
