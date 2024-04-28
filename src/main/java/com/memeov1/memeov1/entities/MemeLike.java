package com.memeov1.memeov1.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MemeLike {
    public @Id Integer postID;
    public @Id Integer userID;

    MemeLike(Integer postID, Integer userID) {
        this.postID = postID;
        this.userID = userID;
    }

    public Integer getpostID() {
        return postID;
    }

    public void setpostID(Integer postID) {
        this.postID = postID;
    }

    public Integer getuserID() {
        return userID;
    }

    public void setuserID(Integer userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MemeLike memeLike = (MemeLike) o;
        return Objects.equals(postID, memeLike.postID) &&
                Objects.equals(userID, memeLike.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postID, userID);
    }

}
