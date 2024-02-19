package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.UserRating;
import org.springframework.dao.DataAccessException;
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
            String sql = "SELECT rating_id, user_id, movie_id, rating, review FROM user_rating";
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
        String review = rs.getString("review");
        return new UserRating(ratingId, userId, movieId, rating, review);
    }


    @Override
    public List<UserRating> getUserRatingsByUsername(String username) {

            List<UserRating> userRatings = new ArrayList<>();
            String sql = "SELECT user_rating.rating_id, user_rating.user_id, user_rating.movie_id, user_rating.rating, user_rating.review FROM user_rating " +
                    "JOIN users ON user_rating.user_id = users.user_id " +
                    "WHERE users.username = ?";
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
    public UserRating getUserRatingByMovie(int userId, int movieId) {
        UserRating userRating = null;
        try {
            String sql = "SELECT * FROM user_rating WHERE user_id = ? AND movie_id = ?";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, movieId);
            if(results.next()) {
                userRating = mapRowToUserRating(results);
            }
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
        return userRating;
    }


    @Override
    public UserRating addUserRating(UserRating userRating) {
        try {
            String sql = "INSERT INTO user_rating (user_id, movie_id, rating, review) VALUES (?, ?, ?, ?) RETURNING rating_id";
            int ratingId = jdbcTemplate.queryForObject(sql, int.class, userRating.getUserId(), userRating.getMovieId(), userRating.getRating(), userRating.getReview());
            userRating.setRatingId(ratingId);
            return userRating;
        } catch (Exception e) {
            throw new DaoException("Error adding user rating", e);
        }
    }

    @Override
    public UserRating updateUserRating(UserRating userRating) {
        try {
            String sql = "UPDATE user_rating SET rating = ?, review = ? WHERE rating_id = ?";
            jdbcTemplate.update(sql, userRating.getRating(), userRating.getReview(), userRating.getRatingId());
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