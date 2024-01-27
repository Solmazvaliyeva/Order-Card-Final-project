package com.example.cardorderbycustomer.client;

import com.example.cardorderbycustomer.model.CorporateCustomerDto;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-registration" ,url = "http://localhost:1203/corporate-api/feign/")
public interface CorporateCustomerClient {

    @GetMapping("{customerId}")
    @Headers("Content-Type: application/json")
    CorporateCustomerDto getCorporateCustomerById(@PathVariable Integer customerId);
}
