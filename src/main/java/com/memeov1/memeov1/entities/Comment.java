package com.memeov1.memeov1.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentID", nullable = false)
    public Integer commentID;

    public String text_content;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date created_datetime;

    @JsonIgnoreProperties(value = { "followers", "following", "comments", "memeLikes", "posts", "conversations",
            "directMessages", "name", "surname", "email", "signup_date", "birth_date", "login",
            "avatar" }, allowSetters = true)
    @ManyToOne(targetEntity = User.class, optional = false)
    @JoinColumn(name = "userID", updatable = false, nullable = false)
    public User user;

    @JsonIgnore
    @JsonIgnoreProperties(value = { "user", "comments", "memeLikes" }, allowSetters = true)
    @ManyToOne(targetEntity = Post.class, optional = false)
    @JoinColumn(name = "postID", updatable = false, nullable = false)
    // quito insertable=false
    public Post post;

    public Comment() {

    }

    public Comment(String text_content) {
        this.text_content = text_content;
        this.created_datetime = new Date();
    }

    public String getText_content() {
        return text_content;
    }

    public void setText_content(String text_content) {
        this.text_content = text_content;
    }

    public Date getCreated_datetime() {
        return created_datetime;
    }

    public void setCreated_datetime(Date created_datetime) {
        this.created_datetime = created_datetime;
    }

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

}
