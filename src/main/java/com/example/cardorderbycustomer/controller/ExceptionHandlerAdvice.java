package com.example.cardorderbycustomer.controller;

import com.example.cardorderbycustomer.exception.CustomerNotFoundException;
import com.example.cardorderbycustomer.exception.OrderIdNotFoundException;
import com.example.cardorderbycustomer.model.NoDataFoundExceptionDto;
import com.example.cardorderbycustomer.model.OrderIdNotFoundExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public NoDataFoundExceptionDto handle(CustomerNotFoundException exception){

        return new NoDataFoundExceptionDto(HttpStatus.NOT_FOUND.value() ,exception.getMessage());
    }


    @ExceptionHandler(OrderIdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public OrderIdNotFoundExceptionDto handle(OrderIdNotFoundException exception){

        return new OrderIdNotFoundExceptionDto(HttpStatus.NOT_FOUND.value() ,exception.getMessage());
    }


}
