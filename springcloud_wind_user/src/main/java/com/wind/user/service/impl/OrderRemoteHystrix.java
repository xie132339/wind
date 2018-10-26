package com.wind.user.service.impl;

import org.springframework.stereotype.Component;

import com.wind.user.service.OrderRemote;

@Component
public class OrderRemoteHystrix implements OrderRemote {

    @Override
    public String getOrderPort() {
	return "order service 调用失败！";
    }

}
