package com.example.createcardtype.mapper;

import com.example.createcardtype.dao.CardTypeEntity;
import com.example.createcardtype.model.CardDto;
import com.example.createcardtype.service.CardService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardTypeMapper {

    CardTypeMapper MAPPER = Mappers.getMapper(CardTypeMapper.class);


    CardTypeEntity cardDtoToEntity(CardDto cardDto);
    CardDto cardEntityToDto(CardTypeEntity cardEntity);
}
