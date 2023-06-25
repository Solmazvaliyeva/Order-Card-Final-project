package com.example.createcardtype.model;

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
