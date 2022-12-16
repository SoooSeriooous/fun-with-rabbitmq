package com.example.client.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("tree-igniter.exchange")
@Getter
@Setter
public class TreeIgniterExchangeConfig {
    private String name;
}
