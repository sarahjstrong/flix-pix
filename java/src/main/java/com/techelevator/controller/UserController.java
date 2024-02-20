package com.techelevator.controller;


import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin

public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
    public User getUserById (@PathVariable int userId) {
        return userDao.getUserById(userId);
    }

    @RequestMapping(path = "/update-user/{userId}", method = RequestMethod.PUT)
    public User updateUser (@RequestBody User user, @PathVariable int userId) {
        try {
            User existingUser = userDao.getUserById(userId);
            existingUser.setAboutMe(user.getAboutMe());
            existingUser.setLocation(user.getLocation());
            User updatedUser = userDao.updateUser(existingUser);
            return updatedUser;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }


}
