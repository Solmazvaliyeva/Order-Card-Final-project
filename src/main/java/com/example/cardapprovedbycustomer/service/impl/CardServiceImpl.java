package com.example.cardapprovedbycustomer.service.impl;

import com.example.cardapprovedbycustomer.client.CardHandOverClient;
import com.example.cardapprovedbycustomer.dao.CardRepository;
import com.example.cardapprovedbycustomer.dao.CreatedCardEntity;
import com.example.cardapprovedbycustomer.mapper.CardMapper;
import com.example.cardapprovedbycustomer.model.CardOrderDto;
import com.example.cardapprovedbycustomer.model.CardStatus;
import com.example.cardapprovedbycustomer.model.CreatedCardDto;
import com.example.cardapprovedbycustomer.service.CardService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardHandOverClient client;
    private final CardRepository repository;

    @Override
    public String createCard(Integer orderId) {
        CardOrderDto cardOrder=client.getOrderById(orderId);

        CreatedCardDto cardDto = new CreatedCardDto();
        cardDto.setCustomerId(cardOrder.getCustomerId());
        cardDto.setCardNo(cardNo());
        cardDto.setCardTypeId(cardOrder.getCardDto().getId());

        client.updateOrderStatus(orderId , CardStatus.COMPLETED);


        repository.save(CardMapper.MAPPER.cardDtoToEntity(cardDto));
        return cardDto.getCardNo();




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
