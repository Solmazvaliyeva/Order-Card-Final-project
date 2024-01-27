package com.example.customerregistration.repository.corporate;

import com.example.customerregistration.dao.corporate.CorporateCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateRepository extends JpaRepository<CorporateCustomerEntity,Integer> {

    @Query("select a.tin from CorporateCustomerEntity a where a.id = :customerId")
    Integer getCustomerTinNumber(Integer customerId);
}
