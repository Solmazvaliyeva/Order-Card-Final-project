package com.example.customerregistration.repository.corporate;

import com.example.customerregistration.dao.corporate.CorporateAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CorporateAddressRepository extends JpaRepository<CorporateAddressEntity, Integer> {


    @Query("select a from CorporateAddressEntity a where a.addressEntity.id =:customerId")
    CorporateAddressEntity getCorporateAddressEntitiesBy(Integer customerId);
}
