package com.example.server;

import com.example.server.config.TreeIgniterExchangeConfig;
import com.example.server.config.TreeIgniterQueueConfig;
import com.example.server.service.TreeIgniter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApplication {

    private final TreeIgniterQueueConfig queueConfig;
    private final TreeIgniterExchangeConfig exchangeConfig;

    public ServerApplication(TreeIgniterQueueConfig queueConfig, TreeIgniterExchangeConfig exchangeConfig) {
        this.queueConfig = queueConfig;
        this.exchangeConfig = exchangeConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public Queue queue() {
        return new Queue(exchangeConfig.getName() + "." + queueConfig.getName());
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchangeConfig.getName());
    }

    @Bean
    public Binding binding(DirectExchange exchange,
                           Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("rpc");
    }

    @Bean
    TreeIgniter treeIgniter() {
        return new TreeIgniter();
    }

}
