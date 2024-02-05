package com.gamjaa.chat.service;

import com.gamjaa.chat.model.ChatUser;
import com.gamjaa.chat.packet.LoginReq;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final Map<String, ChatUser> sessionUserMap = new HashMap<>();

    public ChatUser getUser(WebSocketSession session) {
        return sessionUserMap.get(session.getId());
    }

    public void login(WebSocketSession session, LoginReq req) {
        // TODO: 계정 가져오기
        var user = new ChatUser();

        sessionUserMap.put(session.getId(), user);
    }

    public void logout(WebSocketSession session) {
        sessionUserMap.remove(session.getId());
    }

}
