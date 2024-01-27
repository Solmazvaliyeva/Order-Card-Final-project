package com.example.customerregistration.exception;

public class NoCustomerFoundException extends RuntimeException{
    public NoCustomerFoundException(String message){
        super(message);
    }
}
