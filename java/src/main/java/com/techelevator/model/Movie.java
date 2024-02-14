package com.techelevator.model;

public class Movie {

    private int movieId;


    private String title;


    private int releaseYear;


    private int genreId;


    private Double rating;


    private String director;

    private String imdbID;

    private String poster;

    public Movie(int movieId, String title, int releaseYear, int genreId, Double rating, String director) {
        this.movieId = movieId;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genreId=genreId;
        this.rating = rating;
        this.director = director;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
