<template>
    <div class="user-rating" v-show="userRated === true && showEditForm === false">
        <h3>You rated this movie: </h3>
        <!-- Add star image representation of rating -->
        <p>{{ rating.rating }}</p>
        <button class="edit-review-btn" v-on:click="toggleEditForm">Edit</button>
        <div class="edit-form" v-show="showEditForm === true">
            <leave-review-form v-bind:rating="rating"></leave-review-form>
        </div>
    </div>

    <div class="leave-review" v-show="userRated === false">
        <button class="review-btn" v-on:click="toggleForm">Leave Review</button>
        <div class="form" v-show="showForm">
            <leave-review-form v-bind:rating="rating"></leave-review-form>
        </div>
    </div>
</template>

<script>

    import LeaveReviewForm from '../components/LeaveReviewForm.vue'

    export default{
        props: ['movie'],
        data() {
            return {
                userRated: '',
                rating: [],
                showForm: false,
                showEditForm: false,
            }
        },
        components: {
            LeaveReviewForm,
        },
        methods: {
            getRating() {
                // Make call to rating service to get object for user rating for current movie
                if(!response.data === null) {
                    this.rating = response.data;
                    this.userRated = true;
                } else {
                    this.userRated = false;
                }
                return null;
            }, 
            toggleForm() {
                if(this.showForm) {
                    this.showForm = false;
                } else {
                    this.showForm = true;
                }
            },
            toggleEditForm() {
                if(this.showEditForm) {
                    this.showEditForm = false;
                } else {
                    this.showEditForm = true;
                }
            }
        },
        created() {

        }
    }

</script>