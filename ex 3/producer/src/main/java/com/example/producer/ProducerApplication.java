package com.example.producer;

import com.example.producer.config.ProducerConfig;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducerApplication {

    private final ProducerConfig config;

    public ProducerApplication(ProducerConfig config) {
        this.config = config;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Bean
    public Queue queue(){
        return new Queue(config.getName());
    }
}
