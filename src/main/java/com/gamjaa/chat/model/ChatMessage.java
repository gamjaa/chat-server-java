package com.gamjaa.chat.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "CHAT_MESSAGES")
public class ChatMessage {

	@Id
	@Column(name = "id")
	private Long id;

	@JoinColumn(name = "room_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
	private ChatRoom room;

	@JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
	private ChatUser user;

	@Column(name = "message", nullable = false)
	private String message;

}
