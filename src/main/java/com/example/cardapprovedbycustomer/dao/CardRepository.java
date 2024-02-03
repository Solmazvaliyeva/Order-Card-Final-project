package com.example.cardapprovedbycustomer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CreatedCardEntity ,Integer> {
}
