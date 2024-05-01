package com.memeov1.memeov1.entities;

import java.sql.Date;
import java.util.List;
import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Post {

    @Column(name = "postID")
    public @Id @GeneratedValue Integer postID;

    public String text_content;
    public Date created_datetime;
    public String media_type;
    public Blob media_file;
    // public Integer userID;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userID")
    public User user;

    @OneToMany(targetEntity = MemeLike.class)
    public List<MemeLike> memeLikes;

    Post(String text_content, Date created_datetime, String media_type, Blob media_file) {
        this.text_content = text_content;
        this.created_datetime = created_datetime;
        this.media_type = media_type;
        this.media_file = media_file;
        this.created_datetime = created_datetime;
        // this.userID = userID;
    }

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
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

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public Blob getMedia_file() {
        return media_file;
    }

    public void setMedia_file(Blob media_file) {
        this.media_file = media_file;
    }

}
