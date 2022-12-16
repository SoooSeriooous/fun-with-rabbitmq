package com.example.producer.service;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {

    private final FanoutExchange fanoutExchange;
    private final RabbitTemplate template;

    private final List<String> wishes = List.of("удачи", "успехов", "счастья", "здоровья", "благополучия", "улыбок");


    public ProducerService(FanoutExchange fanoutExchange, RabbitTemplate template) {
        this.fanoutExchange = fanoutExchange;
        this.template = template;
    }

    public String sendMessage(String message) {
        for (String wish: wishes) {
            template.convertAndSend(fanoutExchange.getName(), "", message + " " + wish);
        }
        return "Message " + message + " was sent";
    }
}
