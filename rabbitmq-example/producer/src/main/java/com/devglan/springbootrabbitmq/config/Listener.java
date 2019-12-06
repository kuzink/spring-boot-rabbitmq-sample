package com.devglan.springbootrabbitmq.config;

import com.devglan.springbootrabbitmq.payload.MyMessage;
import org.springframework.messaging.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class Listener {

    private List<String> verbList = new ArrayList<>();
    private List<String> nounList = new ArrayList<>();

    @RabbitListener(queues = "${rabbitmq.queueName}")
    public void listen(Message message) {
        //System.out.println("Received: " + message.getPayload());
        MyMessage myMessage = (MyMessage) message.getPayload();
        String type = myMessage.getType();
        switch (type) {
            case ("verb"):
                verbList.add(myMessage.getMsg());
                break;
            case ("noun"):
                nounList.add(myMessage.getMsg());
                break;
            default:
                break;
        }
        printSentence();
    }

    private void printSentence(){
        if (!verbList.isEmpty() && !nounList.isEmpty()){
            System.out.println(verbList.get(0) + " " + nounList.get(0));
            verbList.clear();
            nounList.clear();
        }
    }
}
