package com.gamjaa.chat.controller;

import com.gamjaa.chat.packet.LoginReq;
import com.gamjaa.chat.packet.MessagePacket;
import com.gamjaa.chat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

@RequiredArgsConstructor
public class WebSocketHandler extends BinaryWebSocketHandler {

    private final UserService userService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 연결됨
        super.afterConnectionEstablished(session);
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
        var user = userService.getUser(session);
        var packet = MessagePacket.parseFrom(message.getPayload());

        if (user == null) {
            if (packet.getType().equals(MessagePacket.Type.LOGIN)) {
                var loginRequest = LoginReq.parseFrom(packet.getPayload());
                userService.login(session, loginRequest);
                return;
            }

            // TODO: 로그인 필요
            throw new Exception("로그인 필요");
        }

        
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // 연결 해제됨
        super.afterConnectionClosed(session, status);
    }

}
