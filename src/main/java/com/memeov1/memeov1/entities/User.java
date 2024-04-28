package com.memeov1.memeov1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.sql.Blob;
//import java.sql.Date;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    public @Id @GeneratedValue Integer userID;
    public String username;
    public String name;
    public String surname;
    public String email;
    public Date signup_date;
    public Date birth_date;
    public Blob avatar;

    @OneToMany
    public List<Post> posts;

    public User(String username, String name, String surname, String email, Date birth_date, Blob avatar) {
        this.userID = null;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.signup_date = new Date();
        this.birth_date = birth_date;
        this.avatar = avatar;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getSignup_date() {
        return signup_date;
    }

    public void setSignup_date(Date signup_date) {
        this.signup_date = signup_date;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }
}
