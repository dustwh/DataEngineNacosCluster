package com.luxbp.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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

    @GetMapping("/testTimeOut/{name}")
    public String testTimeOutWithUrlParam(@PathVariable("name") String name) throws InterruptedException {
        //this should run
        //TimeUnit.SECONDS.sleep(9);
        //this should faild
        TimeUnit.SECONDS.sleep(20);
        return config.getUsername() + ", " + config.getTimeout() + ", " + config.getPort() + ", " + name;
    }


}
