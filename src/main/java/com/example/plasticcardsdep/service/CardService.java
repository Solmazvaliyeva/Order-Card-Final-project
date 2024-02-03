package com.example.plasticcardsdep.service;

import com.example.plasticcardsdep.model.CardOrderDto;

import java.util.List;

public interface CardService {
    List<CardOrderDto> getApprovedCardList();

    List<CardOrderDto> getEmbossedCardList();
    void createPlasticCards(List<CardOrderDto> approvedCards ,String approvedBy);

    void sendToDeliver(Integer orderId);
}
