package com.socialmedia.apisspringboot.Service;

import com.socialmedia.apisspringboot.Model.Reel;
import com.socialmedia.apisspringboot.Model.User;

import java.util.List;

public interface ReelService {

    public Reel createReel(Reel reel, User user);

    public List<Reel> findAllReel();

    public List<Reel> findUserReel(Integer userId) throws Exception;

}
