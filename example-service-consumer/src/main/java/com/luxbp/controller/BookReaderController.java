package com.luxbp.controller;

import com.luxbp.service.feignService.ExampleFeignService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookReaderController {

    @Resource
    private ExampleFeignService exampleFeignService;

    @RequestMapping("/to-read")
    public String toRead() {
        return exampleFeignService.readingInStore();
    }
}
