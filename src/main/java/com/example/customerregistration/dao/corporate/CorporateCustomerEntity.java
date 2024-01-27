package com.example.customerregistration.dao.corporate;

import com.example.customerregistration.dao.CustomerEntity;
import com.example.customerregistration.dao.individual.ContactsEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "corporate-customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CorporateCustomerEntity extends CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer tin;
    private LocalDate foundationYear;
    private String founder;

    @OneToOne(mappedBy = "addressEntity" ,cascade = CascadeType.REMOVE)
    private CorporateAddressEntity  corporateAddressEntity;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE )
    private List<CorporateContactEntity> contactsEntity;
    public String toString() {
        return "CorporateCustomerEntity{" +
                "id=" + id +
                ", tin=" + tin +
                ", foundationYear=" + foundationYear +
                ", founder='" + founder + '\'' +
                ", corporateAddressEntity=" + corporateAddressEntity +
                '}';
    }
}
