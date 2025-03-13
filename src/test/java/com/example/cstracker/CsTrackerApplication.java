package com.example.cstracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CsTrackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CsTrackerApplication.class, args);
        System.out.println("🚀 CS Tracker API está rodando!");
    }
}
