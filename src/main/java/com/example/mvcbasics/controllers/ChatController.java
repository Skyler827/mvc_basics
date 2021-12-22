package com.example.mvcbasics.controllers;


import com.example.mvcbasics.entities.ChatMessage;
import com.example.mvcbasics.services.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller()
public class ChatController {
    private ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }
    @GetMapping("/chat")
    public String getChatPage(@ModelAttribute("newMessage") ChatMessage newMessage, Model model) {
        model.addAttribute("messages", chatService.getMessages());
        return "chat";
    }
    @PostMapping("/chat")
    public String postChatPage(@ModelAttribute("newMessage") ChatMessage newMessage, Model model) {
        chatService.postMessage(newMessage);
        model.addAttribute("messages", chatService.getMessages());
        return "chat";
    }
}
