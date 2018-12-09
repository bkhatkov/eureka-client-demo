package com.bkhatkov.eurekaclientdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class ServiceInstanceRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/self")
    public List<ServiceInstance> serviceInstancesSelf() {
        return this.discoveryClient.getInstances("eureka-client-demo");
    }

    @RequestMapping("/service-instances/backend")
    public List<ServiceInstance> serviceInstancesBackend() {
        return this.discoveryClient.getInstances("eureka-backend-demo");
    }
}