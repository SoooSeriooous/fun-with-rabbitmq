package com.example.producer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties("producer.exchange")
@Getter
@Setter
public class ProducerExchangeConfig {
    private String name;
}
