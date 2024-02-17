package com.techelevator.model;

public class UserDirector {

    private int userDirectorId;

    private int userId;

    private String directorName;

    public UserDirector(int userDirectorId, int userId, String directorName) {
        this.userDirectorId = userDirectorId;
        this.userId = userId;
        this.directorName = directorName;
    }

    public UserDirector() {

    }

    public int getUserDirectorId() {
        return userDirectorId;
    }

    public void setUserDirectorId(int userDirectorId) {
        this.userDirectorId = userDirectorId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
}
