package com.gamjaa.chat.service;

import com.gamjaa.chat.model.ChatUser;
import com.gamjaa.chat.packet.JoinReq;
import com.gamjaa.chat.packet.LeaveReq;
import com.gamjaa.chat.packet.SendReq;

public class ChatService {

	public void join(ChatUser user, JoinReq req) {

	}

	public void leave(ChatUser user, LeaveReq req) {

	}

	public void send(ChatUser user, SendReq req) {
		// DB에 메시지 저장
		// 접속된 유저에게 전송
	}

}
