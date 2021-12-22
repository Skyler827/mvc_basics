package com.example.mvcbasics.controllers;

import com.example.mvcbasics.services.MessageListService;
import com.example.mvcbasics.entities.MessageForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private MessageListService messageListService;

    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping("/")
    public String getHomePage(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
        model.addAttribute("welcomeMessage","yo shit waddup");
        model.addAttribute("greetings",messageListService.getMessages());
        return "home";
    }
    @PostMapping("/")
    public String getHomePagePost(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
        messageListService.addMessage(newMessage.getText());
        model.addAttribute("welcomeMessage","yo shit waddup");
        model.addAttribute("greetings",messageListService.getMessages());
        newMessage.setText("");
        return "home";
    }
}
