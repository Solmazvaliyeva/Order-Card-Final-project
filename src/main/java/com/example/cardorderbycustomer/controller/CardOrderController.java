package com.example.cardorderbycustomer.controller;

import com.example.cardorderbycustomer.model.CardDto;
import com.example.cardorderbycustomer.model.CardOrderDto;
import com.example.cardorderbycustomer.model.CardStatus;
import com.example.cardorderbycustomer.model.YesNo;
import com.example.cardorderbycustomer.service.CardOrderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card-order-api")
public class CardOrderController {

    private final CardOrderService service;

    public CardOrderController(CardOrderService service) {
        this.service = service;
    }

    @GetMapping("/feign/{orderId}")
    public CardOrderDto getOrderById(@PathVariable Integer orderId){
        return service.getOrderById(orderId);
    }

    @PostMapping("/nofeign/individual-customer/{customerId} ,{cardId}")
    public Integer saveIndividualCustomerCardOrder(@PathVariable Integer customerId , @PathVariable Integer cardId,
                              @RequestBody YesNo delivery){
        return service.saveIndividualCustomerCardOrder(customerId,cardId ,delivery);
    }

    @PostMapping("/nofeign/corporate-customer/{customerId} ,{cardId}")
    public Integer saveCorporateCustomerCardOrder(@PathVariable Integer customerId , @PathVariable Integer cardId,
                              @RequestBody YesNo delivery){
        return service.saveCorporateCustomerCardOrder(customerId,cardId ,delivery);
    }

    @GetMapping("/feign/getNewOrders")
    public List<CardOrderDto> getCardInInitStatus(){
        return service.getCardsInInitStatus();
    }

    @PutMapping("/feign/update-status/{orderId}")
    public void updateOrderStatus(@PathVariable  Integer orderId, @RequestBody  CardStatus status){

        service.updateStatus(orderId ,status);
    }

    @GetMapping("/feign/getApprovedOrders")
    public List<CardOrderDto> getApprovedCards(){
        return service.getApprovedCards();
    }


    @GetMapping("/feign/getEmbossedCards")
    public List<CardOrderDto> getEmbossedCards(){
        return service.getEmbossedCards();
    }

    @GetMapping("/feign/getReadyCards")
    public List<CardOrderDto> getReadyCards(){
        return service.getReadyCards();
    }

    @PutMapping("/feign/inProgress")
    public void updateStatusInProgress(@RequestBody List<CardOrderDto> cardOrders){
        service.updateStatusINProgress(cardOrders);
    }


}
