package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Favorite;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcFavoriteDao implements FavoriteDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcFavoriteDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Favorite> getAllFavorites() {
        List<Favorite> favorites = new ArrayList<>();
        try {
            String sql = "SELECT favorite_id, user_id, movie_id FROM favorites";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Favorite favorite = mapRowToFavorite(results);
                favorites.add(favorite);
            }
        } catch (Exception e) {
            throw new DaoException("Error retrieving favorites", e);
        }
        return favorites;
    }

    private Favorite mapRowToFavorite(SqlRowSet rs) {
        int favoriteId = rs.getInt("favorite_id");
        int userId = rs.getInt("user_id");
        int movieId = rs.getInt("movie_id");
        return new Favorite(favoriteId, userId, movieId);

    }


    @Override
    public List<Favorite> getFavoritesByUserId(int userId) {

        List<Favorite> favorites = new ArrayList<>();

        String sql = "SELECT favorite_id, user_id, movie_id FROM favorites WHERE user_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                Favorite favorite = mapRowToFavorite(results);
                favorites.add(favorite);
            }
        } catch (Exception e) {
            throw new DaoException("Error retrieving favorites by user ID", e);
        }
        return favorites;
    }



    @Override
    public Favorite addFavorite(Favorite favoriteToAdd) {
        try {
            String sql = "INSERT INTO favorites (user_id, movie_id) VALUES (?, ?) RETURNING favorite_id";
            int favoriteId = jdbcTemplate.queryForObject(sql, Integer.class, favoriteToAdd.getUserId(), favoriteToAdd.getMovieId());
            favoriteToAdd.setFavoriteId(favoriteId);
            return favoriteToAdd;
        } catch (Exception e) {
            throw new DaoException("Error adding favorite", e);
        }
    }

    @Override
    public void deleteFavorite(int favoriteId) {
        try {
            String sql = "DELETE FROM favorites WHERE favorite_id = ?";
            jdbcTemplate.update(sql, favoriteId);
        } catch (Exception e) {
            throw new DaoException("Error deleting favorite", e);
        }
    }}
