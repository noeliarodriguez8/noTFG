package com.memeov1.memeov1.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.regex.Pattern;

import org.springframework.security.crypto.password.PasswordEncoder;
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
    public final LoginService loginService;
    public static final Pattern BASE64_PATTERN = Pattern.compile("^[a-zA-Z0-9+/]*={0,2}$");
    public final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, LoginRepository loginRepository, LoginService loginService,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.loginRepository = loginRepository;
        this.loginService = loginService;
        this.passwordEncoder = passwordEncoder;
    }

    // en user solo permitimos jpg
    @Transactional
    public User create(User user, String password) {

        String filePath = "";

        if (user.getAvatar() != null) {

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
        } else {
            filePath = "uploads/avatars/default/default-avatar.jpg";
            user.setAvatar(filePath);
        }

        User createdUser = userRepository.saveAndFlush(user);

        Login login = new Login(createdUser.getUsername(), passwordEncoder.encode(password));
        login.setUser(createdUser);
        loginService.create(login);

        return createdUser;
    }

    public User read(Integer userID) {
        return userRepository.findByUserID(userID);
    }

    @Transactional
    public User update(Integer userID, User updatedUser) {
        User existingUser = userRepository.findByUserID(userID);
        boolean usernameChanged = false;
        if (existingUser != null) {
            // referente al username en user y login
            if (!existingUser.getUsername().equals(updatedUser.getUsername())) {
                Login login = loginRepository.findByUserUserID(userID);
                login.setUsername(updatedUser.getUsername());
                existingUser.setUsername(updatedUser.getUsername());
                usernameChanged = true;
            }

            // referente al avatar
            byte[] existingAvatar = new byte[0];
            try {
                existingAvatar = Files.readAllBytes(Paths.get(existingUser.getAvatar()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            byte[] newAvatar = new byte[0];
            // comprobar si se puede pasar a base64, es decir, si hay nueva foto actualizada
            if (updatedUser.getAvatar() != null && isValidBase64(updatedUser.getAvatar())) {
                try {
                    newAvatar = Base64.getDecoder().decode(updatedUser.getAvatar());
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                // sino, se coge la ya existente
            } else {
                try {
                    newAvatar = Files.readAllBytes(Paths.get(updatedUser.getAvatar()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // si el avatar antiguo y el nuevo son distintos, ha cambiado la foto
            if (existingAvatar != newAvatar) {
                String filePath = "";
                if (newAvatar == null) {
                    try {
                        Files.deleteIfExists(Paths.get(existingUser.getAvatar()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    filePath = "uploads/avatars/default/default-avatar.jpg";
                    updatedUser.setAvatar(filePath);
                } else {
                    try {
                        Files.deleteIfExists(Paths.get(existingUser.getAvatar()));
                        filePath = "uploads/avatars/" + updatedUser.getUsername() + "." + "jpg";
                        try (FileOutputStream fos = new FileOutputStream(filePath)) {
                            fos.write(newAvatar);
                        }
                        updatedUser.setAvatar(filePath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            // si el avatar antiguo y el nuevo son iguales
            else {
                // si ha cambiado su username
                if (usernameChanged) {
                    String oldAvatarPath = "uploads/avatars/" + existingUser.getUsername() + ".jpg";
                    String newAvatarPath = "uploads/avatars/" + updatedUser.getUsername() + ".jpg";

                    try {
                        // renombramos el archivo
                        Files.move(Paths.get(oldAvatarPath), Paths.get(newAvatarPath),
                                StandardCopyOption.REPLACE_EXISTING);
                        // actualizar string del avatar en la bbdd
                        existingUser.setAvatar(newAvatarPath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                // si no ha cambiado ni username ni avatar
                else {

                }
            }
            // existingUser = updatedUser;
            existingUser.setAvatar(updatedUser.getAvatar());
            return userRepository.saveAndFlush(existingUser);
        } else {
            return null;
        }
    }

    @Transactional
    public String delete(Integer userID) {
        Login login = loginRepository.findByUserUserID(userID);
        loginService.delete(login.getLoginID());
        User user = userRepository.findByUserID(userID);
        userRepository.deleteById(userID);
        return "Deleted user: " + user.getUsername();
    }

    // función para verificar si una cadena es base64 válida
    public static boolean isValidBase64(String str) {
        return BASE64_PATTERN.matcher(str).matches();
    }
}
