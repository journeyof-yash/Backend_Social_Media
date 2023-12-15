package com.socialmedia.apisspringboot.Request;

import com.socialmedia.apisspringboot.Model.User;

public class CreateChatResponse {

    private Integer user2;

    public CreateChatResponse() {
    }

    public CreateChatResponse(Integer user2) {
        this.user2 = user2;
    }

    public Integer getUser2() {
        return user2;
    }

    public void setUser2(Integer user2) {
        this.user2 = user2;
    }
}
