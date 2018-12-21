package com.chinanx.springboot.controller;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinanx.springboot.auth.AuthProperties;
import com.chinanx.springboot.repository.HelloRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger(HelloController.class);
    
    @Autowired
    private AuthProperties auth;
    
    @Autowired
    private HelloRepository helloRepository;

    @RequestMapping("/")
    public String home() {
        return "hello";
    }
    
    @ResponseBody
    @RequestMapping("/auth")
    public Object auth() {
        logger.debug("auth: {}", auth);
        return auth;
    }

    @ResponseBody
    @RequestMapping("/auth/{openId}")
    public Object auth(@PathVariable String openId) {
        for(AuthProperties.AuthUser user: auth.getUsers()) {
            logger.debug("authUser: {}", user);
            if(user.getOpenId().equals(openId)) {
                return user;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @ResponseBody
    @RequestMapping("/{date:[0-9]{8}}")
    public Object getDailyReport(@PathVariable String date) {
        String report = helloRepository.getDailyReport(date);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> result = null;
        try {
            if(!StringUtils.isEmpty(report)) {
                result = mapper.readValue(report, Map.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
