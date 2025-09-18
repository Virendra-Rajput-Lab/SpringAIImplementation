package com.springai.demo.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/chat")
public class ChatController {

    private ChatClient openAiChatClient;

    private ChatClient ollamaChatClient;

    public ChatController(@Qualifier("openAiChatModel") ChatClient openAiChatClient, ChatClient ollamaChatClient) {
        this.openAiChatClient = openAiChatClient;
        this.ollamaChatClient = ollamaChatClient;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public ResponseEntity<String> chat(@RequestParam(value="query") String query){
        var response = ollamaChatClient.prompt(query).call().content();
        System.out.println(response);
        return ResponseEntity.ok(response);
    }

}
