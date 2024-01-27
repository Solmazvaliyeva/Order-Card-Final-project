package com.example.cardorderbycustomer.dao;

import com.example.cardorderbycustomer.model.CardStatus;
import com.example.cardorderbycustomer.model.YesNo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "card_order")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CardOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer customerId;
    @Enumerated(EnumType.STRING)
    private CardStatus status;

    @CreationTimestamp
    private LocalDate orderDate;


    @Enumerated(EnumType.STRING)
    private YesNo cardDelivery;
    private Integer cardTypeId;

    private String cardNo;

    @Override
    public String toString() {
        return "CardOrderEntity{" +
                "customerId=" + customerId +
                ", status=" + status +
                ", orderDate=" + orderDate +
                ", cardDelivery=" + cardDelivery +
                '}';
    }
}
