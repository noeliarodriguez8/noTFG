package com.memeov1.memeov1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.memeov1.memeov1.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    // getuser
    public User findByUserID(Integer userID);

    // buscar users
    public List<User> findTop10ByUsernameContainsIgnoreCase(String username);

    // buscar user por username o email
    public User findByUsernameOrEmail(String username, String email);

    // buscar ids de user por username que coincida
    @Query("SELECT u.userID FROM User u WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :username, '%'))")
    public List<Integer> findUserIDsByUsernameContainsIgnoreCase(@Param("username") String username);

    // listar seguidores
    @Query("SELECT f.fromUser FROM Follower f WHERE f.toUser.userID = :userID")
    public List<User> findFollowersByUserID(@Param("userID") Integer userID);

    // listar seguidos
    @Query("SELECT f.toUser FROM Follower f WHERE f.fromUser.userID = :userID")
    public List<User> findFollowingByUserID(@Param("userID") Integer userID);
}
