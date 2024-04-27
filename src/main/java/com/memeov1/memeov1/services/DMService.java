package com.memeov1.memeov1.services;

import org.springframework.stereotype.Service;

import com.memeov1.memeov1.repositories.DMRepository;

@Service
public class DMService {

    public final DMRepository dmRepository;

    public DMService(DMRepository dmRepository) {
        this.dmRepository = dmRepository;
    }

}
