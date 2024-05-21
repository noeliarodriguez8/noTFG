package com.memeov1.memeov1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "follower")
public class Follower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "followerID", nullable = false)
    public Integer followerID;

    // @JsonBackReference
    @ManyToOne(targetEntity = User.class, optional = false)
    @JoinColumn(name = "fromUser", nullable = false)
    public User fromUser;

    // @JsonManagedReference
    @ManyToOne(targetEntity = User.class, optional = false)
    @JoinColumn(name = "toUser", nullable = false)
    public User toUser;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
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

    public Integer getFollowerID() {
        return followerID;
    }

    public void setFollowerID(Integer followerID) {
        this.followerID = followerID;
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
