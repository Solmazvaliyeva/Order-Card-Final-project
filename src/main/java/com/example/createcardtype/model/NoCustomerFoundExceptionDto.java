package com.example.createcardtype.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NoCustomerFoundExceptionDto {

    Integer exceptionId;
    String exceptionMessage;
}
