package com.techelevator.dao;

import com.techelevator.model.UserDirector;

import java.util.List;

public interface UserDirectorDao {

    public List<UserDirector> getAllUserDirectors();

    public List<UserDirector> getDirectorsForUser(int userId);

    public UserDirector addUserDirector(UserDirector userDirectorToAdd);

    public void deleteUserDirector(int userDirectorId);
}

