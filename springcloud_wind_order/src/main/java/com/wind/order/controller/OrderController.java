package com.wind.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/order")
@Api(tags = "订单")
public class OrderController {
    @Value("${server.port}")
    private String port;

    @Value("${start.info}")
    private String info;

    /**
     * 获取服务端口号
     * 
     * @return
     */
    @GetMapping("/getOrderPort")
    @ApiOperation(value = "订单测试")
    public String getOrderPort() {
        return "order-service port：" + port + "--" + info;
    }
}
