package com.techelevator.dao;

import com.techelevator.model.Friends;

import java.util.List;

public interface FriendsDao {

    public List<Friends> getAllFriends();

    public List<Integer> getFriendsForUser(int userId);

    public Friends addFriend(Friends friendsToAdd);

    public void  deleteFriend(int userId1, int userId2);
}
