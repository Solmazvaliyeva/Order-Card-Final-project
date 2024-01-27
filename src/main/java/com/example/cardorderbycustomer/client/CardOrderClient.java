package com.example.cardorderbycustomer.client;

import com.example.cardorderbycustomer.model.CardDto;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "create-card-type" ,url = "http://localhost:2301/create-card-type-api/feign" )

public interface CardOrderClient {
    @GetMapping("{cardId}")
    @Headers("Content-Type: application/json")
     CardDto getCardById(@PathVariable Integer cardId);
}
