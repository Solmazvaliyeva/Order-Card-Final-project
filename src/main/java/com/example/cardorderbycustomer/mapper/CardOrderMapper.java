package com.example.cardorderbycustomer.mapper;

import com.example.cardorderbycustomer.dao.CardOrderEntity;
import com.example.cardorderbycustomer.model.CardOrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardOrderMapper {
    CardOrderMapper MAPPER = Mappers.getMapper(CardOrderMapper.class);

    @Mapping(target = "cardTypeId" ,source = "cardDto.id")
    CardOrderEntity cardOrderDtoToEntity(CardOrderDto cardOrderDto);

    @Mapping(target ="cardDto.id" ,source = "cardTypeId")
    @Mapping(target = "cardDelivery" ,source = "cardDelivery")
    CardOrderDto cardOrderEntityToDto(CardOrderEntity cardOrderEntity);
}
