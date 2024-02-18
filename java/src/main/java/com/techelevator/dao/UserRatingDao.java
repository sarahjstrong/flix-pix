package com.techelevator.dao;

import com.techelevator.model.UserRating;

import java.util.List;

public interface UserRatingDao {
    public List<UserRating> getAllUserRatings();

   public  List<UserRating> getUserRatingsByUsername(String username);

   public  UserRating getUserRatingByMovie(int userId, int movieId);

   public UserRating addUserRating(UserRating userRating);

    public UserRating updateUserRating(UserRating userRating);

    public void deleteUserRating(int ratingId);

//   public  UserRating getUserRatingById(int ratingId);

}
