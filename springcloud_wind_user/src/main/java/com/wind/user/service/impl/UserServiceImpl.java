package com.wind.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wind.user.dto.UserDTO;
import com.wind.user.mapper.UserMapper;
import com.wind.user.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserDTO record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(UserDTO record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public UserDTO selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserDTO record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserDTO record) {
        return userMapper.updateByPrimaryKey(record);
    }

}
