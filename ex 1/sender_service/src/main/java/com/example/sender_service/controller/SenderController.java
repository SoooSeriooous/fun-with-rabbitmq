package com.example.sender_service.controller;

import com.example.sender_service.clients.MessageClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sender")
public class SenderController {
    private final MessageClient messageClient;

    public SenderController(MessageClient messageClient) {
        this.messageClient = messageClient;
    }

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        String recievedMessage = messageClient.getMessage(message);
        return ResponseEntity.ok(recievedMessage);
    }
}
