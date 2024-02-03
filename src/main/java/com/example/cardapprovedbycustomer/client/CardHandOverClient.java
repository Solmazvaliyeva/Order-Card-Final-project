package com.example.cardapprovedbycustomer.client;


import com.example.cardapprovedbycustomer.model.CardOrderDto;
import com.example.cardapprovedbycustomer.model.CardStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "card-order-by-customer" ,url = "http://localhost:2401/card-order-api/feign/")
public interface CardHandOverClient {

    @GetMapping("{orderId}")
    CardOrderDto getOrderById(@PathVariable Integer orderId);

    @PutMapping("update-status/{orderId}")
    void updateOrderStatus(@PathVariable  Integer orderId, @RequestBody CardStatus status);
}
