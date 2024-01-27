package com.example.cardorderbycustomer.client;

import com.example.cardorderbycustomer.model.IndividualCustomerDto;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "customer-registration" ,url = "http://localhost:1203/individual-api/feign/")
public interface CardCustomerClient {
    @GetMapping(value = "{customerId}")
    @Headers("Content-Type: application/json")
    IndividualCustomerDto getCustomerById(@PathVariable Integer customerId);
}
