package com.moon;


public class Users {

    private String userName;

    private Integer userId;

    public String getUserName() {
        return userName;
    }

    public Users(String userName, Integer userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
