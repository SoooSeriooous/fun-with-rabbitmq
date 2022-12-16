package com.example.receiver.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "second_queue")
@Component
public class ConsumerListener {

    private final ConsumerCache cache;

    public ConsumerListener(ConsumerCache cache) {
        this.cache = cache;
    }

    @RabbitHandler
    public void receive(String input) {
       cache.put(input);
    }
}
