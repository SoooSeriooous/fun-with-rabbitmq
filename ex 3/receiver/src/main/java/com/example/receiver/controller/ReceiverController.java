package com.example.receiver.controller;

import com.example.receiver.service.ReceiverCache;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("receiver")
public class ReceiverController {

    private final ReceiverCache cache;

    public ReceiverController(ReceiverCache cache) {
        this.cache = cache;
    }

    @GetMapping
    public ResponseEntity<List<String>> readCache() {
        return ResponseEntity.ok(cache.read());
    }
}
