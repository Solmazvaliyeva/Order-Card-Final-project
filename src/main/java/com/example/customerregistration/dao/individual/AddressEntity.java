package com.example.customerregistration.dao.individual;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="address_all")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String registrationAddress;

    private String homeAddress;

    @Column(name="customer_id")
    private Integer customerEntityId;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "customer_id" ,insertable = false ,updatable = false)
    private IndividualCustomerEntity addressEntity;
}
