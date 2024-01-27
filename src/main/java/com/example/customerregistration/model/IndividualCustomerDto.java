package com.example.customerregistration.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Serial Number should not be empty")
    private Integer serialNumber;
    @NotBlank(message = "Pin code mandatory")

    private String pinCode;
    private String birthPlace;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    private CustomerType customerType;

    private AddressDto addressDto;

    private List<ContactsDto> contactsDtoList;

}
