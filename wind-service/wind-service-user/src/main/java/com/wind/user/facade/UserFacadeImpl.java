package com.wind.user.facade;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

import com.wind.user.dto.UserDTO;
import com.wind.user.service.UserFacade;
import com.wind.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserService userService;
    @Autowired
    private DiscoveryClient client; // 服务发现客户端

    @Override
    public UserDTO getUser(Long id) throws Exception {
        List<String> services = client.getServices();
        List<ServiceInstance> instances = client.getInstances(services.get(0));
        int sleepTime = new Random().nextInt(2000);
        log.info("sleepTime:" + sleepTime);
        Thread.sleep(sleepTime);
        log.info("/getUser, host" + instances.get(0).getHost() + ", service_id:" + instances.get(0).getServiceId());
        return userService.getUser(id);
    }

}
