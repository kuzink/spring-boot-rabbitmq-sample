package com.devglan.springbootrabbitmq.config;

import com.devglan.springbootrabbitmq.payload.MyMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private RabbitTemplate rabbitTemplate;
    private RabbitMQProperties rabbitMQProperties;

    public Producer(RabbitTemplate rabbitTemplate, RabbitMQProperties rabbitMQProperties) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitMQProperties = rabbitMQProperties;
    }

    //@Scheduled(fixedDelay = 3000L)
    public void send(){
        sendMessage(new MyMessage("type111", "msg111"));
    }

    public void sendMessage(MyMessage myMessage){
        rabbitTemplate.convertAndSend(rabbitMQProperties.getExchangeName(), "devglan.routingkey1", myMessage);
        System.out.println("Sent: " + myMessage);
    }
}
