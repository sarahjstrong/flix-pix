package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.UserDirector;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcUserDirector implements UserDirectorDao{

    private final JdbcTemplate jdbcTemplate;


    public JdbcUserDirector(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserDirector> getAllUserDirectors() {
        List<UserDirector> userDirectors = new ArrayList<>();
        String sql = "SELECT user_director_id, user_id, director_name FROM user_director";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                UserDirector userDirector = mapRowToUserDirector(results);
                userDirectors.add(userDirector);
            }
        } catch (Exception e) {
            throw new DaoException("Error retrieving user directors", e);
        }
        return userDirectors;
    }

    private UserDirector mapRowToUserDirector(SqlRowSet rs) {
        UserDirector userDirector = new UserDirector();
        userDirector.setUserDirectorId(rs.getInt("user_director_id"));
        userDirector.setUserId(rs.getInt("user_id"));
        userDirector.setDirectorName(rs.getString("director_name"));
        return userDirector;
    }

    @Override
    public List<String> getDirectorsForUser(int userId) {
        List<String> directors = new ArrayList<>();
        String sql = "SELECT director_name FROM user_director WHERE user_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                directors.add(results.getString("director_name"));
            }
        } catch (Exception e) {
            throw new DaoException("Error retrieving directors for user", e);
        }
        return directors;
    }

    @Override
    public UserDirector addUserDirector(UserDirector userDirectorToAdd) {
        String sql = "INSERT INTO user_director (user_id, director_name) VALUES (?, ?) RETURNING user_director_id";
        try {
            int userDirectorId = jdbcTemplate.queryForObject(sql, Integer.class, userDirectorToAdd.getUserId(), userDirectorToAdd.getDirectorName());
            userDirectorToAdd.setUserDirectorId(userDirectorId);
        } catch (Exception e) {
            throw new DaoException("Error adding user director", e);
        }
        return userDirectorToAdd;
    }

    @Override
    public void deleteUserDirector(int userDirectorId) {
        String sql = "DELETE FROM user_director WHERE user_director_id = ?";
        try {
            jdbcTemplate.update(sql, userDirectorId);
        } catch (Exception e) {
            throw new DaoException("Error deleting user director", e);
        }
    }
}