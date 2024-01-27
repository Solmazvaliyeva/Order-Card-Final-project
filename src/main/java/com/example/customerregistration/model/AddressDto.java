package com.example.customerregistration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressDto {
    @JsonIgnore
    private Integer id;

    @NotBlank(message = "registration address is mandatory")
    private String registrationAddress;
    private String homeAddress;
    @JsonIgnore
    private  Integer customerId;
}
