package com.techelevator.dao;

import com.techelevator.model.Favorite;

import java.util.List;

public interface FavoriteDao {

    public List<Favorite> getAllFavorites();

    public Favorite getFavoriteById(int favoriteId);

    public List<Favorite> getFavoritesByUserId(int userId);

    public Favorite addFavorite(Favorite favoriteToAdd);

    public void deleteFavorite(int favoriteId);


}
