package com.memeov1.memeov1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.memeov1.memeov1.entities.Follower;
import com.memeov1.memeov1.entities.Post;
import com.memeov1.memeov1.entities.User;
import com.memeov1.memeov1.repositories.PostRepository;
import com.memeov1.memeov1.repositories.UserRepository;

@Service
public class PostService {

    public final PostRepository postRepository;
    public final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Post create(Post post) {
        return postRepository.saveAndFlush(post);
    }

    public List<Post> getPostsForCurrentUser(Integer userID) {
        List<Follower> following = userRepository.findByUserID(userID).getFollowing();
        List<User> toUserList = new ArrayList<>();
        for (Follower follower : following) {
            toUserList.add(follower.toUser);
        }
        return postRepository.findPostsByFollowingOrderByCreatedDatetimeDesc(toUserList);
    }

    // no sé si lo necesitamos
    // public Post read(Integer postID) {
    // return postRepository.findByPostID(postID);
    // }

    @Transactional
    public String delete(Integer postID) {
        Post post = postRepository.findByPostID(postID);
        postRepository.deleteById(postID);
        return "Deleted post: " + post.getPostID();
    }

}
