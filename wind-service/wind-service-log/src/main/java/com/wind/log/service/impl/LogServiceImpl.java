package com.wind.log.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wind.log.dto.ShowLog;
import com.wind.log.mapper.LogMapper;
import com.wind.log.service.LogService;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public void insert(ShowLog log) {
        logMapper.insert(log);
    }

}
