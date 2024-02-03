package com.example.cardoperationbranch.dao;

import com.example.cardoperationbranch.model.YesNo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "card_approvement_log")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardApproveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private String approvedBy;
    @CreationTimestamp
    private LocalDate approvedDate;

    @Enumerated(EnumType.STRING)
    private YesNo approvedOrNot;
    private String description;
    private Integer orderId;


}
