package com.pankaj.pr2.controller;

import com.pankaj.pr2.entity.Comment;
import com.pankaj.pr2.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Comments")
public class CommentController {
  private   CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
@PostMapping
    public ResponseEntity<Comment>createComment(@RequestBody Comment comment,@RequestParam Long postId){
        Comment savedcomments = commentService.savedcomments(comment, postId);
        return new ResponseEntity<>(savedcomments,HttpStatus.CREATED);


}
}

