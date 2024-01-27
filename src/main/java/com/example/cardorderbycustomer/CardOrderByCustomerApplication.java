package com.example.cardorderbycustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@SpringBootApplication
@EnableFeignClients

public class CardOrderByCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardOrderByCustomerApplication.class, args);
    }



}
