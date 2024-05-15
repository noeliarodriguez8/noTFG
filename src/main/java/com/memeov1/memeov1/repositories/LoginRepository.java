package com.memeov1.memeov1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memeov1.memeov1.entities.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

    public Login findByLoginID(Integer loginID);

    public Login findByUserUserID(Integer userID);
}
