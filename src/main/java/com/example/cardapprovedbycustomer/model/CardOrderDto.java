package com.example.cardapprovedbycustomer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CardOrderDto {
    private  Integer id;
    private Integer customerId;
    private CardStatus status;
    private LocalDate orderDate;

    private CardDto cardDto;
}
