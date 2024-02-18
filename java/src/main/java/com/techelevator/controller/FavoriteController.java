package com.techelevator.controller;

import com.techelevator.dao.FavoriteDao;
import com.techelevator.model.Favorite;
import com.techelevator.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

public class FavoriteController {

    @Autowired
    private FavoriteDao favoriteDao;

    public FavoriteController(FavoriteDao favoriteDao) {
        this.favoriteDao = favoriteDao;
    }


    @RequestMapping(path = "/all-favorites", method = RequestMethod.GET)
    public List<Favorite> getFavorites() {
        return favoriteDao.getAllFavorites();
    }

    @RequestMapping(path = "/user-favorite/{userId}/{movieId}", method = RequestMethod.GET)
    public Favorite getFavoriteByUserIdAndMovieId(@PathVariable int userId, int movieId) {
        return favoriteDao.getFavoriteByUserIdAndMovieId(userId, movieId);
    }

    @RequestMapping(path = "/user-favorites/{userId}", method = RequestMethod.GET)
    public List<Favorite> getFavoritesByUserId(@PathVariable int userId) {
        return favoriteDao.getFavoritesByUserId(userId);
}

    @RequestMapping(path = "/add-favorite", method = RequestMethod.POST)
    public Favorite addFavorite(@RequestBody Favorite favoriteToAdd) {
        return favoriteDao.addFavorite(favoriteToAdd);}


    @RequestMapping(path = "/delete-favorite/{favoriteId}", method = RequestMethod.DELETE)
    public void deleteFavorite(@PathVariable int favoriteId) {
        favoriteDao.deleteFavorite(favoriteId);}}

