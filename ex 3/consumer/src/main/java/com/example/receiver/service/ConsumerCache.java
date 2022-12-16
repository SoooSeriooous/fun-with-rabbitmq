package com.example.receiver.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConsumerCache {
    private final List<String> cache = new ArrayList<>();

    public void put(String elem) {
        this.cache.add(elem);
    }

    public List<String> read() {
        return cache;
    }


}
