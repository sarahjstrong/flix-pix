package com.techelevator.controller;

import com.techelevator.dao.UserRatingDao;
import com.techelevator.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserRatingController {

    private final UserRatingDao userRatingDao;

    @Autowired
    public UserRatingController(UserRatingDao userRatingDao) {
        this.userRatingDao = userRatingDao;
    }

    @RequestMapping(path = "/all-user-ratings", method = RequestMethod.GET)
    public List<UserRating> getAllUserRatings() {
        return userRatingDao.getAllUserRatings();
    }

    @RequestMapping(path = "/user-ratings/{username}", method = RequestMethod.GET)
    public List<UserRating> getUserRatingsByUsername(@PathVariable String username) {
        return userRatingDao.getUserRatingsByUsername(username);
    }

    @RequestMapping(path = "/add-user-rating", method = RequestMethod.POST)
    public UserRating addUserRating(@RequestBody UserRating userRating) {
        return userRatingDao.addUserRating(userRating);
    }

    @RequestMapping(path = "/update-user-rating", method = RequestMethod.PUT)
    public UserRating updateUserRating(@RequestBody UserRating userRating) {
        return userRatingDao.updateUserRating(userRating);
    }

    @RequestMapping(path = "/delete-user-rating/{ratingId}", method = RequestMethod.DELETE)
    public void deleteUserRating(@PathVariable int ratingId) {
        userRatingDao.deleteUserRating(ratingId);
    }
}