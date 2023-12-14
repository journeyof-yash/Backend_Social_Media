package com.socialmedia.apisspringboot.Respository;

import com.socialmedia.apisspringboot.Model.Story;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoryRepository extends JpaRepository<Story, Integer> {

    public List<Story> findByUserId(Integer userId);

}
