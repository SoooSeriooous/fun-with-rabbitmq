package com.example.producer;

import com.example.producer.config.ProducerExchangeConfig;

import com.example.producer.config.ProducerQueueConfig;
import org.springframework.amqp.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducerApplication {

    private final ProducerExchangeConfig exchangeConfig;
    private final ProducerQueueConfig queueConfig;

    public ProducerApplication(ProducerExchangeConfig exchangeConfig, ProducerQueueConfig queueConfig) {
        this.exchangeConfig = exchangeConfig;
        this.queueConfig = queueConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Bean
    public DirectExchange direct() {
        return new DirectExchange(exchangeConfig.getName());
    }

    @Bean
    public Queue queue1() {
        return new Queue(queueConfig.getQueue1());
    }
    @Bean
    public Queue queue2() {
        return new Queue(queueConfig.getQueue2());
    }

    @Bean
    public Binding binding1(DirectExchange direct,
                            Queue queue1) {
        return BindingBuilder.bind(queue1).to(direct).with("удачи");
    }

    @Bean
    public Binding binding2a(DirectExchange direct,
                            Queue queue2) {
        return BindingBuilder.bind(queue2).to(direct).with("успехов");
    }

    @Bean
    public Binding binding2b(DirectExchange direct,
                            Queue queue2) {
        return BindingBuilder.bind(queue2).to(direct).with("здоровья");
    }
    @Bean
    public Binding binding2c(DirectExchange direct,
                             Queue queue2) {
        return BindingBuilder.bind(queue2).to(direct).with("благополучия");
    }

}
