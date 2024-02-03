package com.example.createcardtype.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="card_types")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CardTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cardTypeName;

    @Override
    public String toString() {
        return "CardTypeEntity{" +
                "cardTypes='" + cardTypeName + '\'' +
                '}';
    }
}
