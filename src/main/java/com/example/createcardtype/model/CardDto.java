package com.example.createcardtype.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Card Name is mandatory")
    private String cardTypeName;

    @Override
    public String toString() {
        return "CardDto{" +
                "cardTypes='" + cardTypeName + '\'' +
                '}';
    }
}
