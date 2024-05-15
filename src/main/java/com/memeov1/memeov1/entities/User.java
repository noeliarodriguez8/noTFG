package com.memeov1.memeov1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    public Integer userID;

    public String username;
    public String name;
    public String surname;
    public String email;
    public Date signup_date;
    public Date birth_date;
    public Blob avatar;

    // @JsonManagedReference
    @JsonIgnoreProperties({ "fromUser", "toUser" })
    @OneToMany(targetEntity = Follower.class)
    public List<Follower> followers;

    // @JsonBackReference
    @JsonIgnoreProperties({ "fromUser", "toUser" })
    @OneToMany(targetEntity = Follower.class)
    public List<Follower> following;

    @OneToOne(targetEntity = Login.class)
    public Login login;

    @OneToMany(targetEntity = Comment.class)
    public List<Comment> comments;

    @OneToMany(targetEntity = Post.class)
    public List<Post> posts;

    @OneToMany(targetEntity = MemeLike.class)
    public List<MemeLike> memeLikes;

    @ManyToMany(targetEntity = Conversation.class)
    @JoinTable(name = "user_conversation", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = {
            @JoinColumn(name = "conversationID"), @JoinColumn(name = "starterUserID"),
            @JoinColumn(name = "receiverUserID") })
    public List<Conversation> conversations;

    @OneToMany(targetEntity = DirectMessage.class)
    public List<DirectMessage> directMessages;

    public User() {

    }

    public User(String username, String name, String surname, String email, Date birth_date, Blob avatar) {
        this.userID = null;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.signup_date = new Date();
        this.birth_date = birth_date;
        this.avatar = avatar;
        this.followers = new ArrayList<Follower>();
        this.following = new ArrayList<Follower>();
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

    public List<Follower> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follower> followers) {
        this.followers = followers;
    }

    public List<Follower> getFollowing() {
        return following;
    }

    public void setFollowing(List<Follower> following) {
        this.following = following;
    }

}
