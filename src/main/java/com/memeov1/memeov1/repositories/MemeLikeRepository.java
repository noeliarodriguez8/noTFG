package com.memeov1.memeov1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memeov1.memeov1.entities.MemeLike;
import com.memeov1.memeov1.entities.MemeLikePK;

public interface MemeLikeRepository extends JpaRepository<MemeLike, MemeLikePK> {

    // listar likes
    List<MemeLike> findMemeLikesByPostPostID(Integer postID);

}
