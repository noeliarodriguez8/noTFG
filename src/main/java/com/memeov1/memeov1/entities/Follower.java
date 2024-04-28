package com.memeov1.memeov1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Follower {

    public @Id @GeneratedValue Integer followingUserID;
    public @Id @GeneratedValue Integer followedUserID;
    public Date started_following;

    Follower(Integer followingUserID, Integer followedUserID, Date started_following) {
        this.followingUserID = followingUserID;
        this.followedUserID = followedUserID;
        this.started_following = started_following;
    }

    public Integer getfollowingUserID() {
        return followingUserID;
    }

    public void setfollowingUserID(Integer followingUserID) {
        this.followingUserID = followingUserID;
    }

    public Integer getfollowedUserID() {
        return followedUserID;
    }

    public void setfollowedUserID(Integer followedUserID) {
        this.followedUserID = followedUserID;
    }

    public Date getStarted_following() {
        return started_following;
    }

    public void setStarted_following(Date started_following) {
        this.started_following = started_following;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Follower follower = (Follower) o;
        return Objects.equals(followingUserID, follower.followingUserID) &&
                Objects.equals(followedUserID, follower.followedUserID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(followingUserID, followedUserID);
    }

}
