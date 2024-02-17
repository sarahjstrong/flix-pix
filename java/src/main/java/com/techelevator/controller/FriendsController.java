package com.techelevator.controller;

import com.techelevator.dao.FriendsDao;
import com.techelevator.model.Friends;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

public class FriendsController {

    @Autowired
    private FriendsDao friendsDao;

    @RequestMapping(path= "/friends",method = RequestMethod.GET)
    public List<Friends> getAllFriends() {
        return friendsDao.getAllFriends();
    }

    @RequestMapping(path = "/friends/{userId}", method = RequestMethod.GET)
    public List<Integer> getFriendsForUser(@PathVariable int userId) {
        return friendsDao.getFriendsForUser(userId);
    }

    @RequestMapping(path= "/add-friend", method = RequestMethod.POST)
    public Friends addFriend(@RequestBody Friends friendsToAdd) {
       return friendsDao.addFriend(friendsToAdd);

    }

    @RequestMapping(path = "/delete-friend/{userId1}/{userId2}", method = RequestMethod.DELETE)
    public void deleteFriend(@PathVariable int userId1, @PathVariable int userId2) {
        friendsDao.deleteFriend(userId1, userId2);
    }

}
