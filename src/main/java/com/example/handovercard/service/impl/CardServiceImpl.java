package com.example.handovercard.service.impl;

import com.example.handovercard.client.CardHandOverClient;
import com.example.handovercard.dao.CardRepository;
import com.example.handovercard.dao.HandedOverCardEntity;
import com.example.handovercard.model.CardOrderDto;
import com.example.handovercard.model.CardStatus;
import com.example.handovercard.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardHandOverClient client;
    private final CardRepository repository;
    @Override
    public void handOverCard(Integer orderId, HandedOverCardEntity entity) {
        System.out.println("1");
        CardOrderDto cardOrderDto = client.getOrderById(orderId);
        System.out.println("2");
//        if(cardOrderDto.getStatus() != CardStatus.DELIVERY){
//            throw new RuntimeException("this card is not ready for delivery");
//        }

        client.updateOrderStatus(cardOrderDto.getId() ,CardStatus.HANDED_OVER);
        entity.setOrderId(cardOrderDto.getId());
        repository.save(entity);

    }
}
