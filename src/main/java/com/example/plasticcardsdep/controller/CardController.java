package com.example.plasticcardsdep.controller;

import com.example.plasticcardsdep.model.CardApproveDto;
import com.example.plasticcardsdep.model.CardOrderDto;
import com.example.plasticcardsdep.service.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/create-plastic-cards")
@RequiredArgsConstructor
public class CardController {

    private  final CardService service;

    @GetMapping("getApprovedCards")
    public List<CardOrderDto> getApprovedCards(){
        return service.getApprovedCardList();
    }


    @GetMapping("getEmbossedCards")
    public List<CardOrderDto> getEmbossedCards(){
        return service.getEmbossedCardList();
    }

    @PostMapping("{approvedBy}")
    public void updateCards(@Valid @RequestBody List<CardOrderDto> approvedCards , @PathVariable String approvedBy){
        service.createPlasticCards(approvedCards ,approvedBy);
    }

    @PostMapping("sendToDeliver/{orderId}")
    public void sendToDeliver(@PathVariable Integer orderId){
        service.sendToDeliver(orderId);
    }
}
