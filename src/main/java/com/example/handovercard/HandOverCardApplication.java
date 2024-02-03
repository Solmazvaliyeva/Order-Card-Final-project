package com.example.handovercard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HandOverCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandOverCardApplication.class, args);
	}

}
