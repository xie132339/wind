package com.wind.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.wind.user.service.impl.OrderRemoteHystrix;

@FeignClient(value = "order-service", fallback = OrderRemoteHystrix.class)
public interface OrderRemote {
    @GetMapping("/order/getOrderPort")
    String getOrderPort();
}
