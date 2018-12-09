package com.bkhatkov.eurekaclientdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CheckBackendRestController {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private BackendServiceProxy proxy;

    @Autowired
    BackendServiceDiscoveryClient backendServiceDiscoveryClient;

    @GetMapping("/checkBackend")
    public String checkBackend() {

        String response = proxy.helloBackend();

        return response;
    }

    @GetMapping("/checkBackend2")
    public String checkBackend2() {

        String response = backendServiceDiscoveryClient.helloWorld();

        return response;
    }
}
