package com.memeov1.memeov1.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class MemeLikePK implements Serializable {

    public Integer postID;
    public Integer userID;

    public MemeLikePK() {

    }

    public MemeLikePK(Integer postID, Integer userID) {
        this.postID = postID;
        this.userID = userID;
    }

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MemeLikePK that = (MemeLikePK) o;
        return Objects.equals(postID, that.postID) &&
                Objects.equals(userID, that.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postID, userID);
    }
}
