package com.wind.rabbitmq.receiver;

import java.io.IOException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
public class UserReceiver {
    @RabbitListener(queues = "user")
    public void process(Message message, Channel channel) throws IOException {
	System.out.println("UserReceiver  : " + new String(message.getBody()));
    }
}
