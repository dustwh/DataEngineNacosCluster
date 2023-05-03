package com.luxbp.service.feignService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "provider", fallback = ExampleFeignFallbackService.class)   // nacos service id, aka spring.application.name
public interface ExampleFeignService {
    @GetMapping("/test/{name}") // by get method, call "/call/{name}" api from provider
    public String call(@PathVariable(value = "name") String name);

    @RequestMapping("testTimeOut/{interval}")
    public String callWithTimeOut(@PathVariable("interval") int interval);

    @RequestMapping("/recommended")
    public String readingInStore();
}
