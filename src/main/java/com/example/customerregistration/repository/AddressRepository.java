package com.example.customerregistration.repository;

import com.example.customerregistration.dao.individual.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<AddressEntity ,Integer> {

    @Query("select a from AddressEntity a where a.customerEntityId = :customerId")
    AddressEntity findAddressByCustomerId(Integer customerId);
}
