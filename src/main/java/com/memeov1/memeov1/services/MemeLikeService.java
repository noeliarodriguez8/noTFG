package com.memeov1.memeov1.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.memeov1.memeov1.entities.MemeLike;
import com.memeov1.memeov1.entities.MemeLikePK;
import com.memeov1.memeov1.repositories.MemeLikeRepository;

@Service
public class MemeLikeService {

    public final MemeLikeRepository memeLikeRepository;

    public MemeLikeService(MemeLikeRepository memeLikeRepository) {
        this.memeLikeRepository = memeLikeRepository;
    }

    @Transactional
    public MemeLike create(MemeLike memeLike) {
        return memeLikeRepository.saveAndFlush(memeLike);
    }

    @Transactional
    public String delete(MemeLikePK memeLikePK) {
        // MemeLike memeLike = memeLikeRepository.findMemeLikeByMemeLikePK(memeLikePK);
        memeLikeRepository.deleteByMemeLikePK(memeLikePK);
        return "Deleted meme-like from post " + memeLikePK.getPostID() + " and user " + memeLikePK.getUserID();
    }

}
