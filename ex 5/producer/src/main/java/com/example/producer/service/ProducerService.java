package com.example.producer.service;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {

    private final DirectExchange directExchange;
    private final RabbitTemplate template;

    private final List<String> wishes = List.of("удачи", "успехов", "счастья", "здоровья", "благополучия", "улыбок");


    public ProducerService(DirectExchange directExchange, RabbitTemplate template) {
        this.directExchange = directExchange;
        this.template = template;
    }

    public String sendMessage(String message) {
        for (String wish: wishes) {
            template.convertAndSend(directExchange.getName(), wish, message + " " + wish);
        }
        return "Message " + message + " was sent";
    }
}
