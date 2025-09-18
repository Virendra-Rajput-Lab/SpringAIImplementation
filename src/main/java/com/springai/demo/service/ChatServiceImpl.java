package com.springai.demo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{

    private ChatClient chatClient;

    public ChatServiceImpl(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    @Override
    public String chat(String query) {
        Prompt prompt = new Prompt(query);
        return chatClient
                .prompt(prompt)
                .call()
                .content();
    }
}
