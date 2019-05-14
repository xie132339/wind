package com.wind.schedule.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "order-service")
public interface CalculatorService {

    @RequestMapping(value = "/order/add", method = RequestMethod.GET)
    int addService(@RequestParam("a") int a, @RequestParam("b") int b);
}
