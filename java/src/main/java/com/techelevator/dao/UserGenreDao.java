package com.techelevator.dao;

import com.techelevator.model.UserGenre;

import java.util.List;

public interface UserGenreDao {

    List<UserGenre> getAllUserGenres();
    List<UserGenre> getUserGenresByUsername(String username);
    UserGenre addUserGenre(UserGenre userGenreToAdd);
    void deleteUserGenre(int userGenreId);
}
