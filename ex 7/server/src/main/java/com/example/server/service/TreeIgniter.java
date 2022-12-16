package com.example.server.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;


public class TreeIgniter {
    @RabbitListener(queues = "tree.rpc.igniter")
    public String click(int i) {
        if(i % 2 == 0) {
            return "Елочка горит!";
        } else {
            return "Елочка не горит! =(";
        }
    }
}
