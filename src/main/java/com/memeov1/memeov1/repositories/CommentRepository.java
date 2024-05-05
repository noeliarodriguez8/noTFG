package com.memeov1.memeov1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memeov1.memeov1.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    // listar comentarios
    List<Comment> findCommentsByPostPostID(Integer postID);

    // recuento comentarios (en código)

}
