package com.example.cardorderbycustomer.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NoDataFoundExceptionDto {
    Integer exceptionId;
    String exceptionMessage;
}
