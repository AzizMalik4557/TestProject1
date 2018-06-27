package com.example.aziz.testapplication;

/**
 * Created by Aziz on 6/26/2018.
 */

public class Followers {
    private String followerLogin;
    private String followerImage;

    public Followers(String followerLogin, String followerImage) {
        this.followerLogin = followerLogin;
        this.followerImage = followerImage;
    }

    public String getFollowerLogin() {
        return followerLogin;
    }

    public void setFollowerLogin(String followerLogin) {
        this.followerLogin = followerLogin;
    }

    public String getFollowerImage() {
        return followerImage;
    }

    public void setFollowerImage(String followerImage) {
        this.followerImage = followerImage;
    }
}
