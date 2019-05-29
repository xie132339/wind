package com.wind.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wind.user.service.OrderRemote;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    OrderRemote orderRemote;
    @Value("${server.port}")
    String port;

    /**
     * 获取用户服务的端口
     * 
     * @return
     */
    @GetMapping("/getUserPort")
    public String getUserPort() {
        return "user-service port：" + port;
    }

    /**
     * 获取订单服务的端口
     * 
     * @return
     */
    @GetMapping("/getOrderPort")
    public String getOrderPort() {
        return "user-order-service port：" + orderRemote.getOrderPort();
    }

    @RequestMapping("/index")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
