package com.example.cardorderbycustomer.service.impl;

import com.example.cardorderbycustomer.client.*;
import com.example.cardorderbycustomer.dao.CardOrderEntity;
import com.example.cardorderbycustomer.dao.CardRepository;
import com.example.cardorderbycustomer.exception.OrderIdNotFoundException;
import com.example.cardorderbycustomer.mapper.CardOrderMapper;
import com.example.cardorderbycustomer.model.*;
import com.example.cardorderbycustomer.service.CardOrderService;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardOrderServiceImpl implements CardOrderService {

    private final CardRepository repository;
    private final CardOrderClient orderClient;
    private final CardCustomerClient customerClient;

    private final CorporateCustomerClient corporateCustomerClient;




    @Override
    public CardOrderDto getOrderById(Integer orderId) {

        CardOrderEntity orderEntity = repository.findById(orderId)
                .orElseThrow(()-> new OrderIdNotFoundException("Order Id Not Found" + orderId));


        String cardName = orderClient.getCardById(orderEntity.getCardTypeId()).getCardTypeName();

        CardOrderDto orderDto  = CardOrderMapper.MAPPER.cardOrderEntityToDto(orderEntity);
        orderDto.getCardDto().setCardTypeName(cardName);
        return orderDto;
    }

    @Override
    public Integer saveIndividualCustomerCardOrder(Integer customerId, Integer cardTypeId, YesNo delivery) {
        CardOrderDto cardOrder = new CardOrderDto();
        CardDto cardType = orderClient.getCardById(cardTypeId);

        IndividualCustomerDto customer =
                customerClient.getCustomerById(customerId);


        cardOrder.setCustomerId(customer.getId());
        cardOrder.setStatus(CardStatus.INIT);
        cardOrder.setCardDelivery(delivery);
        cardOrder.setCardDto(cardType);

        repository.save(CardOrderMapper.MAPPER.cardOrderDtoToEntity(cardOrder));
        return cardOrder.getId();

    }

    @Override
    public Integer saveCorporateCustomerCardOrder(Integer customerId, Integer cardTypeId, YesNo delivery) {
        CardOrderDto cardOrder = new CardOrderDto();
        CardDto cardType = orderClient.getCardById(cardTypeId);

        CorporateCustomerDto customer =
                corporateCustomerClient.getCorporateCustomerById(customerId);


        cardOrder.setCustomerId(customer.getId());
        cardOrder.setStatus(CardStatus.INIT);
        cardOrder.setCardDelivery(delivery);
        cardOrder.setCardDto(cardType);

        repository.save(CardOrderMapper.MAPPER.cardOrderDtoToEntity(cardOrder));
        return cardOrder.getId();
    }

    @Override
    public void updateStatus(Integer id, CardStatus status) {

        CardStatus cardStatus=status;
        CardOrderEntity entity = repository.findById(id).orElseThrow(()-> new OrderIdNotFoundException("Order Id Not Found" + id));
        entity.setId(id);

        if (status==CardStatus.DELIVERY){

            if (entity.getCardDelivery()==YesNo.YES){
                 cardStatus = CardStatus.COURIER;
            } else if (entity.getCardDelivery()==YesNo.NO) {
                cardStatus = CardStatus.BRANCH;
            }
        }


        entity.setStatus(cardStatus);
        repository.save(entity);

    }

    @Override
    public List<CardOrderDto> getCardsInInitStatus() {

       List<CardOrderDto> cardOrderDtos =  repository.getCardsInInitStatus()
                .stream()
                .map(it->
                CardOrderMapper.MAPPER.cardOrderEntityToDto(it)).collect(Collectors.toList());

//        cardOrderDtos.forEach(cardOrderDto ->
//                cardOrderDto.getCardDto()
//                        .setCardTypeName(orderClient.getCardById(cardOrderDto
//                                .getCardDto().getId()).getCardTypeName()));

       return cardOrderDtos;

    }

    @Override
    public List<CardOrderDto> getApprovedCards() {
        return repository
                .getApprovedCards()
                .stream()
                .map(it->CardOrderMapper.MAPPER.cardOrderEntityToDto(it))
                .collect(Collectors.toList());
    }

    @Override
    public List<CardOrderDto> getEmbossedCards() {
        return  repository
                .getEmbossedCards()
                .stream()
                .map(it->CardOrderMapper.MAPPER.cardOrderEntityToDto(it))
                .collect(Collectors.toList());
    }

    @Override
    public List<CardOrderDto> getReadyCards() {
        return repository
                .getReadyCards()
                .stream()
                .map(it->CardOrderMapper.MAPPER.cardOrderEntityToDto(it))
                .collect(Collectors.toList());
    }
    @Override
    public void updateStatusINProgress(List<CardOrderDto> cardOrders) {

        cardOrders.stream().forEach(
                cardOrderDto -> cardOrderDto.setCardDto(getOrderById(cardOrderDto.getId()).getCardDto()));

        cardOrders.stream().forEach(
                cardOrderDto -> cardOrderDto.setCardDelivery(getOrderById(cardOrderDto.getId()).getCardDelivery()));

        cardOrders.stream().forEach(
                cardOrderDto -> cardOrderDto.setCustomerId(getOrderById(cardOrderDto.getId()).getCustomerId()));



        cardOrders.stream().forEach(it->it.setStatus(CardStatus.IN_PROGRESS));


        List<CardOrderEntity> list=
        cardOrders.stream().map(it->CardOrderMapper.MAPPER.cardOrderDtoToEntity(it)).collect(Collectors.toList());

        repository.saveAll(list);
    }
}
