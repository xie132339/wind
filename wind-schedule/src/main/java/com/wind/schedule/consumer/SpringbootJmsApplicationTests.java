package com.wind.schedule.consumer;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;

public class SpringbootJmsApplicationTests {
    @Autowired
    private Producer producer;

    public void contextLoads() throws InterruptedException {
	Destination destination = new ActiveMQQueue("mytest.queue");
	for (int i = 0; i < 100; i++) {
	    producer.sendMessage(destination, "myname is chhliu!!!");
	}
    }
    
}
