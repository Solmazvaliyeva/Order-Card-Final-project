package com.example.customerregistration.service;


import com.example.customerregistration.model.IndividualCustomerDto;

import java.util.List;

public interface CustomerService {
    IndividualCustomerDto findById(Integer customerId);

    List<IndividualCustomerDto> findAll();
    Integer saveCustomer(IndividualCustomerDto customersDt);

    void updateCustomer(Integer customerId,IndividualCustomerDto customersDto );

    void deleteCustomerById(Integer id);

}
