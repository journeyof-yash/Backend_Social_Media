package com.socialmedia.apisspringboot.Controller;

import com.socialmedia.apisspringboot.Model.Message;
import com.socialmedia.apisspringboot.Model.User;
import com.socialmedia.apisspringboot.Service.MessageService;
import com.socialmedia.apisspringboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CreateMessage {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/messages/chat/{chatId}")
    public Message createMessage(@RequestBody Message req,
                                 @RequestHeader("Authorization") String jwt,
                                 @PathVariable Integer chatId) throws Exception {

        User user = userService.findUserByJwt(jwt);

        Message message = messageService.createMessage(user, chatId, req);

        return message;
    }

    @GetMapping("/api/messages/chat/{chatId}")
    public List<Message> findChatMessages(@RequestHeader("Authorization") String jwt,
                                          @PathVariable Integer chatId) throws Exception {

        User user = userService.findUserByJwt(jwt);

        List<Message> messages = messageService.findChatsMessages(chatId);

        return messages;
    }
}
