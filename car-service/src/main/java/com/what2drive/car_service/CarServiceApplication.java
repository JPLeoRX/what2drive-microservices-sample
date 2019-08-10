package com.what2drive.car_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * This was generated using Actuator, Spring Web Starter, Spring Data JPA, Flyway Migration, Config Client, Eureka Discovery Client, PostgreSQL Driver dependencies from Spring Initializr (2.17)
 * 1) Add bootstrap.properties with name and config server url
 * 2) Add new config in configs git
 * 3) Add EnableDiscoveryClient annotation for Eureka
 */
@EnableEurekaClient
@SpringBootApplication
public class CarServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarServiceApplication.class, args);
    }
}