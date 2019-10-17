package com.wind.user.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wind.user.TableTest;
import com.wind.user.dto.UserDTO;

public class UserServiceTest extends TableTest {
    @Autowired
    private UserService userService;

    @Test
    public void getUser() {
        UserDTO userDTO = userService.getUser(2L);
        System.out.println(userDTO.toString());
    }
}
