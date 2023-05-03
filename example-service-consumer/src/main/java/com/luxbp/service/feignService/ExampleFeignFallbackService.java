package com.luxbp.service.feignService;

import com.luxbp.service.feignService.ExampleFeignService;
import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.stereotype.Component;

@Component
public class ExampleFeignFallbackService implements ExampleFeignService {

    @Override
    public String call(String name) {
        return "trigger fallback method";
    }

    @Override
    public String callWithTimeOut(int interval) {
//        throw new NoFallbackAvailableException("Boom!", new RuntimeException());
        return "trigger fallback method";
    }

    @Override
    public String readingInStore() {
        return "trigger fallback method";
    }
}
