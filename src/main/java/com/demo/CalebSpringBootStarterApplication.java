package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class CalebSpringBootStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalebSpringBootStarterApplication.class, args);
    }

}
