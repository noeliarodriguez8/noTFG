package com.memeov1.memeov1.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
    public @Id @GeneratedValue Integer commentID;
    public String text_content;
    public Date created_datetime;
    // public Integer created_by_user_id;
    public Integer postID;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userID")
    public User user;

    Comment(String text_content, Date created_datetime, Integer postID) {
        this.commentID = null;
        this.text_content = text_content;
        this.created_datetime = created_datetime;
        // this.created_by_user_id = created_by_user_id;
        this.postID = postID;
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

    public Integer getpostID() {
        return postID;
    }

    public void setpostID(Integer postID) {
        this.postID = postID;
    }

}
