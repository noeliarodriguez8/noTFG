package com.memeov1.memeov1.entities;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "meme_like")
public class MemeLike {

    @EmbeddedId
    public MemeLikePK memeLikePK;

    @JsonIgnoreProperties(value = { "user", "comments", "memeLikes" }, allowSetters = true)
    @ManyToOne(targetEntity = Post.class, optional = false)
    @JoinColumn(name = "postID", insertable = false, updatable = false, nullable = false)
    public Post post;

    @JsonIgnoreProperties(value = { "followers", "following", "comments", "memeLikes", "posts", "conversations",
            "directMessages", "name", "surname", "email", "signup_date", "birth_date", "login",
            "avatar" }, allowSetters = true)
    @ManyToOne(targetEntity = User.class, optional = false)
    @JoinColumn(name = "userID", insertable = false, updatable = false, nullable = false)
    public User user;

    public MemeLike() {

    }

    public MemeLike(Post post, User user) {
        this.post = post;
        this.user = user;
        this.memeLikePK = new MemeLikePK(post.getPostID(), user.getUserID());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MemeLike memeLike = (MemeLike) o;
        return Objects.equals(memeLikePK, memeLike.memeLikePK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memeLikePK);
    }

    public MemeLikePK getMemeLikePK() {
        return memeLikePK;
    }

    public void setMemeLikePK(MemeLikePK memeLikePK) {
        this.memeLikePK = memeLikePK;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
