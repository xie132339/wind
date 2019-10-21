package com.wind.fileoperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FileOperationApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileOperationApplication.class, args);
    }
}
