package com.javatechie.rabbitmq.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
@ComponentScan
public class BeanConfiguration {

    @Autowired
    RabbitConfig rabbitConfig;

    @Bean
    public DirectExchange getDirectExchange() {
        return new DirectExchange("parsaaa", false, false);
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

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(rabbitConfig.getROUTING_KEY());
    }

    @Bean("queue")
    public Queue queue() {
        return new Queue(rabbitConfig.getQUEUE());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }
}
