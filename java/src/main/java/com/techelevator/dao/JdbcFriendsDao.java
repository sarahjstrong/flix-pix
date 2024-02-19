package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Friends;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcFriendsDao implements FriendsDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcFriendsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Friends> getAllFriends() {
        List<Friends> friendsList = new ArrayList<>();
        String sql = "SELECT user_id_1, user_id_2 FROM friends";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Friends friends = mapRowToFriends(results);
                friendsList.add(friends);
            }
        } catch (Exception e) {
            throw new DaoException("Error retrieving friends", e);
        }
        return friendsList;
    }

    private Friends mapRowToFriends(SqlRowSet rs) {

        Friends friends = new Friends();
        friends.setUserId1(rs.getInt("user_id_1"));
        friends.setUserId2(rs.getInt("user_id_2"));
        return friends;
    }



    @Override
    public List<Integer> getFriendsForUser(int userId) {
            List<Integer> friendIds = new ArrayList<>();
            String sql = "SELECT user_id_2 FROM friends WHERE user_id_1 = ?";
            try {
                SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
                while (results.next()) {
                    friendIds.add(results.getInt("user_id_2"));
                }
            } catch (Exception e) {
                throw new DaoException("Error retrieving friends for user", e);
            }
            return friendIds;
        }

    @Override
    public Friends addFriend(Friends friendsToAdd) {
        String sql = "INSERT INTO friends (user_id_1, user_id_2) VALUES (?, ?)";
        try {
            jdbcTemplate.update(sql, friendsToAdd.getUserId1(), friendsToAdd.getUserId2());
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Friend relationship already exists", e);
        } catch (Exception e) {
            throw new DaoException("Error adding friend", e);
        }
        return friendsToAdd;
    }

    @Override
    public void deleteFriend(int userId1, int userId2) {

        String sql = "DELETE FROM friends WHERE (user_id_1 = ? AND user_id_2 = ?) OR (user_id_1 = ? AND user_id_2 = ?)";
        try {
            jdbcTemplate.update(sql, userId1, userId2,  userId2, userId1);
        } catch (Exception e) {
            throw new DaoException("Error deleting friend", e);
        }
    }

    }

