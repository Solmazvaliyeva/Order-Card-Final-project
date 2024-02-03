package com.example.cardoperationbranch.service;

import com.example.cardoperationbranch.model.CardOrderDto;

import java.util.List;

public interface CardApproveService {
    List<CardOrderDto> getCardInInitStatus();

    void approveOrder(Integer orderId ,String approvedBy);
}
