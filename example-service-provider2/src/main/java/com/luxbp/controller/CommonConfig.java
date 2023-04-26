package com.luxbp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class CommonConfig {

    //both are OK
    //@Value(value = "${spring.datasource.username}")
    //username from test-dev config file
    @Value("${spring.datasource.username}")
    private String username;

    //timeout from common config file
    @Value("${timeout}")
    private Integer timeout;

    @Value("${server.port}")
    private String port;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
