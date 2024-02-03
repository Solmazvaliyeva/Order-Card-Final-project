package com.example.handovercard.client;


import com.example.handovercard.model.CardOrderDto;
import com.example.handovercard.model.CardStatus;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(name = "card-order-by-customer" ,url = "http://localhost:2401/card-order-api/feign/")
public interface CardHandOverClient {

    @GetMapping("{orderId}")
    @Headers("Content-Type: application/json")
    CardOrderDto getOrderById(@PathVariable Integer orderId);

    @GetMapping("getReadyCards")
    @Headers("Content-Type: application/json")
     List<CardOrderDto> getReadyCards();

    @PutMapping("update-status/{orderId}")
    @Headers("Content-Type: application/json")
    void updateOrderStatus(@PathVariable  Integer orderId, @RequestBody CardStatus status);
}
