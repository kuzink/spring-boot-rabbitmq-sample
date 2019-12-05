package com.devglan.springbootrabbitmq.config;

import com.devglan.springbootrabbitmq.payload.MyMessage;
import org.springframework.messaging.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    private Producer producer;

    public Listener(Producer producer) {
        this.producer = producer;
    }

    @RabbitListener(queues="${rabbitmq.queueName}")
    public void listen(final Message message) {
        System.out.println("Received: " + message.getPayload());

        MyMessage myMessage = (MyMessage) message.getPayload();
        myMessage.setType(myMessage.getType() + "resend");
        myMessage.setMsg(myMessage.getMsg() + "resend");
        producer.sendMessage(myMessage);
    }
}
