package com.example.customerregistration.dao.corporate;

import com.example.customerregistration.dao.individual.IndividualCustomerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "corporate_customer_addresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CorporateAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String address;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "customer_id")
    private CorporateCustomerEntity addressEntity;

    @Override
    public String toString() {
        return "CorporateAddressEntity{" +
                "address='" + address + '\'' +
                ", addressEntity=" + addressEntity +
                '}';
    }
}
