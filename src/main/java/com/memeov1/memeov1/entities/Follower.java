package com.memeov1.memeov1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Follower {

    public @Id @GeneratedValue Integer followerID;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "fromUser")
    public User fromUser;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "toUser")
    public User toUser;

    public Date started_following;

    public Follower() {

    }

    public Follower(User fromUser, User toUser, Date started_following) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.started_following = started_following;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
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
        return Objects.equals(fromUser, follower.fromUser) &&
                Objects.equals(toUser, follower.toUser) &&
                Objects.equals(started_following, follower.started_following);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromUser, toUser, started_following);
    }

}
