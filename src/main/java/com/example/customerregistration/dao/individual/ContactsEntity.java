package com.example.customerregistration.dao.individual;

import com.example.customerregistration.model.OldOrNew;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="customer_contacts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String phoneNumber;
    private String email;

    @Enumerated(value = EnumType.STRING)
    private OldOrNew isOld;

//    @Column(name="customer_id")
//    private Integer customerEntityId;
    @ManyToOne
    @JoinColumn(columnDefinition = "customer_id" ,referencedColumnName = "id")
    private IndividualCustomerEntity customer;


}
