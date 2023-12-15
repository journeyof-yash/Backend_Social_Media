package com.socialmedia.apisspringboot.Service;

import com.socialmedia.apisspringboot.Model.Chat;
import com.socialmedia.apisspringboot.Model.User;

import java.util.List;

public interface ChatService {

    public Chat createChat(User reqUser, User user2);

    public Chat findChatById(Integer chatId) throws Exception;

    public List<Chat> findUsersChat(Integer userId);

}
