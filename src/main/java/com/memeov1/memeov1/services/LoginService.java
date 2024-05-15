package com.memeov1.memeov1.services;

import org.springframework.stereotype.Service;

import com.memeov1.memeov1.entities.Login;
import com.memeov1.memeov1.repositories.LoginRepository;

@Service
public class LoginService {

    public final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Login create(Login login) {
        return loginRepository.saveAndFlush(login);
    }

    public Login update(Integer loginID, Login updatedLogin) {
        Login existingLogin = loginRepository.findByLoginID(loginID);
        if (existingLogin != null) {
            existingLogin.setUsername(updatedLogin.getUsername());
            existingLogin.setPassword(updatedLogin.getPassword());
            return loginRepository.saveAndFlush(existingLogin);
        } else {
            return null;
        }
    }

    public String delete(Integer loginID) {
        Login login = loginRepository.findByLoginID(loginID);
        loginRepository.deleteById(loginID);
        return "Deleted user: " + login.getUsername();
    }
}
