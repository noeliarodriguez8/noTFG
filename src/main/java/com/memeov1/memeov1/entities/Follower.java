package com.memeov1.memeov1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Follower {

    public @Id @GeneratedValue Integer following_user_id;
    public @Id @GeneratedValue Integer followed_user_id;
    public Date started_following;

    Follower(Integer following_user_id, Integer followed_user_id, Date started_following) {
        this.following_user_id = following_user_id;
        this.followed_user_id = followed_user_id;
        this.started_following = started_following;
    }

    public Integer getFollowing_user_id() {
        return following_user_id;
    }

    public void setFollowing_user_id(Integer following_user_id) {
        this.following_user_id = following_user_id;
    }

    public Integer getFollowed_user_id() {
        return followed_user_id;
    }

    public void setFollowed_user_id(Integer followed_user_id) {
        this.followed_user_id = followed_user_id;
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
        return Objects.equals(following_user_id, follower.following_user_id) &&
                Objects.equals(followed_user_id, follower.followed_user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(following_user_id, followed_user_id);
    }

}
