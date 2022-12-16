package com.example.message_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageController {

    @GetMapping()
    public ResponseEntity<String> createMessage(@RequestParam final String message) {
        return ResponseEntity.ok("I get the message: " + message);
    }
}
