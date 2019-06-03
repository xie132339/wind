package com.wind.log.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.wind.user.service.UserFacade;

@FeignClient("user-service")
public interface UserService extends UserFacade {

}
