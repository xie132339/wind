package com.wind.txlcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;

@SpringBootApplication
@EnableDistributedTransaction
@EnableDiscoveryClient
public class TxLcnApplication {
    public static void main(String[] args) {
	SpringApplication.run(TxLcnApplication.class, args);
    }
}
