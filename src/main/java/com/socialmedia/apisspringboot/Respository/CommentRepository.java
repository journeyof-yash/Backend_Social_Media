package com.socialmedia.apisspringboot.Respository;

import com.socialmedia.apisspringboot.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
