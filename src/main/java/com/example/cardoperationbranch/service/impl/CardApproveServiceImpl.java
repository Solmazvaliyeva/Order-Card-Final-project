package com.example.cardoperationbranch.service.impl;

import com.example.cardoperationbranch.client.CardApproveClient;
import com.example.cardoperationbranch.client.CorporateCustomerClient;
import com.example.cardoperationbranch.dao.ApproveRepository;
import com.example.cardoperationbranch.dao.CardApproveEntity;
import com.example.cardoperationbranch.model.CardApproveDto;
import com.example.cardoperationbranch.model.CardOrderDto;
import com.example.cardoperationbranch.model.CardStatus;
import com.example.cardoperationbranch.model.YesNo;
import com.example.cardoperationbranch.service.CardApproveService;
import lombok.RequiredArgsConstructor;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardApproveServiceImpl implements CardApproveService {

    private  final CardApproveClient cardApproveClient;
    private final CorporateCustomerClient corporateCustomerClient;
    private  final ApproveRepository repository;

    @Override
    public List<CardOrderDto> getCardInInitStatus() {
        return cardApproveClient.getCardInInitStatus();
    }

    @Override
    public void approveOrder(Integer orderId ,String approvedBy) {

        CardApproveEntity approveEntity = new CardApproveEntity();
        CardOrderDto cardOrder = cardApproveClient.getOrderById(orderId);

        CardStatus status = null;

        if (cardOrder.getCardDto().getId() == 4 && (corporateCustomerClient.returnTinNumber(orderId)==null)){
            approveEntity.setOrderId(orderId);
            approveEntity.setApprovedBy(approvedBy);
            approveEntity.setApprovedOrNot(YesNo.NO);
            approveEntity.setDescription("Only corporate customers could have order this card");
        }
        else{
            approveEntity.setOrderId(orderId);
            approveEntity.setApprovedBy(approvedBy);
            approveEntity.setApprovedOrNot(YesNo.YES);
            approveEntity.setDescription("APPROVED");
        }

        repository.save(approveEntity);

        if(approveEntity.getApprovedOrNot()==YesNo.YES){
            status = CardStatus.APPROVED;
        }
        else
            status = CardStatus.DECLINED;


        cardApproveClient.updateOrderStatus(orderId,status);

    }
}
