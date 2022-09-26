package com.javatechie.rabbitmq.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("RabbitConfig")
public class RabbitConfig {
    @Value("${rabbitmq.queue}")
    private String QUEUE;
    @Value("${rabbitmq.exchange}")
    private String EXCHANGE;
    @Value("${rabbitmq.routingkey}")
    private String ROUTING_KEY;

    public String getQUEUE() {
        return QUEUE;
    }

    public void setQUEUE(String QUEUE) {
        this.QUEUE = QUEUE;
    }

    public String getEXCHANGE() {
        return EXCHANGE;
    }

    public void setEXCHANGE(String EXCHANGE) {
        this.EXCHANGE = EXCHANGE;
    }

    public String getROUTING_KEY() {
        return ROUTING_KEY;
    }

    public void setROUTING_KEY(String ROUTING_KEY) {
        this.ROUTING_KEY = ROUTING_KEY;
    }
}
