package com.example.mvcbasics.services;

import com.example.mvcbasics.entities.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {
    private final List<ChatMessage> messages;
    public ChatService() {
        messages = new ArrayList<>();
    }
    public void postMessage(ChatMessage newMessage) {
        messages.add(newMessage);
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }
}
