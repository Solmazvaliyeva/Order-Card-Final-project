package com.example.cardoperationbranch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

//@RestController
//@EnableResourceServer
@SpringBootApplication
@EnableFeignClients

public class CardOperationBranchApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardOperationBranchApplication.class, args);
	}


//	@RequestMapping("/validateUser")
//	public Principal user(Principal user) {
//		return user;
//	}
}
