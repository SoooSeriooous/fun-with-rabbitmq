package com.example.receiver.controller;

import com.example.receiver.service.ConsumerCache;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("consumer")
public class ReceiverController {

    private final ConsumerCache cache;

    public ReceiverController(ConsumerCache cache) {
        this.cache = cache;
    }

    @GetMapping
    public ResponseEntity<List<String>> readCache() {
        return ResponseEntity.ok(cache.read());
    }
}
