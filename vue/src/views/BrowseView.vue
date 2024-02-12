<template>
    <div class="search-bar">
        <search-bar></search-bar>
    </div>
    <div class="movies-list">
        <browse-list></browse-list>
    </div>
</template>

<script>
import SearchBar from '../components/SearchBar.vue'
import BrowseList from '../components/BrowseList.vue';

export default {
    components: {
        SearchBar,
        BrowseList
    }
}

</script>

<style scoped>

</style>