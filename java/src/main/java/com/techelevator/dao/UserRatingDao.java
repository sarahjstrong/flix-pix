package com.techelevator.dao;

import com.techelevator.model.UserRating;

import java.util.List;

public interface UserRatingDao {
    public List<UserRating> getAllUserRatings();

   public  List<UserRating> getUserRatingsByUsername(String username);

//   public  UserRating getUserRatingById(int ratingId);

   public UserRating addUserRating(UserRating userRating);

    public UserRating updateUserRating(UserRating userRating);

    public void deleteUserRating(int ratingId);



}
