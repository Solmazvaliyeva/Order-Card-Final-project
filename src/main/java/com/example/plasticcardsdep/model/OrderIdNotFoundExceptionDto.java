package com.example.plasticcardsdep.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderIdNotFoundExceptionDto {

    Integer exceptionId;
    String exceptionMessage;
}
