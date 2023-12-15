package com.socialmedia.apisspringboot.Controller;

import com.socialmedia.apisspringboot.Model.Chat;
import com.socialmedia.apisspringboot.Model.User;
import com.socialmedia.apisspringboot.Request.CreateChatResponse;
import com.socialmedia.apisspringboot.Service.ChatService;
import com.socialmedia.apisspringboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/chats")
    public Chat createChat(@RequestHeader("Authorization") String jwt,
                           @RequestBody CreateChatResponse req) throws Exception {

        User reqUser = userService.findUserByJwt(jwt);
        User user2 = userService.findUserById(req.getUser2());

        Chat chat = chatService.createChat(reqUser, user2);

        return chat;
    }

    @GetMapping("/api/chats")
    public List<Chat> findUsersChat(@RequestHeader("Authorization") String jwt){

        User user = userService.findUserByJwt(jwt);

        List<Chat> chats = chatService.findUsersChat(user.getId());

        return chats;
    }
}
