package com.memeov1.memeov1.requests;

import com.memeov1.memeov1.entities.Post;
import com.memeov1.memeov1.entities.User;

public class MemeLikeRequest {

    public Post post;
    public User user;

    public MemeLikeRequest(Post post, User user) {
        this.post = post;
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
