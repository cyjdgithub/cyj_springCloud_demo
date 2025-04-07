package com.ncy.services.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@SpringBootTest
public class DiscoveryTest {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Test
    void discoveryClientTest(){
        System.err.println(discoveryClient.getServices());
        for(String service:discoveryClient.getServices()){
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for(ServiceInstance instance: instances){
                System.out.println("ip:"+instance.getHost());
                System.out.println("ip:"+instance.getPort());
            }
        }

    }
}
