package com.bkhatkov.eurekaclientdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@EnableDiscoveryClient
@EnableFeignClients
public class BackendServiceDiscoveryClient {
    @Autowired
    private TheClient theClient;

    @FeignClient(name = "eureka-backend-demo")
    interface TheClient {

        @RequestMapping(path = "/hello", method = RequestMethod.GET)
        @ResponseBody
        String helloWorld();
    }

    public String helloWorld() {
        return theClient.helloWorld();
    }
}
