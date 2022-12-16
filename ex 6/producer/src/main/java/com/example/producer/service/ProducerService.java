package com.example.producer.service;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {

    private final TopicExchange topicExchange;
    private final RabbitTemplate template;

    private final List<String> wishes = List.of("удачи", "успехов", "счастья", "здоровья", "благополучия", "улыбок");
    private final String topicStart = "поздравляю.желаю.";


    public ProducerService(TopicExchange topicExchange, RabbitTemplate template) {
        this.topicExchange = topicExchange;
        this.template = template;
    }

    public String sendMessage(String message) {
        for (String wish: wishes) {
            String topic = topicStart + wish;
            template.convertAndSend(topicExchange.getName(), topic, message + " " + wish);
        }
        return "Message " + message + " was sent";
    }
}
