package com.techelevator.controller;

import com.techelevator.dao.UserGenreDao;
import com.techelevator.model.UserGenre;
import com.techelevator.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

public class UserGenreController {
@Autowired
    private final UserGenreDao userGenreDao;

    public UserGenreController(UserGenreDao userGenreDao) {
        this.userGenreDao = userGenreDao;
    }

    @RequestMapping(path = "/user-genres", method = RequestMethod.GET)
    public List<UserGenre> getAllUserGenres() {
        return userGenreDao.getAllUserGenres();
    }

    @RequestMapping(path="/user-genres/{username}" , method = RequestMethod.GET)
    public List<UserGenre> getUserGenresByUsername(@PathVariable String username) {
        return userGenreDao.getUserGenresByUsername(username);
    }

    @RequestMapping(path = "/add-user-genre", method = RequestMethod.POST)
    public UserGenre addUserGenre(@RequestBody UserGenre userGenre) {
        return userGenreDao.addUserGenre(userGenre);
    }


    @RequestMapping(path= "/user-genres/{userGenreId}", method = RequestMethod.DELETE)
    public void deleteUserGenre(@PathVariable int userGenreId) {
        userGenreDao.deleteUserGenre(userGenreId);
    }
}
