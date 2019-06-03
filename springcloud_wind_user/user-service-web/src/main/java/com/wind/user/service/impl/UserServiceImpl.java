package com.wind.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wind.user.dto.UserDTO;
import com.wind.user.mapper.UserMapper;
import com.wind.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO getUser(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
