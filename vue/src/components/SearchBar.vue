<template>
    <div>
        <select class="select-filter" name="filter" v-model="filterBy" v-on:click="setFilter">
            <option disabled value="" class="option">Filter</option>
            <option value="title" class="option">Title</option>
            <option value="director" class="option">Director</option>
        </select>
    </div>
    <input class="search-bar" type="text" placeholder="Search for Movies" v-model="searchTerm" v-on:keyup="setSearchTerm">
</template>

<script>

export default {
    data() {
        return {
            filterBy: '',
            searchTerm: ''
        }
    },
    methods: {
        setFilter() {
            this.$store.commit('SET_FILTER_BY', this.filterBy);
        },
        setSearchTerm() {
            this.$store.commit('UPDATE_SEARCH_TERM', this.searchTerm);
        }
    }
}

</script>

<style scoped>

</style>