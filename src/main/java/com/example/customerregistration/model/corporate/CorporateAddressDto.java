package com.example.customerregistration.model.corporate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CorporateAddressDto {
    @JsonIgnore
    private Integer id;
    private String address;
    @JsonIgnore
    private CorporateCustomerDto customerDto;

    @Override
    public String toString() {
        return "CorporateAddressDto{" +
                "address='" + address + '\'' +
                '}';
    }
}
