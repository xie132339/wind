package com.wind.log.service;


import com.wind.log.service.fallback.UserServiceFallback;
import com.wind.user.service.UserFacade;

//@FeignClient(name = "user-service", fallback = UserServiceFallback.class)
public interface UserService extends UserFacade {

}
