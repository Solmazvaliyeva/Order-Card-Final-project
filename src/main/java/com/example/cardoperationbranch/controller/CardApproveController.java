package com.example.cardoperationbranch.controller;

import com.example.cardoperationbranch.model.CardApproveDto;
import com.example.cardoperationbranch.model.CardOrderDto;
import com.example.cardoperationbranch.service.CardApproveService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("approve-new-orders")
@RequiredArgsConstructor
public class CardApproveController {
    private final CardApproveService service;

    @GetMapping("/getNewOrders")
    public List<CardOrderDto> getNewOrders(){
        return service.getCardInInitStatus();
    }

    @PostMapping("{orderId} ,{approvedBy}")
    public void approveCardOrder(@PathVariable Integer orderId ,@PathVariable String approvedBy){
        service.approveOrder(orderId,approvedBy);
    }
}
