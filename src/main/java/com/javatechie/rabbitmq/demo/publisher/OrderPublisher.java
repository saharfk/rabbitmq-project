package com.javatechie.rabbitmq.demo.publisher;

import com.javatechie.rabbitmq.demo.config.RabbitConfig;
import com.javatechie.rabbitmq.demo.dto.Order;
import com.javatechie.rabbitmq.demo.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    public RabbitConfig rabbitConfig;

    @PostMapping("/hi")
    public String bookOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());

        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed successfully in ");
        template.convertAndSend(rabbitConfig.getQUEUE(), rabbitConfig.getROUTING_KEY(), orderStatus);
        return "Success !!";
    }
}
