package com.wind.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.andrewoma.dexx.collection.HashMap;
import com.github.andrewoma.dexx.collection.Map;
import com.wind.user.service.HelloService;

@RestController
public class ConsumerController {
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String helloConsumer() {
	return helloService.helloService();
    }

    @RequestMapping(value = "index")
    public String index(Model model, HttpServletRequest request, HttpServletResponse resp) {
	//Map<String, List<User>> map = new HashMap<String, List<User>>();
	//model.addAttribute("", attributeValue)
	return "index....";
    }
}
