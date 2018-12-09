package com.bkhatkov.eurekaclientdemo;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-backend-demo")
//@RibbonClient("eureka-backend-demo")
public interface BackendServiceProxy {

    @GetMapping("/hello")
    public String helloBackend();
}
