package com.example.createcardtype.service;

import com.example.createcardtype.dao.CardTypeEntity;
import com.example.createcardtype.model.CardDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CardService {

    CardDto findCardById(Integer id);

    List<CardDto> findAll();

    void saveCard(CardDto cardDto);

    void deleteById(Integer id);
}
