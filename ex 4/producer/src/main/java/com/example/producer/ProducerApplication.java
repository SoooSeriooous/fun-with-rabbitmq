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
    public FanoutExchange fanout() {
        return new FanoutExchange(exchangeConfig.getName());
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
    public Binding binding1(FanoutExchange fanout,
                            Queue queue1) {
        return BindingBuilder.bind(queue1).to(fanout);
    }

    @Bean
    public Binding binding2(FanoutExchange fanout,
                            Queue queue2) {
        return BindingBuilder.bind(queue2).to(fanout);
    }

}
