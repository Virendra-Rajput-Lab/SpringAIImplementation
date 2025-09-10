package com.springai.demo.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.1/chat")
public class ChatController {

    private ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping("/")
    public ResponseEntity<String> chat(@RequestParam(value="query") String query){
        var response = chatClient.prompt(query).call().content();
        return ResponseEntity.ok(response);
    }

}
