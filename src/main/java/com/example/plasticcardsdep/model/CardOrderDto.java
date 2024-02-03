package com.example.plasticcardsdep.model;

import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Order id should not be empty")
    private  Integer id;
    private Integer customerId;
    private CardStatus status;
    private LocalDate orderDate;
    private CardDto cardDto;

    private String cardNo;
    @Override
    public String toString() {
        return "CardOrderDto{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", status=" + status +
                ", orderDate=" + orderDate +
                '}';
    }
}
