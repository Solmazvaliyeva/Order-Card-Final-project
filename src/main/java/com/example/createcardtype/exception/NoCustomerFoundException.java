package com.example.createcardtype.exception;

public class NoCustomerFoundException extends RuntimeException{
    public NoCustomerFoundException(String message){
        super(message);
    }
}
