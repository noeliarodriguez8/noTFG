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

    // buscar user por username o email
    public User findByUsernameOrEmail(String username, String email);

    // buscar ids de user por username que coincida
    // necesito poner una query porque el método por convención de nombres de jpa no
    // accede bien a la propiedad userID
    // por lo que en el getconversations/username no devuelve bien los datos y da
    // error 500 porque no coincide el tipo de dato que espera con el que le
    // devuelven
    @Query("SELECT u.userID FROM User u WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :username, '%'))")
    public List<Integer> findUserIDsByUsernameContainsIgnoreCase(@Param("username") String username);

    // listar seguidores
    @Query("SELECT f.fromUser FROM Follower f WHERE f.toUser.userID = :userID")
    public List<User> findFollowersByUserID(@Param("userID") Integer userID);

    // listar seguidos
    @Query("SELECT f.toUser FROM Follower f WHERE f.fromUser.userID = :userID")
    public List<User> findFollowingByUserID(@Param("userID") Integer userID);

    // recuento seguidos/seguidores -> en código
}
