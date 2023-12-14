package com.socialmedia.apisspringboot.Service;

import com.socialmedia.apisspringboot.Model.Story;
import com.socialmedia.apisspringboot.Model.User;

import java.util.List;

public interface StoryService {

    public Story createStory(Story story, User user) throws Exception;

    public List<Story> findStoryByUserId(Integer userId) throws Exception;

}
