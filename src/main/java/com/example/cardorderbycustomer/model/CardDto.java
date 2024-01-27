package com.example.cardorderbycustomer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CardDto {

    private Integer id;
    private String cardTypeName;

    @Override
    public String toString() {
        return "CardDto{" +
                "cardTypes='" + cardTypeName + '\'' +
                '}';
    }
}
