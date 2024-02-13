package com.techelevator.dao;

import com.techelevator.model.Movie;

import java.util.List;

public interface MovieDao {

   public List<Movie> getAllMovies();

   public Movie getMovieById(int id);
   public Movie getMovieByName(String name);

    public List<Movie> getMoviesByGenre(String genre) ;

    public List<Movie> getMoviesByRating(String rating);
}
