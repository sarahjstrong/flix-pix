package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.UserRating;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUserRatingDao implements UserRatingDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRatingDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<UserRating> getAllUserRatings() {
        List<UserRating> userRatings = new ArrayList<>();
        try {
            String sql = "SELECT rating_id, user_id, movie_id, rating FROM user_rating";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                UserRating userRating = mapRowToUserRating(results);
                userRatings.add(userRating);
            }
        } catch (Exception e) {
            throw new DaoException("Error retrieving user ratings", e);
        }
        return userRatings;
    }

    private UserRating mapRowToUserRating(SqlRowSet rs) {
        int ratingId = rs.getInt("rating_id");
        int userId = rs.getInt("user_id");
        int movieId = rs.getInt("movie_id");
        double rating = rs.getDouble("rating");
        return new UserRating(ratingId, userId, movieId, rating);
    }


    @Override
    public List<UserRating> getUserRatingsByUsername(String username) {

            List<UserRating> userRatings = new ArrayList<>();
            String sql = "SELECT user_rating.rating_id, user_rating.user_id, user_rating.movie_id, user_rating.rating FROM user_rating ur " +
                    "JOIN users ON user_rating.user_id = user.user_id " +
                    "WHERE user.username = ?";
            try {
                SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
                while (results.next()) {
                    UserRating userRating = mapRowToUserRating(results);
                    userRatings.add(userRating);
                }
            } catch (Exception e) {
                throw new DaoException("Error retrieving user ratings by username", e);
            }
            return userRatings;
        }
    @Override
    public UserRating addUserRating(UserRating userRating) {
        try {
            String sql = "INSERT INTO user_rating (user_id, movie_id, rating) VALUES (?, ?, ?) RETURNING rating_id";
            int ratingId = jdbcTemplate.queryForObject(sql, Integer.class, userRating.getUserId(), userRating.getMovieId(), userRating.getRating());
            userRating.setRatingId(ratingId);
            return userRating;
        } catch (Exception e) {
            throw new DaoException("Error adding user rating", e);
        }
    }

    @Override
    public UserRating updateUserRating(UserRating userRating) {
        try {
            String sql = "UPDATE user_rating SET rating = ? WHERE rating_id = ?";
            jdbcTemplate.update(sql, userRating.getRating(), userRating.getRatingId());
            return userRating;
        } catch (Exception e) {
            throw new DaoException("Error updating user rating", e);
        }
    }

    @Override
    public void deleteUserRating(int ratingId) {
        try {
            String sql = "DELETE FROM user_rating WHERE rating_id = ?";
            jdbcTemplate.update(sql, ratingId);
        } catch (Exception e) {
            throw new DaoException("Error deleting user rating", e);
        }
    }}