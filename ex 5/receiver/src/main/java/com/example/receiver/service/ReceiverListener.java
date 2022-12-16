package com.example.receiver.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "direct_q2")
@Component
public class ReceiverListener {

    private final ReceiverCache cache;

    public ReceiverListener(ReceiverCache cache) {
        this.cache = cache;
    }

    @RabbitHandler
    public void receive(String input) {
       cache.put(input);
    }
}
