package com.example.sender_service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "message", url = "localhost:8080")
public interface MessageClient {

    @GetMapping(value = "/message")
    String getMessage(@RequestParam String message);
}
