package com.example.cardoperationbranch.client;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="customer-registration" ,url = "http://localhost:1203/corporate-api/feign/")
public interface CorporateCustomerClient {

    @GetMapping("tin/{customerId}")
    @Headers("Content-Type: application/json")
     Integer returnTinNumber(@PathVariable Integer customerId);

}
