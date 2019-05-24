package com.wind.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wind.log.dto.ShowLog;
import com.wind.log.service.LogService;

@RunWith(SpringRunner.class)
@SpringBootTest // 指定启动类
public class Tests {
    @Autowired
    private LogService logService;

    @Test
    public void test() {
        ShowLog log = new ShowLog();
        log.setConten("aa");
        logService.insert(log);
    }
}
