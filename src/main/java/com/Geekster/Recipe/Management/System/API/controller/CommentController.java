package com.Geekster.Recipe.Management.System.API.controller;

import com.Geekster.Recipe.Management.System.API.model.Comment;
import com.Geekster.Recipe.Management.System.API.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/v2/comments")
public class CommentController {

    @Autowired
    CommentService commentService;
    @PostMapping("/add/comments")
    public ResponseEntity<String> addComment(@Valid @RequestBody Comment comments) {
        Comment savedComment = commentService.addComment(comments);
        return new ResponseEntity<String>("add comments", HttpStatus.CREATED);
    }
    @GetMapping("/all/comments")
    public ResponseEntity<List<Comment>> allComments() {
        List<Comment> comments = commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }
}
