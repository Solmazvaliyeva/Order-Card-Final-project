package com.example.plasticcardsdep.dao;

import com.example.plasticcardsdep.dao.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardEntity ,Integer> {


}
