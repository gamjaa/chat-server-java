package com.gamjaa.chat.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CHAT_ROOM")
public class ChatRoom {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

}
