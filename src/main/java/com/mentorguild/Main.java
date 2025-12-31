package com.mentorguild;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // This annotation includes @Configuration, @EnableAutoConfiguration, and @ComponentScan
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);  // Launch the Spring Boot app
    }
}
