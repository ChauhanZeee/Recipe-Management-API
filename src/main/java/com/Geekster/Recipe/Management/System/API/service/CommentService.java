package com.Geekster.Recipe.Management.System.API.service;

import com.Geekster.Recipe.Management.System.API.model.Comment;
import com.Geekster.Recipe.Management.System.API.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    ICommentRepository iCommentRepository;

    public Comment addComment(Comment comments) {
        return iCommentRepository.save(comments);
    }

    public List<Comment> getAllComments() {
        return iCommentRepository.findAll();
    }
}
