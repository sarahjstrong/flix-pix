package com.techelevator.model;

public class Movie {

    private int movieId;


    private String title;


    private int releaseYear;


    private String genre;


    private Double rating;


    private String director;

    private String imdbId;

    private String poster;

    private String plot;

    public Movie() {
    }

    public Movie(int movieId, String title, int releaseYear, String genre, Double rating, String director, String poster, String plot) {
        this.movieId = movieId;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre=genre;
        this.rating = rating;
        this.director = director;
        this.poster = poster;
        this.plot = plot;
    }

    public Movie(String title, int releaseYear, String imdbId, String poster) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.imdbId = imdbId;
        this.poster = poster;

    }

    public Movie(String title, int releaseYear, String genre, String director, String poster, String plot) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.director = director;
        this.poster = poster;
        this.plot = plot;
    }

    //    public String getImdbID() {
//        return imdbID;
//    }
//
//    public void setImdbID(String imdbID) {
//        this.imdbID = imdbID;
//    }

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}
