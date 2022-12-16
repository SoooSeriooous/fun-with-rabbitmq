package com.example.server.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("tree-igniter.queue")
@Getter
@Setter
public class TreeIgniterQueueConfig {
    private String name;
}
