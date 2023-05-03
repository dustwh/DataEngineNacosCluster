package com.luxbp.controller;

import com.luxbp.config.CommonConfig;
import jakarta.annotation.Resource;
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

    @GetMapping("/testTimeOut/{interval}")
    public String testTimeOutWithUrlParam(@PathVariable("interval") int interval) throws InterruptedException {
        //this should run
        //TimeUnit.SECONDS.sleep(9);
        //this should faild
//        TimeUnit.SECONDS.sleep(1);
        Thread.sleep(interval);
        return config.getUsername() + ", " + config.getTimeout() + ", " + config.getPort() + ", " + interval;
    }
}
