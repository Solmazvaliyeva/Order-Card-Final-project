package com.example.customerregistration.repository.corporate;

import com.example.customerregistration.dao.corporate.CorporateAddressEntity;
import com.example.customerregistration.dao.corporate.CorporateContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CorporateContactRepository extends JpaRepository<CorporateContactEntity,Integer> {
    @Query("select a from CorporateContactEntity a where a.customer.id =:customerId")
    CorporateContactEntity getCorporateContactEntitiesBy(Integer customerId);
}
