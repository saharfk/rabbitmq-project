package com.javatechie.rabbitmq.demo.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class BeanConfiguration {

    @Autowired
    RabbitConfig rabbitConfig;

    @Bean
    public DirectExchange getDirectExchange() {
        return new DirectExchange("log_ex", false, false);
    }

    @Bean("mainConnectionFactory")
    public ConnectionFactory mainConnectionFactory() throws Exception {
        return connectionFactory("172.18.63.37", 5672, "ussd_admin", "RabbitMQ2018");

    }

    private CachingConnectionFactory connectionFactory(String host, int port, String username, String password) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

    @Bean("mock")
    public RabbitTemplate getRabbitTemplate(@Qualifier("mainConnectionFactory") ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

}
