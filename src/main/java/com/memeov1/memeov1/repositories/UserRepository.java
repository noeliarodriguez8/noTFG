package com.memeov1.memeov1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memeov1.memeov1.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    // buscar users
    List<User> findByUsernameContainsIgnoreCase(String username);

    // listar seguidos/seguidores
    List<User> findAll();

    // recuento seguidos/seguidores -> en código
}
