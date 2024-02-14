package com.techelevator.dao;

import com.techelevator.model.Favorite;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class JdbcFavoriteDao implements FavoriteDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcFavoriteDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Favorite> getAllFavorites() {
        return null;
    }

    @Override
    public Favorite getFavoriteById(int favoriteId) {
        return null;
    }

    @Override
    public List<Favorite> getFavoritesByUserId(int userId) {
        return null;
    }

    @Override
    public Favorite addFavorite(Favorite favoriteToAdd) {
        return null;
    }

    @Override
    public void deleteFavorite(int favoriteId) {

    }
}
