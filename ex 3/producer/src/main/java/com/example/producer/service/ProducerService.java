package com.example.producer.service;

import com.example.producer.config.ProducerConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {

    private final ProducerConfig config;
    private final RabbitTemplate template;
    private final List<String> wishes = List.of("удачи 1", "успехов 2", "счастья 3", "здоровья 4", "благополучия 5", "улыбок 6");

    public ProducerService(ProducerConfig config, RabbitTemplate template) {
        this.config = config;

        this.template = template;
    }

    public String sendMessage(String message) {
        for (String wish: wishes) {
            template.convertAndSend(config.getName(), message + " " + wish);
        }
        return "Message " + message + " was sent";
    }
}
