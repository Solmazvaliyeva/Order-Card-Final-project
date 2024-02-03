package com.example.handovercard.dao;

import com.example.handovercard.model.YesNo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name="handed_over_card_log")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HandedOverCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private YesNo byCourier;
    private String courierName;
    @Enumerated(EnumType.STRING)
    private YesNo fromBranch;
    private String operatorName;
    @CreationTimestamp
    private LocalDate handOverDate;
    private Integer orderId;
}
