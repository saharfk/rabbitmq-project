package com.javatechie.rabbitmq.demo.consumer;

import org.json.simple.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consumeMessageFromQueue(JSONObject orderStatus) {
        System.out.println("Message recieved from queue : " + orderStatus);
    }
}
