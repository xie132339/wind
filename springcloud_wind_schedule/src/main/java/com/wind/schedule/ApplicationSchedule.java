package com.wind.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//开启Feign功能
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ApplicationSchedule {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationSchedule.class, args);
    }
}
