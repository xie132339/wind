package com.wind.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver1 {
    
    @RabbitHandler
    public void receiver(String msg) {
	System.out.println("Test hello:" + msg);
    }
}
