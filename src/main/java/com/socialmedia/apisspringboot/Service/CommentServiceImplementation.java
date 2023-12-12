package com.socialmedia.apisspringboot.Service;

import com.socialmedia.apisspringboot.Model.Comment;
import com.socialmedia.apisspringboot.Model.Post;
import com.socialmedia.apisspringboot.Model.User;
import com.socialmedia.apisspringboot.Respository.CommentRepository;
import com.socialmedia.apisspringboot.Respository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentServiceImplementation implements CommentService{

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment createComment(Comment comment, Integer postId, Integer userId) throws Exception {

        Post post = postService.findPostById(postId);

        User user = userService.findUserById(userId);

        comment.setUser(user);
        comment.setContent(comment.getContent());
        comment.setCreatedAt(LocalDateTime.now());

        Comment savedComment = commentRepository.save(comment);

        post.getComments().add(savedComment);

        postRepository.save(post);

        return savedComment;
    }

    @Override
    public Comment findCommentById(Integer commentId) {
        return null;
    }

    @Override
    public Comment likeComment(Integer commentId, Integer userId) {
        return null;
    }
}
