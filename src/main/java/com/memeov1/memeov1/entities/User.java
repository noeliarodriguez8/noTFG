package com.memeov1.memeov1.entities;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
// property = "userID")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID", nullable = false)
    public Integer userID;

    public String username;
    public String name;
    public String surname;
    public String email;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date signup_date;

    public Date birth_date;
    public String avatar;

    @JsonIgnoreProperties(value = { "fromUser", "toUser" }, allowSetters = true, allowGetters = true)
    @OneToMany(targetEntity = Follower.class, cascade = CascadeType.ALL, mappedBy = "toUser", orphanRemoval = true)
    public List<Follower> followers;

    @JsonIgnoreProperties(value = { "fromUser", "toUser" }, allowSetters = true, allowGetters = true)
    @OneToMany(targetEntity = Follower.class, cascade = CascadeType.ALL, mappedBy = "fromUser", orphanRemoval = true)
    public List<Follower> following;

    @JsonIgnore
    @JsonIgnoreProperties(value = "user", allowSetters = true)
    @OneToOne(targetEntity = Login.class, cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    public Login login;

    @JsonIgnore
    @JsonIgnoreProperties(value = "user", allowSetters = true)
    @OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    public List<Comment> comments;

    @JsonIgnoreProperties(value = { "user", "comments" }, allowSetters = true)
    @OneToMany(targetEntity = Post.class, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    // hay que poner el mappedby para que pueda borrar los posts al borrar el user
    public List<Post> posts;

    @JsonIgnore
    @JsonIgnoreProperties(value = "user", allowSetters = true)
    @OneToMany(targetEntity = MemeLike.class, cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    public List<MemeLike> memeLikes;

    @JsonIgnore
    @ManyToMany(targetEntity = Conversation.class, cascade = CascadeType.ALL)
    @JoinTable(name = "user_conversation", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = {
            @JoinColumn(name = "conversationID"),
            @JoinColumn(name = "starterUserID"),
            @JoinColumn(name = "receiverUserID")
    })
    public List<Conversation> conversations;

    @JsonIgnore
    @OneToMany(targetEntity = DirectMessage.class, cascade = CascadeType.ALL, mappedBy = "senderUser", orphanRemoval = true)
    public List<DirectMessage> directMessages;

    public User() {

    }

    // añado la password al constructor para usarla para construir el login dentro
    // del constructor de user
    public User(String username, String name, String surname, String email, Date birth_date, String avatar,
            String password) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.signup_date = new Date();
        this.birth_date = birth_date;
        this.avatar = avatar;
        this.followers = new ArrayList<Follower>();
        this.following = new ArrayList<Follower>();
        this.login = new Login(username, password);
        this.comments = new ArrayList<Comment>();
        this.posts = new ArrayList<Post>();
        this.memeLikes = new ArrayList<MemeLike>();
        this.conversations = new ArrayList<Conversation>();
        this.directMessages = new ArrayList<DirectMessage>();
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
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

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<MemeLike> getMemeLikes() {
        return memeLikes;
    }

    public void setMemeLikes(List<MemeLike> memeLikes) {
        this.memeLikes = memeLikes;
    }

    public List<Conversation> getConversations() {
        return conversations;
    }

    public void setConversations(List<Conversation> conversations) {
        this.conversations = conversations;
    }

    public List<DirectMessage> getDirectMessages() {
        return directMessages;
    }

    public void setDirectMessages(List<DirectMessage> directMessages) {
        this.directMessages = directMessages;
    }

}
