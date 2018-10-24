package com.wind.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class UserApplication {
    public static void main(String[] args) {
	SpringApplication.run(UserApplication.class, args);
    }
    
    //RestTemplate负载均衡
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
	return new RestTemplate();
    }
}
