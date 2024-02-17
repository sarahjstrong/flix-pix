package com.techelevator.model;

public class UserRating {

    private int ratingId;


    private int userId;


    private int movieId;


    private double rating;

    private String review;


    public UserRating(int ratingId, int userId, int movieId, double rating, String review) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
        this.review=review;
    }
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }


    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
