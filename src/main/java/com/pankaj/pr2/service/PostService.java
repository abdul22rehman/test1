package com.pankaj.pr2.service;

import com.pankaj.pr2.entity.Post;
import com.pankaj.pr2.repository.CommentRepository;
import com.pankaj.pr2.repository.PostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private PostRepository postRepository;
   private CommentRepository commentRepository;

    public PostService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }


    public Post savespost(Post post) {
        Post save = postRepository.save(post);
        return save ;
    }


    public void deletepost() {
        postRepository.deleteById(3L);
    }
}
