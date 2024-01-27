package com.example.customerregistration.dao.corporate;

import com.example.customerregistration.dao.individual.IndividualCustomerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "corporate_customer_contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CorporateContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(columnDefinition = "customer_id" ,referencedColumnName = "id")
    private CorporateCustomerEntity customer;

    @Override
    public String toString() {
        return "CorporateContactEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", customer=" + customer +
                '}';
    }
}
