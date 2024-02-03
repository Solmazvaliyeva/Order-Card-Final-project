package com.example.handovercard.service;

import com.example.handovercard.dao.HandedOverCardEntity;
import com.example.handovercard.model.BranchDto;

public interface CardService {

    void handOverCard(Integer orderId , HandedOverCardEntity entity);
}
