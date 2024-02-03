package com.example.plasticcardsdep.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatePlasticCardDto {

    private Integer id;
    private String approvedBy;
    private LocalDate approvedDate;

    private Integer orderId;
}
