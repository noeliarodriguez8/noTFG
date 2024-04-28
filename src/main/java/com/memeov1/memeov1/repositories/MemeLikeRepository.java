package com.memeov1.memeov1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memeov1.memeov1.entities.MemeLike;

public interface MemeLikeRepository extends JpaRepository<MemeLike, Integer> {

    // listar likes
    List<MemeLike> findMemeLikesByPostID(Integer postID);

}
