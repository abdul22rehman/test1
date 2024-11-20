package com.pankaj.pr2.controller;

import com.pankaj.pr2.entity.Post;
import com.pankaj.pr2.repository.CommentRepository;
import com.pankaj.pr2.repository.PostRepository;
import com.pankaj.pr2.service.PostService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Posts")
public class PostController {
   private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

@PostMapping
public ResponseEntity<Post> createpost(@RequestBody Post post){
    Post savespost = postService.savespost(post);

    return new ResponseEntity<>(savespost, HttpStatus.CREATED);
}


@DeleteMapping
    public String deletepost()
    {
        postService.deletepost();
        return "Deleted";
}



}




