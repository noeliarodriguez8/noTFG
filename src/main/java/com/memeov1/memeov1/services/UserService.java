package com.memeov1.memeov1.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.memeov1.memeov1.entities.Login;
import com.memeov1.memeov1.entities.User;
import com.memeov1.memeov1.repositories.LoginRepository;
import com.memeov1.memeov1.repositories.UserRepository;

@Service
public class UserService {

    public final UserRepository userRepository;
    public final LoginRepository loginRepository;

    public UserService(UserRepository userRepository, LoginRepository loginRepository) {
        this.userRepository = userRepository;
        this.loginRepository = loginRepository;
    }

    // en user solo permitimos jpg
    @Transactional
    public User create(User user) {

        String filePath = "";

        try {
            byte[] imagenBytes = Base64.getDecoder().decode(user.getAvatar());
            filePath = "uploads/avatars/" + user.getUsername() + "." + "jpg";
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                fos.write(imagenBytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setAvatar(filePath);
        return userRepository.saveAndFlush(user);
    }

    public User read(Integer userID) {
        return userRepository.findByUserID(userID);
    }

    @Transactional
    public User update(Integer userID, User updatedUser) {
        User existingUser = userRepository.findByUserID(userID);
        if (existingUser != null) {
            // referente al login
            if (!existingUser.getUsername().equals(updatedUser.getUsername())) {
                Login login = loginRepository.findByUserUserID(userID);
                login.setUsername(updatedUser.getUsername());
            }
            existingUser = updatedUser;
            return userRepository.saveAndFlush(existingUser);
        } else {
            return null;
        }
    }

    @Transactional
    public String delete(Integer userID) {
        User user = userRepository.findByUserID(userID);
        userRepository.deleteById(userID);
        return "Deleted user: " + user.getUsername();
    }
}
