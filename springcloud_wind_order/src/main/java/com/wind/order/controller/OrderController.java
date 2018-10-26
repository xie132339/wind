package com.wind.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Value("${server.port}")
    private String port;

    /**
     * 获取服务端口号
     * 
     * @return
     */
    @GetMapping("/getOrderPort")
    public String getOrderPort() {
	return "order-service port：" + port;
    }
}
