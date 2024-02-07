package com.gamjaa.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamjaa.chat.model.ChatMessage;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}
