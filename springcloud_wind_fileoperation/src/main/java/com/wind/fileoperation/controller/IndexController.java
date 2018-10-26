package com.wind.fileoperation.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping(value = "index")
    public String index(Map<String, String> map) {
	map.put("user", "斩风");
	return "index";
    }
}
