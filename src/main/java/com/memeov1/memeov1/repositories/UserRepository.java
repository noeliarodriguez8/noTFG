package com.memeov1.memeov1.repositories;

import java.util.List;

import com.memeov1.memeov1.entities.User;

public interface UserRepository {

    // buscar users
    List<User> findByUsernameContainsIgnoreCase(String username);

    // listar seguidos/seguidores
    List<User> getUsers();

    // recuento seguidos/seguidores -> en código
}
