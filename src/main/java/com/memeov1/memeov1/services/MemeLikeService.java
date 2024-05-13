package com.memeov1.memeov1.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.memeov1.memeov1.entities.MemeLike;
import com.memeov1.memeov1.entities.MemeLikePK;
import com.memeov1.memeov1.repositories.MemeLikeRepository;

@Service
public class MemeLikeService {

    public final MemeLikeRepository memeLikeRepository;

    public MemeLikeService(MemeLikeRepository memeLikeRepository) {
        this.memeLikeRepository = memeLikeRepository;
    }

    public MemeLike create(MemeLike memeLike) {
        return memeLikeRepository.saveAndFlush(memeLike);
    }

    @Transactional
    // para asegurarse de que las operaciones de base de datos que se realizan
    // dentro de ese método se ejecuten dentro de una transacción adecuada
    // conjunto de operaciones que se realizan como una unidad atómica e
    // indivisible. Esto significa que o bien todas las operaciones dentro de la
    // transacción se completan con éxito, o ninguna de ellas tiene efecto en la
    // base de datos
    public String delete(MemeLikePK memeLikePK) {
        // MemeLike memeLike = memeLikeRepository.findMemeLikeByMemeLikePK(memeLikePK);
        memeLikeRepository.deleteByMemeLikePK(memeLikePK);
        return "Deleted meme-like from post " + memeLikePK.getPostID() + " and user " + memeLikePK.getUserID();
    }

}
