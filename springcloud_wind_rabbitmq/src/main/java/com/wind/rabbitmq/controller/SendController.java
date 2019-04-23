package com.wind.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wind.rabbitmq.sender.DirectSender;
import com.wind.rabbitmq.sender.DistributionSender;
import com.wind.rabbitmq.sender.FanoutSender;
import com.wind.rabbitmq.sender.HeadersSender;
import com.wind.rabbitmq.sender.HelloSender;
import com.wind.rabbitmq.sender.HelloSender2;
import com.wind.rabbitmq.sender.TopicSender;
import com.wind.rabbitmq.sender.UserSender;

@RestController
public class SendController {
    @Autowired
    private HelloSender helloSender;
    @Autowired
    private HelloSender2 helloSender2;
    @Autowired
    private UserSender userSender;

    @Autowired
    private TopicSender topicSender;

    @Autowired
    private FanoutSender fanoutSender;

    @Autowired
    private DirectSender directSender;

    @Autowired
    private HeadersSender headersSender;

    @Autowired
    private DistributionSender distributionSender;

    @RequestMapping("/hello")
    public void hello1(@RequestParam("msg") String msg) {
	helloSender.send(msg);
    }

    @RequestMapping("/helloToNoe")
    public void helloToNoe(@RequestParam("msg") String msg) {
	for (int i = 0; i < 4; i++) {
	    helloSender.send(msg);
	}
    }

    @RequestMapping("/helloToMany")
    public void helloToMany(@RequestParam("msg") String msg) {
	for (int i = 0; i < 4; i++) {
	    helloSender.send(msg);
	    helloSender2.send(msg);
	}
    }

    @RequestMapping("/hello2")
    public void hello2(String msg) {
	helloSender2.send(msg);
    }

    @RequestMapping("/user")
    public void user(String msg) {
	userSender.send(msg);
    }

    /**
     * topic exchange类型rabbitmq测试
     */
    @GetMapping("/topicTest")
    public void topicTest() {
	topicSender.send();
    }

    /**
     * fanout exchange类型rabbitmq测试
     */
    @GetMapping("/fanoutTest")
    public void fanoutTest() {
	fanoutSender.send();
    }

    /**
     * direct exchange类型rabbitmq测试
     */
    @GetMapping("/directTest")
    public void directTest() {
	directSender.send();
    }

    /**
     * headers exchange类型rabbitmq测试
     */
    @GetMapping("/headersTest")
    public void headersTest() {
	headersSender.send();
    }

    /**
     * 分发机制消息发送测试
     */
    @GetMapping("/distribu")
    public void distribu() {
	for(int i=1; i<=5; i++) {
	    distributionSender.send(i);
	}
    }
}
