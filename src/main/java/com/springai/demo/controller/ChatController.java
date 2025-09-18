package com.springai.demo.controller;

import com.springai.demo.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/chat")
public class ChatController {

    private ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public ResponseEntity<String> chat(@RequestParam(value="query") String query){
        String response = chatService.chat(query);
        return ResponseEntity.ok(response);
    }

}
