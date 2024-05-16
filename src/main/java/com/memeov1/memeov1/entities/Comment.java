package com.memeov1.memeov1.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer commentID;

    public String text_content;
    public Date created_datetime;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userID")
    public User user;

    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(name = "postID", updatable = false)
    // quito insertable=false
    public Post post;

    public Comment() {

    }

    public Comment(String text_content, Date created_datetime) {
        this.commentID = null;
        this.text_content = text_content;
        this.created_datetime = created_datetime;
    }

    public Integer getcommentID() {
        return commentID;
    }

    public void setcommentID(Integer commentID) {
        this.commentID = commentID;
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

}
