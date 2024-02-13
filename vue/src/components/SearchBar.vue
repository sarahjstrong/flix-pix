<template>
    <div class="filter-search">
        <select class="select-filter" name="filter" v-model="filterBy" v-on:click="setFilter">
            <option disabled value="" class="option">Filter</option>
            <option value="title" class="option">Title</option>
            <option value="director" class="option">Director</option>
        </select>
        <input class="search-bar" type="text" placeholder="Search for Movies" v-model="searchTerm" v-on:keyup="setSearchTerm">
    </div>
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
    .filter-search {
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        margin-top: 40px;
    }
    .search-bar {
        width: 400px;
        height: 30px;
        font-size: 16px;
        margin-left: 10px;
    }
    .select-filter {
        height: 36px;
        font-size: 16px;
    }

</style>