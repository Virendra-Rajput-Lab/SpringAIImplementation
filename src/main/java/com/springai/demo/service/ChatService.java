package com.springai.demo.service;

import org.springframework.stereotype.Service;

@Service
public interface ChatService {
    public String chat(String query);
}
