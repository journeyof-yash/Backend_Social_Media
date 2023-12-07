package com.socialmedia.apisspringboot.Controller;

import com.socialmedia.apisspringboot.Model.Post;
import com.socialmedia.apisspringboot.Response.ApiResponse;
import com.socialmedia.apisspringboot.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/posts/user/{userId}")
    public ResponseEntity<Post> createPost(@RequestBody Post post, @PathVariable Integer userId) throws Exception {

        Post createdPost = postService.createNewPost(post,userId);

        return new ResponseEntity<>(createdPost, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/posts/{postId}/user/{userId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception {

        String message = postService.deletePost(postId,userId);
        ApiResponse res = new ApiResponse(message,true);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<Post> findPostByHandler(@PathVariable Integer postId) throws Exception {

        Post post = postService.findPostById(postId);

        return new ResponseEntity<>(post, HttpStatus.ACCEPTED);
    }

    @GetMapping("/posts/user/{userId}")
    public ResponseEntity<List<Post>> findUsersPost(@PathVariable Integer userId) throws Exception {

        List<Post> posts = postService.findPostByUserId(userId);

        return new ResponseEntity<>(posts,HttpStatus.OK);

    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> findAllPost(){

        List<Post> posts = postService.findAllPost();

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/user/{userId}")
    public ResponseEntity<Post> savedPost(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception {

        Post post = postService.savedPost(postId,userId);

        return new ResponseEntity<>(post, HttpStatus.ACCEPTED);
    }

    @PutMapping("/posts/like/{postId}/user/{userId}")
    public ResponseEntity<Post> LikedPost(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception {

        Post post = postService.likePost(postId,userId);

        return new ResponseEntity<>(post, HttpStatus.ACCEPTED);
    }


}
