package com.javatechie.rabbitmq.demo.publisher;

import com.javatechie.rabbitmq.demo.config.RabbitConfig;
import org.json.simple.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    public RabbitConfig rabbitConfig;

    @PostMapping("/hi")
    public String bookOrder(@RequestBody JSONObject order) {
        System.out.println("I am here");
        template.convertAndSend(rabbitConfig.getQUEUE(), rabbitConfig.getROUTING_KEY(), order);
        System.out.println("i am here 2");
        return "Success !!";
    }
}
