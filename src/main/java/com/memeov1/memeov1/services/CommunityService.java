package com.memeov1.memeov1.services;

import org.springframework.stereotype.Service;

import com.memeov1.memeov1.repositories.CommunityRepository;

@Service
public class CommunityService {

    public final CommunityRepository communityRepository;

    public CommunityService(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

}
