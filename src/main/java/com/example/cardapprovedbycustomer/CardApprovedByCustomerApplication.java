package com.example.cardapprovedbycustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CardApprovedByCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardApprovedByCustomerApplication.class, args);
	}

}
