package com.wind.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RabbitApplication {
    public static void main(String[] args) {
	SpringApplication.run(RabbitApplication.class, args);
    }
}
