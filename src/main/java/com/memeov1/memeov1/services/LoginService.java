package com.memeov1.memeov1.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.memeov1.memeov1.entities.Login;
import com.memeov1.memeov1.repositories.LoginRepository;

@Service
public class LoginService {

    public final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Transactional
    public Login create(Login login) {
        return loginRepository.saveAndFlush(login);
    }

    @Transactional
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

    @Transactional
    public String delete(Integer loginID) {
        Login login = loginRepository.findByLoginID(loginID);
        loginRepository.deleteById(loginID);
        return "Deleted user: " + login.getUsername();
    }
}
