package com.memeov1.memeov1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.memeov1.memeov1.entities.Post;
import com.memeov1.memeov1.entities.User;

public interface PostRepository extends JpaRepository<Post, Integer> {

    // listar posts (perfil)
    List<Post> findPostsByUserUsername(String username);

    // listar posts (feed)
    @Query("SELECT p FROM Post p WHERE p.user IN (:following) ORDER BY p.createdDatetime DESC")
    List<Post> findPostsByFollowingOrderByCreatedDatetimeDesc(@Param("following") List<User> following);

    // encontrar post por id
    public Post findByPostID(Integer postID);

    // encontrar último id de las conversations
    @Query("SELECT MAX(p.postID) FROM Post p")
    public Integer findLastPostID();

}
