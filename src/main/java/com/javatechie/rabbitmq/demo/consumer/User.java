package com.javatechie.rabbitmq.demo.consumer;


import com.javatechie.rabbitmq.demo.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class User {
    private final static Logger LOGGER = LoggerFactory.getLogger(User.class);
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    RabbitConfig rabbitConfig;

    // log chizie k az saf grftim
    @RabbitListener(queues = "#{queue.name}")
    public void consumeMessageFromQueue(String log) {
        LOGGER.debug("message receive from rabbit");
        String url = rabbitConfig.getRabbitUrl();
        System.out.println(log);
        HttpEntity<String> request = new HttpEntity<>(log);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        System.out.println("response is : " + response);
        System.out.println("Message received from queue : " + log);
    }
}
