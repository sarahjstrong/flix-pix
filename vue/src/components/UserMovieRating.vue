<template>
    <div class="container">
        <div class="not-rated-view" v-show="userReview === ''">
            <div class="star-rating-section">
                <h3>Rate this movie:</h3>
                <button>-</button>
                <!-- minus button, stars set to empty, and add button-->
                <!-- Button to save userRating to database  -->
                <button>+</button>
            </div>
            <div class="review-rating-section">
                <input type="text" class="review-text-area" v-model="currentReview">
            </div>
            <div class="submit">
                <button class="submit-btn" v-on:click="saveRating">Submit</button>
            </div>


        </div>

        <div class="rated-view" v-show="userReview != ''">
            <!-- Show the users current rating in highlighted stars -->
            <!-- Button to delete (calls delete method to user rating service) -->
            <!-- Edit opens a edit star section with save button -->
        </div>
    </div>
</template>

<script>
    import UserRatingService from '../services/UserRatingService'
    export default{
        props: ['movie'],
        data() {
            return {
                currentRating: 0,
                currentReview: '',
                userReview: '',
            }
        },
        computed: {
            
        },
        methods: {
            decreaseStar() {
                if(this.currentRating > 0) {
                    this.currentRating = (this.currentRating) - 1;
                }
            },
            increaseStar() {
                if(this.currentRating < 5) {
                    this.currentRating = (this.currentRating) + 1;
                }
            },
            saveRating() {
                // Call user rating service to add to user rating for this movie
                // if currentRating is greater than 1 and currentReview != ''
            }
        },
        created() {
            UserRatingService.getMovieRatingsByUsername(this.$store.state.user).then( response => {
                    if(response.status === 200) {
                        const allUserRatings = response.data;
                        const thisMovieRating = allUserRatings.find( curRating => curRating.movieId === this.movie.movieId);
                        if(thisMovieRating != []) {
                            this.userReview = thisMovieRating;
                        }
                    }
                })
        }
    }
</script>

<style scoped>

</style>