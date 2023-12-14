package com.socialmedia.apisspringboot.Controller;

import com.socialmedia.apisspringboot.Model.Reel;
import com.socialmedia.apisspringboot.Model.User;
import com.socialmedia.apisspringboot.Service.ReelService;
import com.socialmedia.apisspringboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReelController {

    @Autowired
    private ReelService reelService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/reels")
    public Reel createReel(@RequestBody Reel reel, @RequestHeader("Authorization") String reqUser){

        User user = userService.findUserByJwt(reqUser);

        Reel createdReel = reelService.createReel(reel, user);

        return createdReel;
    }

    @GetMapping("/api/reels")
    public List<Reel> findAllReels(){

        List<Reel> reels = reelService.findAllReel();

        return reels;
    }

    @GetMapping("/api/reels/user/{userId}")
    public List<Reel> createReel(@PathVariable Integer userId) throws Exception {

        List<Reel> reels = reelService.findUserReel(userId);

        return reels;
    }
}
