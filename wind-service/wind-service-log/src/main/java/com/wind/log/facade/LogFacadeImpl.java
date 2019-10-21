package com.wind.log.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wind.log.dto.ShowLog;
import com.wind.log.service.LogService;

@RequestMapping
public class LogFacadeImpl implements LogService {
    @Autowired
    private LogService logService;

    @Override
    public void insert(ShowLog log) {
        logService.insert(log);
    }

}
