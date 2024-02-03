package com.example.plasticcardsdep.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "create_plastic_card_log")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String approvedBy;

    @CreationTimestamp
    private LocalDate approvedDate;

    private Integer orderId;
}
