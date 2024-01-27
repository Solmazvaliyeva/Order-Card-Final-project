package com.example.customerregistration.dao.individual;

import com.example.customerregistration.dao.CustomerEntity;
import com.example.customerregistration.dao.individual.AddressEntity;
import com.example.customerregistration.dao.individual.ContactsEntity;
import com.example.customerregistration.model.CustomerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "individual-customers")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IndividualCustomerEntity extends CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String birthPlace;
    private String pinCode;
    private Integer serialNumber;


    @Enumerated(EnumType.STRING)
    private CustomerType customerType;


    @OneToOne(mappedBy = "addressEntity" ,cascade = CascadeType.REMOVE)
    private AddressEntity addressEntity;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE )
    private List<ContactsEntity> contactsEntity;

}
