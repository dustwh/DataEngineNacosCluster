package com.luxbp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExampleServiceConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExampleServiceConsumerApplication.class, args);
    }
}
