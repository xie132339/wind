package com.wind.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloError")
    public String helloService() {
        return restTemplate.getForEntity("http://user-service/hello", String.class).getBody();
    }

    public String helloError() {
        return "hello error";
    }

}
