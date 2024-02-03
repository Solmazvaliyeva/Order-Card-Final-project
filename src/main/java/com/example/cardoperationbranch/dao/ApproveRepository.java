package com.example.cardoperationbranch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApproveRepository extends JpaRepository<CardApproveEntity ,Integer> {
}
