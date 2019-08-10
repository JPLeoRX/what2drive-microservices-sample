package com.what2drive.car_proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * This was generated using Actuator, Spring Web Starter, Config Client, Eureka Discovery Client, Zuul dependencies from Spring Initializr (2.17)
 * 1) Add bootstrap.properties with name and config server url
 * 2) Add new config in configs git
 * 3) Add EnableEurekaClient annotation for Eureka
 */
@EnableZuulProxy @EnableEurekaClient @SpringBootApplication
public class CarProxyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarProxyApplication.class, args);
    }
}