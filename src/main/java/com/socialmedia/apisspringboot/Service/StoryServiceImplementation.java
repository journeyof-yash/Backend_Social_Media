package com.socialmedia.apisspringboot.Service;

import com.socialmedia.apisspringboot.Model.Story;
import com.socialmedia.apisspringboot.Model.User;
import com.socialmedia.apisspringboot.Respository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StoryServiceImplementation implements StoryService{

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private UserService userService;

    @Override
    public Story createStory(Story story, User user) throws Exception {

        Story createStory = new Story();
        createStory.setCaptions(story.getCaptions());
        createStory.setImage(story.getImage());
        createStory.setUser(user);
        createStory.setTimeStamp(LocalDateTime.now());

        return storyRepository.save(createStory);
    }

    @Override
    public List<Story> findStoryByUserId(Integer userId) throws Exception {

        User user = userService.findUserById(userId);

        return storyRepository.findByUserId(userId);

    }
}
