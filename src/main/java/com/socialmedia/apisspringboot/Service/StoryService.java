package com.socialmedia.apisspringboot.Service;

import com.socialmedia.apisspringboot.Model.Story;

import java.util.List;

public interface StoryService {

    public Story createStory(Story story, Integer userId);

    public List<Story> findStoryByUserId(Integer userId);

}
