package com.memeov1.memeov1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loginID", nullable = false)
    public Integer loginID;

    @Column(unique = true) // nos aseguramos de que no hay dos username iguales
    public String username;

    public String password;

    @OneToOne(targetEntity = User.class, optional = false) // optional=false indica que la relación no puede ser nula
    @JoinColumn(name = "userID", referencedColumnName = "userID", nullable = false)
    public User user;

    public Login() {

    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getLoginID() {
        return loginID;
    }

    public void setLoginID(Integer loginID) {
        this.loginID = loginID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
