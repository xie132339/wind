package com.wind.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wind.schedule.service.CalculatorService;

@RestController
@RequestMapping("/demo/feign")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/toadd")
    public int toadd(int a, int b) {
        int result = calculatorService.addService(a, b);
        return result;
    }
}
