package com.healthcare.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InsuranceApplication {
    public static void main(String[] args) {
        SpringApplication.run(InsuranceApplication.class,args);
    }
}
