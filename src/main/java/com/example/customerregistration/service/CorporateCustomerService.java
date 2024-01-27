package com.example.customerregistration.service;

import com.example.customerregistration.model.IndividualCustomerDto;
import com.example.customerregistration.model.corporate.CorporateCustomerDto;

import java.util.List;

public interface CorporateCustomerService {


    CorporateCustomerDto findById(Integer customerId);

    List<CorporateCustomerDto> findAll();
    Integer saveCustomer(CorporateCustomerDto customersDt);

    void updateCustomer(Integer customerId,CorporateCustomerDto customersDto );

    void deleteCustomerById(Integer id);

    Integer getTinNumber(Integer customerId);
}
