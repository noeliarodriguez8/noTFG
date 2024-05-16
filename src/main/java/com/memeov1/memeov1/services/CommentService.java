package com.memeov1.memeov1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.memeov1.memeov1.entities.Comment;
import com.memeov1.memeov1.repositories.CommentRepository;

@Service
public class CommentService {

    public final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment create(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }

    public List<Comment> getCommentsFromPost(Integer postID) {
        return commentRepository.findCommentsByPostPostID(postID);
    }

    public String delete(Integer commentID) {
        Comment comment = commentRepository.findByCommentID(commentID);
        commentRepository.deleteById(commentID);
        return "Deleted comment: " + comment.getText_content();
    }

}
