package com.wind.user.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wind.user.dto.UserDTO;

public interface UserFacade {
    @RequestMapping("/getUser")
    UserDTO getUser(@RequestParam("id") Long id);
}
