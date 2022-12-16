package com.example.client.service;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TreeIgniterService {

    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange directExchange;

    public TreeIgniterService(RabbitTemplate rabbitTemplate, DirectExchange directExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    public String send(int i) {
        int randomInt = 0;
        if(i == 0) {
            Random random = new Random();
            randomInt = random.nextInt(10 - 1) + 1;
        }
        String response = (String) rabbitTemplate.convertSendAndReceive(directExchange.getName(), "rpc", randomInt);
        return "Request: " + randomInt + "; response: " + response;
    }
}
