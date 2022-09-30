package com.javatechie.rabbitmq.demo.consumer;

import org.json.simple.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class User {

    // log chizie k az saf grftim
    @RabbitListener(queues = "${rabbitmq.queue}")
    public JSONObject consumeMessageFromQueue(String log) {
        String url = "http://localhost:8081/rabbit/logging";
        RestTemplate restTemplate = new RestTemplate();
        JSONObject countries = restTemplate.postForObject(url, log, JSONObject.class);
        System.out.println("Message recieved from queue : " + log);
        return countries;
    }
}
