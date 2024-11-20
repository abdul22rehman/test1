package com.pankaj.pr2.service;

import com.pankaj.pr2.entity.Comment;
import com.pankaj.pr2.entity.Post;
import com.pankaj.pr2.repository.CommentRepository;
import com.pankaj.pr2.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    private CommentRepository commentRepository;
private PostRepository postRepository;
    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }


 public Comment savedcomments(Comment comment,Long postId) {
     Post post = postRepository.findById(postId).get();
     comment.setPost(post);
     Comment save = commentRepository.save(comment);
     return save;

 }
}
