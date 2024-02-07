package com.gamjaa.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamjaa.chat.model.ChatUser;

public interface ChatUserRepository extends JpaRepository<ChatUser, Long> {

}
