package com.chinanx.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinanx.springboot.repository.UserRepository;

@Controller
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String home() {
        return "hello";
    }
    
    @ResponseBody
    @RequestMapping("/user")
    public Object findAll() {
        return userRepository.findAll();
    }
}
