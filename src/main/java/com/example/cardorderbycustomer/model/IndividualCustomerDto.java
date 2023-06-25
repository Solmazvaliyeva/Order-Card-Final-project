package com.example.customerregistration.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IndividualCustomerDto {
    private Integer id;
    private Integer serialNumber;
    private String pinCode;
    private String birthPlace;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    private CustomerType customerType;

    private AddressDto addressDto;

    private List<ContactsDto> contactsDtoList;

}
