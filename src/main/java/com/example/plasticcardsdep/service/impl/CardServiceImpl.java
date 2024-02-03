package com.example.plasticcardsdep.service.impl;

import com.example.plasticcardsdep.client.PlasticCardClient;
import com.example.plasticcardsdep.dao.CardRepository;
import com.example.plasticcardsdep.mapper.CardMapper;
import com.example.plasticcardsdep.model.CardApproveDto;
import com.example.plasticcardsdep.model.CardOrderDto;
import com.example.plasticcardsdep.model.CardStatus;
import com.example.plasticcardsdep.model.CreatePlasticCardDto;
import com.example.plasticcardsdep.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
   private final PlasticCardClient client;
   private final CardRepository repository;

    @Override
    public List<CardOrderDto> getApprovedCardList() {
        return client.getApprovedCards();
    }

    @Override
    public List<CardOrderDto> getEmbossedCardList() {
        return client.getEmbossedCards();
    }

    @Override
    public void createPlasticCards(List<CardOrderDto> approvedCards,String approvedBy) {
        List<CreatePlasticCardDto> cardList = new ArrayList<>();

        for (CardOrderDto approvedCard:approvedCards
             ) {
            CreatePlasticCardDto cardDto = new CreatePlasticCardDto();
            cardDto.setOrderId(approvedCard.getId());
            cardDto.setApprovedBy(approvedBy);
            cardList.add(cardDto);
            approvedCard.setCardNo(cardNo());
        }
        repository.saveAll(cardList.stream().map(it-> CardMapper.MAPPER.cardDtoToEntity(it)).collect(Collectors.toList()));

        client.updateStatusInProgress(approvedCards);
    }

    @Override
    public void sendToDeliver(Integer orderId) {

        client.updateOrderStatus(orderId, CardStatus.DELIVERY);
    }

    public String cardNo(){
        Random value = new Random();
        String start="";
        int count = 0;
        int n = 0;
        for(int i =0; i < 16;i++)
        {
            if(count == 4)
            {
                start += " ";
                count =0;
            }
            else
                n = value.nextInt(10);
            start += Integer.toString(n);
            count++;

        }
        return start;
    }
}
