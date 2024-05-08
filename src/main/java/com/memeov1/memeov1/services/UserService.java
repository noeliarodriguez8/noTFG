package com.memeov1.memeov1.services;

import org.springframework.stereotype.Service;

import com.memeov1.memeov1.entities.User;
import com.memeov1.memeov1.repositories.UserRepository;

@Service
public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        return userRepository.saveAndFlush(user);
    }

    public User read(Integer userID) {
        return userRepository.findByUserID(userID);
    }

    public User update(Integer userID, User updatedUser) {
        User existingUser = userRepository.findByUserID(userID);
        if (existingUser != null) {
            existingUser = updatedUser;
            return userRepository.saveAndFlush(existingUser);
        } else {
            return null;
        }
    }

    public String delete(Integer userID) {
        User user = userRepository.findByUserID(userID);
        userRepository.deleteById(userID);
        return "Deleted user: " + user.getUsername();
    }
}
