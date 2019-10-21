package com.wind.log.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.wind.log.dto.ShowLog;

@Mapper
public interface LogMapper {
    int insert(ShowLog record);
}