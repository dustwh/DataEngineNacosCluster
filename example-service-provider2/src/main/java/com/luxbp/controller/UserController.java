package com.luxbp.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Resource
    private CommonConfig config;

    @GetMapping("/test")
    public String test() {
        return config.getUsername() + ", " + config.getTimeout() + ", " + config.getPort();
//        return "test E & D";
    }

    @GetMapping("/test/{name}")
    public String testWithUrlParam(@PathVariable("name") String name) {
        return config.getUsername() + ", " + config.getTimeout() + ", " + config.getPort() + ", " + name;
    }
}
