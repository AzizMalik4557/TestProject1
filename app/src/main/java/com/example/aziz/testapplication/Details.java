package com.example.aziz.testapplication;

/**
 * Created by Aziz on 6/26/2018.
 */

public class Details {

    private String userName;
    private String userEmail;
    private String userPicture;


    public Details(String userName, String userEmail, String userPicture) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPicture = userPicture;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }


}
