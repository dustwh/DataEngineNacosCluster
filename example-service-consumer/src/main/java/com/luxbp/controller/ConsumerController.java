package com.luxbp.controller;

import com.luxbp.service.ExampleFeignService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired//this can be deleted after adding openFeign
    private RestTemplate restTemplate;// this can be deleted after adding openFeign

    @Resource
    private ExampleFeignService exampleFeignService;

    @GetMapping(value = "/test")
    public String echo() {
        return restTemplate.getForObject("http://provider/test", String.class);
    }

    @GetMapping("/testFeignCalling")
    public String FeignConsumer(@RequestParam String name) {
        return exampleFeignService.call(name);
    }

    @RequestMapping("/testFeignCallingWithTimeOut")
    public String FeignConsumerTimeout(@RequestParam String name) {
        return exampleFeignService.callWithTimeOut(name);
    }
}
