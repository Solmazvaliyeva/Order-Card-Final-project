package com.example.cardapprovedbycustomer.mapper;

import com.example.cardapprovedbycustomer.dao.CreatedCardEntity;
import com.example.cardapprovedbycustomer.model.CreatedCardDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper {

    CardMapper MAPPER = Mappers.getMapper(CardMapper.class);

    CreatedCardEntity cardDtoToEntity(CreatedCardDto cardDto);
}
