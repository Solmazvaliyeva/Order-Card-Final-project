package com.example.customerregistration.repository;

import com.example.customerregistration.dao.individual.ContactsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsRepository extends JpaRepository<ContactsEntity ,Integer> {

    @Query("select a from ContactsEntity a where a.customer.id = :customerId")
    List<ContactsEntity> findContactCustomerId(Integer customerId);
}
