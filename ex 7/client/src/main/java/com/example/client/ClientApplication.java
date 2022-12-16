package com.example.client;

import com.example.client.config.TreeIgniterExchangeConfig;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication {
    private final TreeIgniterExchangeConfig exchangeConfig;

    public ClientApplication(TreeIgniterExchangeConfig exchangeConfig) {
        this.exchangeConfig = exchangeConfig;

    }

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchangeConfig.getName());
    }

}
