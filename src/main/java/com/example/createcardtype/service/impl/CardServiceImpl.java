package com.example.createcardtype.service.impl;

import com.example.createcardtype.dao.CardRepository;
import com.example.createcardtype.dao.CardTypeEntity;
import com.example.createcardtype.exception.NoCustomerFoundException;
import com.example.createcardtype.mapper.CardTypeMapper;
import com.example.createcardtype.model.CardDto;
import com.example.createcardtype.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository repository;



    @Override
    public CardDto findCardById(Integer id) {
        return CardTypeMapper.MAPPER.cardEntityToDto(
                repository.findById(id).orElseThrow(()->new NoCustomerFoundException("card id not found")));
    }

    @Override
    public List<CardDto> findAll() {
        return repository.findAll().stream()
                .map(it-> CardTypeMapper.MAPPER.cardEntityToDto(it)).collect(Collectors.toList());
    }

    @Override
    public void saveCard(CardDto cardDto) {
        repository.save(CardTypeMapper.MAPPER.cardDtoToEntity(cardDto));
    }

    @Override
    public void deleteById(Integer id) {

        CardTypeEntity card=repository.findById(id).orElseThrow(()->new NoCustomerFoundException("card id not found"));
        repository.delete(card);

    }
}
