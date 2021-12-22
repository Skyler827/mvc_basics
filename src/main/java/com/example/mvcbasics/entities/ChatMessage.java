package com.example.mvcbasics.entities;

import com.example.mvcbasics.enums.ChatMessageType;

public class ChatMessage {
    private final String userName;
    private final String message;
    private final ChatMessageType type;

    public ChatMessage(String userName, String message, ChatMessageType type) {
        this.userName = userName;
        this.message = message;
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public String getMessage() {
        return message;
    }

    public ChatMessageType getType() {
        return type;
    }
}
