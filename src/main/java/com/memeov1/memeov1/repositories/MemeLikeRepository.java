package com.memeov1.memeov1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memeov1.memeov1.entities.MemeLike;
import com.memeov1.memeov1.entities.MemeLikePK;

public interface MemeLikeRepository extends JpaRepository<MemeLike, MemeLikePK> {

    // listar likes (no se verá en la app)
    public List<MemeLike> findMemeLikesByPostPostID(Integer postID);

    // encontrar memelike por memelikepk
    public MemeLike findMemeLikeByMemeLikePK(MemeLikePK memeLikePK);

    // borrar memelike por memelikepk
    public String deleteByMemeLikePK(MemeLikePK memeLikePK);

}
