package com.example.cardapprovedbycustomer.controller;

import com.example.cardapprovedbycustomer.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/create-card-api")
@RequiredArgsConstructor
public class CardController {
    private final CardService service;


    @PostMapping("{orderId}")
    public String createCard(@PathVariable Integer orderId){
        return service.createCard(orderId);
    }


}
