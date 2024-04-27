package com.memeov1.memeov1.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MemeLike {
    public @Id Integer post_id;
    public @Id Integer user_id;

    MemeLike(Integer post_id, Integer user_id) {
        this.post_id = post_id;
        this.user_id = user_id;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MemeLike memeLike = (MemeLike) o;
        return Objects.equals(post_id, memeLike.post_id) &&
                Objects.equals(user_id, memeLike.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(post_id, user_id);
    }

}
