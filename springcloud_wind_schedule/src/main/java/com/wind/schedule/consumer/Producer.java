package com.wind.schedule.consumer;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service("producer")
public class Producer {
    @Autowired // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
    private JmsMessagingTemplate jmsTemplate;

    public void sendMessage(Destination destination, final String message) {
	// 发送消息，destination是发送到的队列，message是待发送的消息
	jmsTemplate.convertAndSend(destination, message);
    }
    
    @JmsListener(destination = "out.queue")
    public void consumerMessage(String text) {
	System.out.println("out queue返回消息：" + text);
    }
}
