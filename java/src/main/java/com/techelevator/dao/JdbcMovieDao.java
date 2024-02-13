package com.techelevator.dao;

import com.techelevator.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcMovieDao implements MovieDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Movie> getAllMovies() {
        String sql = "SELECT * FROM movies";
        List<Movie> movies = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            
            movies.add(mapRowToMovie(results));
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
        String sql = "SELECT * FROM movies WHERE movie_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToMovie(results);
        }
        return null;
    }

    @Override
    public Movie getMovieByName(String name) {
        String sql = "SELECT * FROM movies WHERE title = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, name);
        if (result.next()) {
            return mapRowToMovie(result);
        }
        return null;
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
            String sql = "SELECT * FROM movies " +
                    "JOIN genre ON movies.genre_id = genre.genre_id " +
                    "WHERE genre.genre_name = ?";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, genre);
            List<Movie> movies = new ArrayList<>();
            while (results.next()) {
                movies.add(mapRowToMovie(results));
            }
            return movies;
        }


    @Override
    public List<Movie> getMoviesByRating(String rating) {
        String sql = "SELECT * FROM movies WHERE rating = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, rating);


        List<Movie> movies = new ArrayList<>();

        while (results.next()) {
            movies.add(mapRowToMovie(results));
        }

        return movies;
    }
}
