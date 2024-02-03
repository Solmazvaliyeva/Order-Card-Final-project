package com.example.plasticcardsdep.client;

import com.example.plasticcardsdep.model.CardOrderDto;
import com.example.plasticcardsdep.model.CardStatus;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "card-order-by-customer" ,url = "http://localhost:2401/card-order-api/feign/")
public interface PlasticCardClient {

    @GetMapping("getApprovedOrders")
    @Headers("Content-Type: application/json")
     List<CardOrderDto> getApprovedCards();

    @GetMapping("getEmbossedCards")
    @Headers("Content-Type: application/json")
     List<CardOrderDto> getEmbossedCards();



    @GetMapping("{orderId}")
    @Headers("Content-Type: application/json")
    CardOrderDto getOrderById(@PathVariable Integer orderId);


    @PutMapping("inProgress")
    @Headers("Content-Type: application/json")
     void updateStatusInProgress(@RequestBody List<CardOrderDto> cardOrders);


    @PutMapping("update-status/{orderId}")
    @Headers("Content-Type: application/json")
     void updateOrderStatus(@PathVariable  Integer orderId, @RequestBody  CardStatus status);
}
