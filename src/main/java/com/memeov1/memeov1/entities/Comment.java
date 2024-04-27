package com.memeov1.memeov1.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Comment {
    public @Id @GeneratedValue Integer comment_id;
    public String text_content;
    public Date created_datetime;
    public Integer created_by_user_id;
    public Integer post_id;

    Comment(String text_content, Date created_datetime, Integer created_by_user_id, Integer post_id) {
        this.comment_id = null;
        this.text_content = text_content;
        this.created_datetime = created_datetime;
        this.created_by_user_id = created_by_user_id;
        this.post_id = post_id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
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

    public Integer getCreated_by_user_id() {
        return created_by_user_id;
    }

    public void setCreated_by_user_id(Integer created_by_user_id) {
        this.created_by_user_id = created_by_user_id;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

}
