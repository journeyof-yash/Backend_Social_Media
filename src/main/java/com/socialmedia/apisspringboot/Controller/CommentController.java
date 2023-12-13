package com.socialmedia.apisspringboot.Controller;

import com.socialmedia.apisspringboot.Model.Comment;
import com.socialmedia.apisspringboot.Model.User;
import com.socialmedia.apisspringboot.Service.CommentService;
import com.socialmedia.apisspringboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.CallSite;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/comments/post/{postId}")
    public Comment createComment(@RequestBody Comment comment,
                                 @RequestHeader("Authorization") String jwt,
                                 @PathVariable("postId") Integer postId) throws Exception {

        User user = userService.findUserByJwt(jwt);

        Comment createdComment = commentService.createComment(comment, postId, user.getId());


        return createdComment;
    }

    @PutMapping("/api/comments/like/{commentId}")
    public Comment likeComment(@RequestHeader("Authorization") String jwt,
                                 @PathVariable("commentId") Integer commentId) throws Exception {

        User user = userService.findUserByJwt(jwt);

        Comment likedComment = commentService.likeComment(commentId, user.getId());


        return likedComment;
    }

    @GetMapping("/api/comments/{commentId}")
    public Comment getCommentById(@PathVariable Integer commentId) throws Exception {

        Comment comment = commentService.findCommentById(commentId);

        return comment;
    }
}
