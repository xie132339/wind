package com.wind.log.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wind.log.dto.ShowLog;

@FeignClient(value = "log-service")
public interface LogFacade {
    @RequestMapping("/insert")
    void insert(ShowLog log);
}
