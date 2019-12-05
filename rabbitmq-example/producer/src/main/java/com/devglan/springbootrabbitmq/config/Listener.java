package com.devglan.springbootrabbitmq.config;

import org.springframework.messaging.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @RabbitListener(queues="${rabbitmq.queueName}")
    public void listen(final Message message) {
        System.out.println("Received: " + message.getPayload());
    }
}
