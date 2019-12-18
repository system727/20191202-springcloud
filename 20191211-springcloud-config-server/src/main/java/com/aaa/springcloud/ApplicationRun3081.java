package com.aaa.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ApplicationRun3081 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun3081.class,args);
    }
}
