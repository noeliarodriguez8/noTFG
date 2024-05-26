package com.memeov1.memeov1.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
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

    // SUSTITUIR EL "jpg" por post.getMedia_type()
    @Transactional
    public Post create(Post post) {

        String filePath = "";

        Integer lastPostID = postRepository.findLastPostID();
        // si lo encuentra le suma 1, si no lo encuentra le asigna 1
        Integer newPostID = lastPostID != null ? lastPostID + 1 : 1;
        Post p = new Post(newPostID, post.getText_content());

        try {
            byte[] imagenBytes = Base64.getDecoder().decode(post.getMedia_file());
            String username = post.getUser().getUsername();
            // para crear la ruta de la carpeta del usuario
            String userFolderPath = "uploads/posts/" + username;
            File userFolder = new File(userFolderPath);
            if (!userFolder.exists()) {
                // crea la carpeta y todas las subcarpetas necesarias
                userFolder.mkdirs();
            }
            filePath = userFolderPath + "/" + username + "-" + p.getPostID() + "." + "png";
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                fos.write(imagenBytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.setMedia_file(filePath);
        p.setUser(post.getUser());
        return postRepository.saveAndFlush(p);
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

    // public String getMediaType(Post p) {
    // String media_file = p.getMedia_file();
    // String extension = media_file.substring(media_file.lastIndexOf(".") +
    // 1).toLowerCase();
    // switch (extension) {
    // case "jpg":
    // return "jpg";
    // case "jpeg":
    // return "jpeg";
    // case "png":
    // return "png";
    // default:
    // return "jpg";
    // }
    // }

}
