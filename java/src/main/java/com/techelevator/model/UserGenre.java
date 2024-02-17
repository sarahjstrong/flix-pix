package com.techelevator.model;

public class UserGenre {

    private int userGenreId;
    private int userId;
    private String genre;

    public UserGenre(int userGenreId, int userId, String genre) {
        this.userGenreId = userGenreId;
        this.userId = userId;
        this.genre = genre;
    }

    public UserGenre() {

    }

    public int getUserGenreId() {
        return userGenreId;
    }

    public void setUserGenreId(int userGenreId) {
        this.userGenreId = userGenreId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
