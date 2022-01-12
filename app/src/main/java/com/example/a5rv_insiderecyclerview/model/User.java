package com.example.a5rv_insiderecyclerview.model;

import java.util.List;

public class User {
    private String name;
    private String password;
    private List<UserSub> userSubs;

    public User(String name, String password,List<UserSub>userSubs) {
        this.name = name;
        this.password = password;
        this.userSubs = userSubs;
    }
    public User(){

    }

    public List<UserSub> getUserSubs(){return userSubs;}
    public void setUserSubs(List<UserSub>userSubs){this.userSubs = userSubs;}

    public String getName(){return name;}
    public String getPassword(){return password;}
    public void setName(String name){this.name = name;}
    public void setPassword(String password){this.password = password;}
}
