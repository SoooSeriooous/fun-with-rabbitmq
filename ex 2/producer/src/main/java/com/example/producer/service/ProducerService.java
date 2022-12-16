package com.example.producer.service;

import com.example.producer.config.ProducerConfig;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private final ProducerConfig config;
    private final RabbitTemplate template;

    public ProducerService(ProducerConfig config, RabbitTemplate template) {
        this.config = config;

        this.template = template;
    }

    public String sendMessage(String message) {
        template.convertAndSend(config.getName(), message);
        return "Message " + message + " was sent";
    }
}
