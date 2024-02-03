package com.example.cardapprovedbycustomer.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name="cards_all")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatedCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer customerId;
    private String cardNo;
    @CreationTimestamp
    private LocalDate createdDate;
    private LocalDate closedDate;

    private Integer cardTypeId;


}
