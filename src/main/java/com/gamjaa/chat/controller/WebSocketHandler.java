package com.gamjaa.chat.controller;

import com.gamjaa.chat.packet.LoginReq;
import com.gamjaa.chat.packet.MessagePacket;
import com.gamjaa.chat.packet.MessagePacket.Type;
import com.gamjaa.chat.packet.SendReq;
import com.gamjaa.chat.service.ChatService;
import com.gamjaa.chat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

@RequiredArgsConstructor
public class WebSocketHandler extends BinaryWebSocketHandler {

    private final UserService userService;
    private final ChatService chatService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 연결됨
        super.afterConnectionEstablished(session);
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
        var user = userService.getConnectedUser(session);
        var packet = MessagePacket.parseFrom(message.getPayload());

        if (user == null) {
            if (packet.getType().equals(Type.LOGIN)) {
                var loginRequest = LoginReq.parseFrom(packet.getPayload());
                userService.login(session, loginRequest);
                return;
            }

            // TODO: 로그인 필요
            throw new Exception("로그인 필요");
        }

        // TODO: 타입별로 정해진 리스너가 처리하게 한다면?
        if (packet.getType().equals(Type.SEND)) {
            var sendRequest = SendReq.parseFrom(packet.getPayload());
            chatService.send(user, sendRequest);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // 연결 해제됨
        super.afterConnectionClosed(session, status);
    }

}
