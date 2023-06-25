package com.example.customerregistration.model.corporate;

import com.example.customerregistration.model.AddressDto;
import com.example.customerregistration.model.ContactsDto;
import com.example.customerregistration.model.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CorporateCustomerDto extends CustomerDto {
    private Integer id;
    private Integer tin;
    private LocalDate foundationYear;
    private String founder;

    private CorporateAddressDto addressDto;

    private List<CorporateContactDto> contactsDtoList;

    @Override
    public String toString() {
        return "CorporateCustomerDto{" +
                "tin=" + tin +
                ", foundationYear=" + foundationYear +
                ", founder='" + founder + '\'' +
                ", addressDto=" + addressDto +
                ", contactsDtoList=" + contactsDtoList +
                '}';
    }
}
