package com.memeov1.memeov1.entities;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postID")
    public Integer postID;

    public String text_content;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date createdDatetime;

    public String media_type;
    public Blob media_file;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userID")
    public User user;

    @OneToMany(targetEntity = MemeLike.class)
    public List<MemeLike> memeLikes;

    @OneToMany(targetEntity = Comment.class)
    public List<Comment> comments;

    public Post() {

    }

    public Post(String text_content, String media_type, Blob media_file) {
        this.text_content = text_content;
        this.media_type = media_type;
        this.media_file = media_file;
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

    public Date getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(Date createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<MemeLike> getMemeLikes() {
        return memeLikes;
    }

    public void setMemeLikes(List<MemeLike> memeLikes) {
        this.memeLikes = memeLikes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
