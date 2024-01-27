package com.example.customerregistration.repository;

import com.example.customerregistration.dao.individual.IndividualCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualRepository extends JpaRepository<IndividualCustomerEntity,Integer> {

//    @Query("select a from IndividualCustomerEntity a where a.customerEntityId = :customerId")
//    IndividualCustomerEntity findByCustomerId(Integer customerId);
}
