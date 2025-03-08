package com.group.ecommerce_backend_springboot.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.ecommerce_backend_springboot.model.Comment;
import com.group.ecommerce_backend_springboot.repository.CommentRepository;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Optional<Comment> getCommentById(ObjectId id) {
        return commentRepository.findById(id);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public void deleteCommentById(ObjectId id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent()) commentRepository.deleteById(id);
        else throw new RuntimeException("Comment not found!");
    }
}
