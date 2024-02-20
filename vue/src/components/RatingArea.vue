<template>
    <!-- {{ this.$store.state.user }}
    {{ isReviewed }}
    {{ this.$store.state.user.username }} -->
        <!-- {{ newReview }} -->
    <div class="user-rating" v-show="isReviewed === true">
        <div class="view-rating" v-show="showEditForm === false">
            <h1 style="font-family: 'mont';">you rated this movie:</h1>

            <h2 class="star-rating icon">★ </h2>
            <h2 class="star-rating number">{{ thisReview.rating }}</h2>
            
            <p>{{ thisReview.review }}</p>
            <button v-on:click="showEditForm = true; reviewInEdit = thisReview">Edit</button>
            <button class="delete-review-btn" v-on:click="deleteReview">Delete</button>
        </div>

        <div class="edit-rating" v-show="showEditForm === true"> 
            <h1 style="font-family: 'mont';">edit your rating:</h1>
            <div>
                <h2 class="star-rating icon">★ </h2>
                <h2 class="star-rating number">{{ reviewInEdit.rating }}</h2>
            </div>

            <input type="range" id="star-rating" min="0" max="5" step=".5" v-model="reviewInEdit.rating"/>
            <textarea type="text" class="new-review" v-model="reviewInEdit.review"></textarea>
            <button class="save-edit" v-on:click="updateRating">Save</button>
            <button class="edit-cancel">Cancel</button>
            

        </div>
        
    </div>


    <div class="leave-review" v-show="isReviewed === false">
        <h1 style="font-family: 'mont';">Leave a review!</h1>
        <div>
            <h2 class="star-rating icon">★ </h2>
            <h2 class="star-rating number">{{ newReview.rating }}</h2>
        </div>
        <input type="range" min="0" max="5" step=".5" v-model="newReview.rating"/>
        <textarea type="text" placeholder="This Movie.." class="new-review" v-model="newReview.review"></textarea>
        <button class="new-review-save" v-on:click="addReview">Save</button>
        <button class="new-review-cancel" v-on:click="clearNewReview">Clear</button>
    </div>
</template>

<script>

    import LeaveReviewForm from '../components/LeaveReviewForm.vue'
    import UserRatingService from '../services/UserRatingService'

    export default{
        props: ['movie'],
        data() {
            return {
                newReview: {
                    userId: '',
                    movieId: '',
                    rating: 0,
                    review: ''
                },
                reviewInEdit: '',
                isReviewed: false,
                thisReview: '',
                showEditForm: false,
            }
        },
        components: {
            LeaveReviewForm,
        },
        methods: {
            deleteReview(){
                UserRatingService.deleteReviewByReviewId(this.thisReview.ratingId).then( response => {
                    if(response.status === 204) {
                        this.thisReview = '';
                        this.reviewInEdit = '';
                        this.newReview.rating = 0;
                        this.newReview.review = '';
                        this.isReviewed = false;
                    }
                })
            },
            updateRating() {
                UserRatingService.updateReview(this.reviewInEdit).then(response => {
                    if(response.status === 200) {
                        this.thisReview = this.reviewInEdit;
                        this.showEditForm = false;
                    }
                })
            },
            addReview() {
                this.newReview.userId = this.$store.state.user.id;
                this.newReview.movieId = this.movie.movieId;
                UserRatingService.addReview(this.newReview).then(response => {
                    if(response.status === 200) {
                        this.isReviewed = true;
                        this.thisReview = response.data;
                        this.reviewInEdit = response.data;

                    }
            })
            },
            clearNewReview() {
                this.newReview.rating = 0;
                this.newReview.review = '';
            }
        },
        created() {
            UserRatingService.getMovieRatingsByUsername(this.$store.state.user.username).then(response => {
                if(response.status === 200) {
                    const userRatings = response.data;
                    let match = userRatings.find(curRating => curRating.movieId === this.movie.movieId);
                    if(match != undefined) {
                        this.isReviewed = true;
                        this.thisReview = match;
                        this.reviewInEdit = match;
                    } 
                    
                }
            })
        }
    }

</script>

<style scoped>
    .default-stars{
        font-size: 4rem;
    }

    .star-rating{
        display: inline-block;
        font-size: 2rem;
        margin-bottom: 0px;
    }

    .icon{
        color: #dbbe4b;
    }

    .new-review{
        width: 90%;
        height: 150px;
        margin-bottom: 15px
    }

    .leave-review{
        display: flex;
        flex-direction: column;
        margin-bottom: 40px;
    }
    .edit-rating{
        display: flex;
        flex-direction: column;
        margin-bottom: 40px;
    }

    button{
        font-family: 'mont';
        background-color: #893222;
        color: #dbbe4b;
        height: 36px;
        /* border-radius: 20px; */
        outline: none;
        cursor: pointer;
    
        overflow: hidden;
    }
    
    .new-review{
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        box-sizing: border-box;
        border: 3px solid #893222;
        -webkit-transition: 0.5s;
        transition: 0.5s;
        outline: none;

    }
    .new-review:focus{
        border: 3px solid #dbbe4b;
    }

    ::placeholder{
        color: rgb(177, 177, 228);
    }   
    </style>