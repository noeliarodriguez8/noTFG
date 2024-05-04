package com.memeov1.memeov1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.UniqueConstraint;

import java.sql.Blob;
//import java.sql.Date;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Column(name = "userID")
    public @Id @GeneratedValue Integer userID;

    public String username;
    public String name;
    public String surname;
    public String email;
    public Date signup_date;
    public Date birth_date;
    public Blob avatar;

    @OneToOne(targetEntity = Login.class)
    public Login login;

    @OneToMany(targetEntity = Comment.class)
    public List<Comment> comments;

    @OneToMany(targetEntity = Post.class)
    public List<Post> posts;

    @OneToMany(targetEntity = MemeLike.class)
    public List<MemeLike> memeLikes;

    // --------------- IMPORTANTE!!!!!!!!!!! ---------------------------
    // @ManyToMany(targetEntity = Conversation.class)
    // @JoinTable(name = "user_conversation", joinColumns = @JoinColumn(name =
    // "userID"), inverseJoinColumns = @JoinColumn(name = "conversationID"),
    // uniqueConstraints = @UniqueConstraint(columnNames = {
    // "starterUserID", "receiverUserID" }))
    // @JoinColumns({
    // @JoinColumn(name = "starterUserID", referencedColumnName = "starterUserID"),
    // @JoinColumn(name = "receiverUserID", referencedColumnName = "receiverUserID")
    // })
    // public List<Conversation> user_conversations;

    @ManyToMany(targetEntity = Conversation.class)
    @JoinTable(name = "user_conversation", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "conversationID"), uniqueConstraints = @UniqueConstraint(columnNames = {
            "starterUserID", "receiverUserID" }))
    public List<Conversation> user_conversations;

    @OneToMany(targetEntity = DirectMessage.class)
    public List<DirectMessage> directMessages;

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
