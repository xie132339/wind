package com.wind.order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/order")
@Api(tags = "订单")
public class OrderController {
    private final Logger log = LoggerFactory.getLogger(OrderController.class);
    @Value("${server.port}")
    private String port;

    @Value("${start.info}")
    private String info;

    @Value("${host.ifs}")
    private String ifs;

    /**
     * 获取服务端口号
     * 
     * @return
     */
    @GetMapping("/getOrderPort")
    @ApiOperation(value = "订单测试")
    public String getOrderPort() {
        log.debug("测试 id: {} and port: {}", port, info);
        return "order-service port：" + port + "--" + info + "ifs" + ifs;
    }

    @GetMapping("/add")
    public int add(int a, int b) {
        int result = a + b;
        return result;
    }
}
