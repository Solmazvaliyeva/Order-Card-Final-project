package com.example.handovercard.mapper;

import com.example.handovercard.dao.HandedOverCardEntity;
import com.example.handovercard.model.HandedOverCardDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper {
    CardMapper MAPPER = Mappers.getMapper(CardMapper.class);

    HandedOverCardDto cardEntityToDto(HandedOverCardEntity entity);


    HandedOverCardEntity cardDtoToEntity(HandedOverCardDto cardDto);



}
