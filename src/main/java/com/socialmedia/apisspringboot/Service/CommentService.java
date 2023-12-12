package com.socialmedia.apisspringboot.Service;

import com.socialmedia.apisspringboot.Model.Comment;

public interface CommentService {

    public Comment createComment(Comment comment,
                                 Integer postId,
                                 Integer userId) throws Exception;

    public Comment findCommentById(Integer commentId);

    public Comment likeComment(Integer commentId, Integer userId);
}
