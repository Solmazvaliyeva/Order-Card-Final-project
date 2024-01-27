package com.example.customerregistration.model.corporate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CorporateContactDto {
    @JsonIgnore
    private Integer id;
    private String email;
    private String phoneNumber;

    @JsonIgnore
    private CorporateCustomerDto customerDto;

    @Override
    public String toString() {
        return "CorporateContactDto{" +
                "email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
