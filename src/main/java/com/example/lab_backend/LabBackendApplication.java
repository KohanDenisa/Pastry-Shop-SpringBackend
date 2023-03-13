package com.example.lab_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class LabBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabBackendApplication.class, args);
    }

}
