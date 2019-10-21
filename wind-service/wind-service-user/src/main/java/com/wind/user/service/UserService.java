package com.wind.user.service;

import org.springframework.web.bind.annotation.RequestParam;

import com.wind.user.dto.UserDTO;

public interface UserService {
    UserDTO getUser(@RequestParam("id") Long id);
}
