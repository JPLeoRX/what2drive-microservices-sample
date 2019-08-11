package com.what2drive.system_eureka_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * This was generated using Config Client, Eureka Server dependencies from Spring Initializr (2.17)
 * 1) Add EnableEurekaServer annotation
 * 2) Add bootstrap.properties with name and config server url
 * 3) Add new config in configs git
 */
@EnableEurekaServer @SpringBootApplication
public class SystemEurekaServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemEurekaServiceApplication.class, args);
    }
}