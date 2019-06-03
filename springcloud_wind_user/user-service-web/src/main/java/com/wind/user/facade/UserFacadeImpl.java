package com.wind.user.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.wind.user.dto.UserDTO;
import com.wind.user.service.UserFacade;
import com.wind.user.service.UserService;

@RestController
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserService userService;

    @Override
    public UserDTO getUser(Long id) {
        return userService.getUser(id);
    }

}
