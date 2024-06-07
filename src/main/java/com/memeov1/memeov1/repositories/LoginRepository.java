package com.memeov1.memeov1.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memeov1.memeov1.entities.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

    public Login findByLoginID(Integer loginID);

    public Login findByUserUserID(Integer userID);

    public Optional<Login> findByUsername(String username);
}
