package com.example.createcardtype.controller;

import com.example.createcardtype.model.CardDto;
import com.example.createcardtype.service.CardService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/create-card-type-api")
@RequiredArgsConstructor
public class CardController {

    private final CardService service;

    @GetMapping("/feign/{cardId}")
    public CardDto getCardById(@PathVariable Integer cardId){
        return service.findCardById(cardId);
    }

    @GetMapping("/notfeign")
    public List<CardDto> getAllCardTypes(){
        return service.findAll();
    }
    @PostMapping("/notfeign")
    public void saveCard(@Valid CardDto card){
        service.saveCard(card);
    }

    @DeleteMapping("/notfeign/{cardId}")
    public void deleteCard(@PathVariable Integer cardId){
        service.deleteById(cardId);
    }
}
