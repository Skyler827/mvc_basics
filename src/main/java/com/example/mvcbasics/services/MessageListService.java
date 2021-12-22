package com.example.mvcbasics.services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageListService {
    private List<String> messages;

    @PostConstruct
    public void postConstruct() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(String newMessage) {
        this.messages.add(newMessage);
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }
}
