package com.example.cardorderbycustomer.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NoDataFoundExceptionDto {
    Integer exceptionId;
    String exceptionMessage;
}
