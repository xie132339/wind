package com.wind.log.facade;

import org.springframework.web.bind.annotation.RequestMapping;

import com.wind.log.dto.ShowLog;

public interface LogFacade {
    @RequestMapping("/insert")
    void insert(ShowLog log);
}
