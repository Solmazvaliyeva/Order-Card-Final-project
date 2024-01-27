package com.example.cardorderbycustomer.service;

import com.example.cardorderbycustomer.dao.CardOrderEntity;
import com.example.cardorderbycustomer.model.CardOrderDto;
import com.example.cardorderbycustomer.model.CardStatus;
import com.example.cardorderbycustomer.model.YesNo;

import java.util.List;

public interface CardOrderService {

    CardOrderDto getOrderById(Integer orderId);
    Integer saveIndividualCustomerCardOrder(Integer customerId ,Integer cardTypeId, YesNo delivery);
    Integer saveCorporateCustomerCardOrder(Integer customerId ,Integer cardTypeId, YesNo delivery);

    void updateStatus(Integer id, CardStatus status);

    List<CardOrderDto>  getCardsInInitStatus();

    List<CardOrderDto>  getApprovedCards();

    List<CardOrderDto>  getEmbossedCards();
    List<CardOrderDto>  getReadyCards();
    void updateStatusINProgress(List<CardOrderDto> cardOrders);
}
