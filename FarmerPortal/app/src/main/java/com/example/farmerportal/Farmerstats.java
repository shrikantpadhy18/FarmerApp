package com.example.farmerportal;

public class Farmerstats {

    private String Username,Usertype,mobile;

    public Farmerstats(String username, String usertype, String mobile) {
        this.Username = username;
        this.Usertype = usertype;
        this.mobile = mobile;
    }

    public String getUsername() {
        return Username;
    }

    public String getUsertype() {
        return Usertype;
    }

    public String getMobile() {
        return mobile;
    }
}
