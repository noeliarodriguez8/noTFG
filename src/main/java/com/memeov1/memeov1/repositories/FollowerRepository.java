package com.memeov1.memeov1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memeov1.memeov1.entities.Follower;

public interface FollowerRepository extends JpaRepository<Follower, Integer> {

    // encontrar follower por id
    public Follower findByFollowerID(Integer followerID);

    // encontrar follower por fromUserID y toUserID
    public Follower findByFromUserUserIDAndToUserUserID(Integer fromUserID, Integer toUserID);
}
