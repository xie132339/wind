package com.wind.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wind.log.service.UserService;
import com.wind.user.dto.UserDTO;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping("/getUser")
    public String getUser(@RequestParam("id") Long id) throws Exception {
        UserDTO u = userService.getUser(id);
        return u.toString();
    }
}
