package com.memeov1.memeov1.repositories;

import java.util.List;

import com.memeov1.memeov1.entities.Comment;
import com.memeov1.memeov1.entities.Post;

public interface CommunityRepository {

    // listar posts (perfil e inicio)
    List<Post> findPostsByUsername(String username); // en perfil

    List<Post> findPostsOrderByCreatedDateDesc(); // en inicio
    // !!!!!!!! MIRAR EL ORDEN ¿AGE?¿ORDERBY? ¿¿¿¿????

    // recuento posts (solo perfil) (en código)

    // listar comentarios
    List<Comment> findCommentsByPostID(Integer post_id);

    // recuento comentarios (en código)

    // listar likes
    List<Comment> findMemeLikesByPostID(Integer post_id);

    // recuento likes (en código)

}
