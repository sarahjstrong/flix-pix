package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.UserGenre;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcUserGenreDao implements UserGenreDao{

    private final JdbcTemplate jdbcTemplate;


    public JdbcUserGenreDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserGenre> getAllUserGenres() {
        List<UserGenre> userGenres = new ArrayList<>();
        String sql = "SELECT user_genre_id, user_id, genre FROM user_genre";
        try {

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                UserGenre userGenre = mapRowToUserGenre(results);
                userGenres.add(userGenre);
            }
        } catch (Exception e) {
            throw new DaoException("Error retrieving user genres", e);
        }
        return userGenres;
    }

    private UserGenre mapRowToUserGenre(SqlRowSet rs) {

        UserGenre userGenre = new UserGenre();
        userGenre.setUserGenreId(rs.getInt("user_genre_id"));
        userGenre.setUserId(rs.getInt("user_id"));
        userGenre.setGenre(rs.getString("genre"));
        return userGenre;
    }

    @Override
    public List<UserGenre> getUserGenresByUsername(String username) {
        List<UserGenre> userGenres = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM user_genre " +
                "JOIN users ON user_genre.user_id = users.user_id " +
                "WHERE users.username = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
            while (results.next()) {
                UserGenre userGenre = mapRowToUserGenre(results);
                userGenres.add(userGenre);
            }
        } catch (Exception e) {
            throw new DaoException("Error retrieving user genres by username", e);
        }
        return userGenres;
    }


    @Override
    public UserGenre addUserGenre(UserGenre userGenreToAdd) {
        String sql = "INSERT INTO user_genre (user_id, genre) VALUES (?, ?) RETURNING user_genre_id";
        try {
            int userGenreId = jdbcTemplate.queryForObject(sql, Integer.class, userGenreToAdd.getUserId(), userGenreToAdd.getGenre());
            userGenreToAdd.setUserGenreId(userGenreId);
        } catch (Exception e) {
            throw new DaoException("Error adding user genre", e);
        }
        return userGenreToAdd;
    }

    @Override
    public void deleteUserGenre(int userGenreId) {

        String sql = "DELETE FROM user_genre WHERE user_genre_id = ?";
        try {
            jdbcTemplate.update(sql, userGenreId);
        } catch (Exception e) {
            throw new DaoException("Error deleting user genre", e);
        }
    }

    }

