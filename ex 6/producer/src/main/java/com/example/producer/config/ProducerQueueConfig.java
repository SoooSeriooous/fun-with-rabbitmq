package com.example.producer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("producer.queue")
@Getter
@Setter
public class ProducerQueueConfig {
    private String queue1;
    private String queue2;
}

