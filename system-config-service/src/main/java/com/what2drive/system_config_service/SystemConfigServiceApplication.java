package com.what2drive.system_config_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * This was generated using Config Server dependencies from Spring Initializr (2.17)
 * 1) Added EnableConfigServer annotation
 * 2) Created separate git repository with configs
 * 3) Added application.properties with port and git uri
 */
@EnableConfigServer @SpringBootApplication
public class SystemConfigServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemConfigServiceApplication.class, args);
    }
}