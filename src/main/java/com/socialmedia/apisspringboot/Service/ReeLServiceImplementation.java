package com.socialmedia.apisspringboot.Service;

import com.socialmedia.apisspringboot.Model.Reel;
import com.socialmedia.apisspringboot.Model.User;
import com.socialmedia.apisspringboot.Respository.ReelRepository;
import com.socialmedia.apisspringboot.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReeLServiceImplementation implements ReelService{

    @Autowired
    private ReelRepository reelRepository;

    @Autowired
    private UserService userService;

    @Override
    public Reel createReel(Reel reel, User user) {

        Reel createReel = new Reel();
        createReel.setTitle(reel.getTitle());
        createReel.setUser(user);
        createReel.setVideo(reel.getVideo());

        return reelRepository.save(createReel);
    }

    @Override
    public List<Reel> findAllReel() {

        return reelRepository.findAll();
    }

    @Override
    public List<Reel> findUserReel(Integer userId) throws Exception {
        userService.findUserById(userId);
        return reelRepository.findByUserId(userId);
    }
}
