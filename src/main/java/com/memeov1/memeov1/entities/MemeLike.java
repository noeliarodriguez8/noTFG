package com.memeov1.memeov1.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MemeLike {

    @EmbeddedId
    public MemeLikePK memeLikePK;

    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(name = "postID", insertable = false, updatable = false)
    public Post post;
    // public @Id Integer postID;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userID", insertable = false, updatable = false)
    public User user;
    // public @Id Integer userID;

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

}
