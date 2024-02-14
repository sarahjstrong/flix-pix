package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieAPIDTO {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private int year;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("imdbRating")
    private Double imdbRating;

    @JsonProperty("Director")
    private String director;

    @JsonProperty("imdbID")
    private String imdbID;

    @JsonProperty("Poster")
    private String poster;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
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
}
