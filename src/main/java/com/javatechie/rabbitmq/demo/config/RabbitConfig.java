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
    @Value("${spring.rabbitmq.host}")
    private String HOST;
    @Value("${spring.rabbitmq.port}")
    private String PORT;
    @Value("${spring.rabbitmq.username}")
    private String USERNAME;
    @Value("${spring.rabbitmq.password}")
    private String PASSWORD;
    @Value("${rabbit.url}")
    private String rabbitUrl;

    @Override
    public String toString() {
        return "RabbitConfig{" +
                "QUEUE='" + QUEUE + '\'' +
                ", EXCHANGE='" + EXCHANGE + '\'' +
                ", ROUTING_KEY='" + ROUTING_KEY + '\'' +
                ", HOST='" + HOST + '\'' +
                ", PORT='" + PORT + '\'' +
                ", USERNAME='" + USERNAME + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", rabbitUrl='" + rabbitUrl + '\'' +
                '}';
    }

    public String getRabbitUrl() {
        return rabbitUrl;
    }

    public void setRabbitUrl(String rabbitUrl) {
        this.rabbitUrl = rabbitUrl;
    }

    public String getHOST() {
        return HOST;
    }

    public void setHOST(String HOST) {
        this.HOST = HOST;
    }

    public String getPORT() {
        return PORT;
    }

    public void setPORT(String PORT) {
        this.PORT = PORT;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

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
