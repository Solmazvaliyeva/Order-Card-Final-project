package com.example.plasticcardsdep.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardApproveDto {
    private Integer id;
    private String approvedBy;
    private LocalDate approveDate;

    private String description;
    private Integer orderId;
}
