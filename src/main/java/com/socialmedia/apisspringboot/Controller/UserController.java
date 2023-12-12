package com.socialmedia.apisspringboot.Controller;

import com.socialmedia.apisspringboot.Model.User;
import com.socialmedia.apisspringboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PutMapping("/api/updateUser")
    public User updateUser(@RequestHeader("Authorization")String jwt) throws Exception{

        User user = userService.findUserByJwt(jwt);

        User updatedUser = userService.updateUser(user,user.getId());

        return updatedUser;
    }

    @GetMapping("/api/user/{userId}")
    public User findUserById(@PathVariable Integer userId) throws Exception {

        User user = userService.findUserById(userId);

        return user;
    }

    @GetMapping("/api/user/email")
    public User findUserByEmail(@RequestParam("email") String email) throws Exception {

        User user = userService.findUserByEmail(email);

        return user;
    }

    @PutMapping("/api/users/{userId1}/{userId2}")
    public User followUser(@PathVariable Integer userId1, @PathVariable Integer userId2) throws Exception{

        User user = userService.followUser(userId1,userId2);

        return user;
    }

    @GetMapping("/api/users/search")
    public List<User> searchUser(@RequestParam("query") String query){

        List<User> users = userService.searchUser(query);

        return users;
    }

    @GetMapping("/api/users/profile")
    public User getUserFromToken(@RequestHeader("Authorization")String jwt){

        User user = userService.findUserByJwt(jwt);
        user.setPassword(null);
        return user;
    }
}
