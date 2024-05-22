package com.memeov1.memeov1.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.memeov1.memeov1.entities.Follower;
import com.memeov1.memeov1.repositories.FollowerRepository;

@Service
public class FollowerService {

    public final FollowerRepository followerRepository;

    public FollowerService(FollowerRepository followerRepository) {
        this.followerRepository = followerRepository;
    }

    @Transactional
    public Follower create(Follower follower) {
        return followerRepository.saveAndFlush(follower);
    }

    @Transactional
    public String delete(Integer fromUserID, Integer toUserID) {
        Follower follower = followerRepository.findByFromUserUserIDAndToUserUserID(fromUserID, toUserID);
        followerRepository.deleteById(follower.getFollowerID());
        return "Deleted follow from: " + follower.getFromUser().getUsername() + " to "
                + follower.getToUser().getUsername();
    }

}
