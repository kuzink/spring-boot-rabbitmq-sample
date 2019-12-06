package com.devglan.springbootrabbitmq.config;

import com.devglan.springbootrabbitmq.payload.MyMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private RabbitTemplate rabbitTemplate;
    private RabbitMQProperties rabbitMQProperties;

    public Producer(RabbitTemplate rabbitTemplate, RabbitMQProperties rabbitMQProperties) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitMQProperties = rabbitMQProperties;
    }

    public void sendMessage(MyMessage myMessage){
        rabbitTemplate.convertAndSend(rabbitMQProperties.getExchangeName(), "kuzin.routingkey1", myMessage);
        System.out.println("Sent: " + myMessage);
    }
}
