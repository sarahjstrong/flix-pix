package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Genre;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGenreDao implements GenreDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGenreDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Genre> getGenres() {

        List<Genre> genres = new ArrayList<>();
        String sql = "SELECT * FROM genre";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                genres.add(mapRowToGenre(results));

            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect", e);
        }
        return genres;
    }

    private Genre mapRowToGenre(SqlRowSet rs) {

        int id =rs.getInt("genre_id");
        String name =rs.getString("genre_name");

        Genre genre = new Genre(id, name);

        return genre;
    }


    @Override
    public Genre getGenreById(int id) {
        Genre genre = null;
        String sql = "SELECT * FROM genre WHERE genre_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                genre = mapRowToGenre(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return genre;
    }


    @Override
    public Genre getGenreByName(String name) {
        Genre genre = null;
        String sql = "SELECT * FROM genre WHERE genre_name = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
            if (results.next()) {
                genre = mapRowToGenre(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return genre;
    }
}
