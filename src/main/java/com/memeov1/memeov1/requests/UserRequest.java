package com.memeov1.memeov1.requests;

import com.memeov1.memeov1.entities.User;

public class UserRequest {
    public User user;
    public String password;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
