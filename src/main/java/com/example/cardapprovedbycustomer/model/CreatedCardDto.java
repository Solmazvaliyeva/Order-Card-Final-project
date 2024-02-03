package com.example.cardapprovedbycustomer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatedCardDto {

    private Integer id;

    private Integer customerId;
    private String cardNo;

    private LocalDate createdDate;
    private LocalDate closedDate;

    private Integer cardTypeId;

}
