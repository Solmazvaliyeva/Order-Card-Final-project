package com.example.plasticcardsdep.mapper;

import com.example.plasticcardsdep.dao.CardEntity;
import com.example.plasticcardsdep.model.CreatePlasticCardDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper {
    CardMapper MAPPER = Mappers.getMapper(CardMapper.class);

    CardEntity cardDtoToEntity(CreatePlasticCardDto plasticCardDto);

    CreatePlasticCardDto cardEntityToDto(CardEntity entity);
}
