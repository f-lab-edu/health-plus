package org.healthplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class DeliveryWorkerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeliveryWorkerApplication.class, args);
    }
}
