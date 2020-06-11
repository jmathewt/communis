package com.rhema.communis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CommunisServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunisServicesApplication.class, args);
    }

}
