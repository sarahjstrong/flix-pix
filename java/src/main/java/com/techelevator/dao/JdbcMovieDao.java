package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Movie;
import com.techelevator.model.MovieAPIDTO;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import services.OMDBService;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcMovieDao implements MovieDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Movie> getAllMovies() {
        String sql = "SELECT * FROM movies";
        List<Movie> movies = new ArrayList<>();
        try{
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            movies.add(mapRowToMovie(results));

        }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect", e);
        }
        return movies;
    }


        public Movie mapRowToMovie(SqlRowSet rs) {

            int id = rs.getInt("movie_id");
            String title = rs.getString("title");
            int releaseYear = rs.getInt("release_year");
            int genreId = rs.getInt("genre_id");
            double rating = rs.getDouble("rating");
            String director = rs.getString("director");

            Movie movie = new Movie(id, title,releaseYear,genreId, rating, director );
            return movie;
        }

    @Override
    public Movie getMovieById(int id) {
        Movie movie = null;
        String sql = "SELECT * FROM movies WHERE movie_id = ?";
        try{
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            movie = mapRowToMovie(results);
        }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect", e);
        }
        return movie;
    }

    @Override
    public Movie getMovieByName(String name) {
        Movie movie = null;
        String sql = "SELECT * FROM movies WHERE title LIKE ?";
        try{
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, name);
        if (result.next()) {
            movie= mapRowToMovie(result);}

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect", e);
        }
        return movie;
    }


    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        String sql = "SELECT * FROM movies " +
                "JOIN genre ON movies.genre_id = genre.genre_id " +
                "WHERE genre.genre_name = ?";

        List<Movie> movies = new ArrayList<>();

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, genre);
            while (results.next()) {
                movies.add(mapRowToMovie(results));
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect", e);
        }
            return movies;
        }


    @Override
    public List<Movie> getMoviesByRating(String rating) {
        String sql = "SELECT * FROM movies WHERE rating = ?";

        List<Movie> movies = new ArrayList<>();

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, rating);
            while (results.next()) {
                movies.add(mapRowToMovie(results));

            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect", e);
        }
        return movies;}



}
