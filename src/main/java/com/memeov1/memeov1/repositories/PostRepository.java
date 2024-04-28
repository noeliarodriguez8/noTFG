package com.memeov1.memeov1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memeov1.memeov1.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

    // listar posts (perfil e inicio)
    List<Post> findPostsByUsername(String username); // en perfil

    List<Post> findPostsOrderByCreatedDateDesc(); // en inicio
    // !!!!!!!! MIRAR EL ORDEN ¿AGE?¿ORDERBY? ¿¿¿¿????

    // recuento posts (solo perfil) (en código)

    // recuento likes (en código)

}
