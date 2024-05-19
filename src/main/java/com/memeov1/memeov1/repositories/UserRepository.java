package com.memeov1.memeov1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.memeov1.memeov1.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    // getuser
    // no he usado el de por defecto porque daba error de Optional<User>
    // por la relación no especificada entre el service y el repositorio
    public User findByUserID(Integer userID);

    // buscar users
    public List<User> findByUsernameContainsIgnoreCase(String username);

    // buscar ids de user por username que coincida
    public List<Integer> findUserIDsByUsernameContainsIgnoreCase(String username);

    // listar seguidores
    @Query("SELECT f.fromUser FROM Follower f WHERE f.toUser.userID = :userID")
    public List<User> findFollowersByUserID(@Param("userID") Integer userID);

    // listar seguidos
    @Query("SELECT f.toUser FROM Follower f WHERE f.fromUser.userID = :userID")
    public List<User> findFollowingByUserID(@Param("userID") Integer userID);

    // recuento seguidos/seguidores -> en código
}
