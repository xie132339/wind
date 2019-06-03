package com.wind.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.wind.user.dto.UserDTO;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDTO record);

    int insertSelective(UserDTO record);

    UserDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDTO record);

    int updateByPrimaryKey(UserDTO record);
}