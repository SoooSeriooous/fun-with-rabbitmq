package com.example.client.controller;

import com.example.client.service.TreeIgniterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("igniter")
public class TreeIgniterController {
    private final TreeIgniterService service;

    public TreeIgniterController(TreeIgniterService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<String> ignite(@RequestParam(required = false, defaultValue = "0") int randomInt) {
        return ResponseEntity.ok(service.send(randomInt));
    }
}
