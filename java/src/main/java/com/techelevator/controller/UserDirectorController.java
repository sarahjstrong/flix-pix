package com.techelevator.controller;

import com.techelevator.dao.UserDirectorDao;
import com.techelevator.model.UserDirector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserDirectorController {

    @Autowired
    private final UserDirectorDao userDirectorDao;

    public UserDirectorController(UserDirectorDao userDirectorDao) {
        this.userDirectorDao = userDirectorDao;
    }


    @RequestMapping(path = "/user-directors", method = RequestMethod.GET)
    public List<UserDirector> getAllUserDirectors() {
        return userDirectorDao.getAllUserDirectors();
    }

    @RequestMapping(path = "/user-director/{userId}", method = RequestMethod.GET)
    public List<String> getDirectorsForUser(@PathVariable int userId) {
        return userDirectorDao.getDirectorsForUser(userId);
    }

    @RequestMapping(path = "/add-user-director", method = RequestMethod.POST)
    public UserDirector addUserDirector(@RequestBody UserDirector userDirector) {
        return userDirectorDao.addUserDirector(userDirector);
    }

    @RequestMapping(path = "/user-director/{userDirectorId}", method = RequestMethod.DELETE)
    public void deleteUserDirector(@PathVariable int userDirectorId) {
        userDirectorDao.deleteUserDirector(userDirectorId);
    }
}

