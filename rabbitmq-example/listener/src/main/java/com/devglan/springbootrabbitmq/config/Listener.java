package com.devglan.springbootrabbitmq.config;

import com.devglan.springbootrabbitmq.payload.MyMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class Listener {

    @Value("${type}")
    String type;

    @Value("${words}")
    String[] words;

    private Producer producer;

    public Listener(Producer producer) {
        this.producer = producer;
    }


    public MyMessage generateResponseMsg() {
        return new MyMessage(type, words[new Random().nextInt(words.length)]);
    }

    @RabbitListener(queues="${rabbitmq.queueName}")
    public void listen(Message message) {
        System.out.println("Received: " + message.getPayload());
        producer.sendMessage(generateResponseMsg());
    }
}
