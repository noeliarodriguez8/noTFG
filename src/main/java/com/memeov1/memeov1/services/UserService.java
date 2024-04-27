package com.memeov1.memeov1.services;

import org.springframework.stereotype.Service;

import com.memeov1.memeov1.repositories.UserRepository;

@Service
public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
