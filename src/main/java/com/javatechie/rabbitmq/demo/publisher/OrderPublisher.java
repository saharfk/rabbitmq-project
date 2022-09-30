package com.javatechie.rabbitmq.demo.publisher;

import com.javatechie.rabbitmq.demo.config.RabbitConfig;
import org.json.simple.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rabbit")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    public RabbitConfig rabbitConfig;

    @PostMapping("/report")
    public String report(@RequestBody String inOut) {
        template.convertAndSend(rabbitConfig.getEXCHANGE(), rabbitConfig.getROUTING_KEY(), inOut);
        return "Success !!";
    }
}
