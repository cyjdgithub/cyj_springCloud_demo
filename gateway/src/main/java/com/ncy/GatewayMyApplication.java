package com.ncy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayMyApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMyApplication.class,args);
    }
}
