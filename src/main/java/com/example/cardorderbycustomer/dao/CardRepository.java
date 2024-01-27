package com.example.cardorderbycustomer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<CardOrderEntity ,Integer> {

    @Query("select a from CardOrderEntity a where a.status ='INIT'")
    List<CardOrderEntity> getCardsInInitStatus();


    @Query("select a from CardOrderEntity a where a.status ='APPROVED'")
    List<CardOrderEntity> getApprovedCards();


    @Query("select a from CardOrderEntity a where a.status ='IN_PROGRESS'")
    List<CardOrderEntity> getEmbossedCards();


    @Query("select a from CardOrderEntity a where a.status ='DELIVERY'")
    List<CardOrderEntity> getReadyCards();
}
