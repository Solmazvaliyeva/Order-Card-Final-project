package com.example.customerregistration.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactsDto {
    @JsonIgnore
    private  Integer id;
    @NotBlank(message = "Phone number is mandatory")
    private String phoneNumber;
    private String email;


    private OldOrNew isOld;
    @JsonIgnore
    private Integer customerId;

}
