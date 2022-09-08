package com.example.alex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AlexApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlexApplication.class, args);
    }
}
