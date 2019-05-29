package com.wind.user.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wind.user.TableTest;
import com.wind.user.dto.UserDTO;


public class UserService extends TableTest {
    @Autowired
    private IUserService userService;

    @Test
    public void insert() {
        UserDTO record = new UserDTO();
        record.setLoginName("u");
        record.setLoginPassword("u");
        record.setNickname("管理员u");
        record.setRole(1L);
        userService.insertSelective(record);
    }

}
