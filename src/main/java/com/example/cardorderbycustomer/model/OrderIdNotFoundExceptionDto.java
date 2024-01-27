package com.example.cardorderbycustomer.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderIdNotFoundExceptionDto {

    Integer exceptionId;
    String exceptionMessage;
}
