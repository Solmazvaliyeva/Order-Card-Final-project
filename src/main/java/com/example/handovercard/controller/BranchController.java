package com.example.handovercard.controller;

import com.example.handovercard.dao.HandedOverCardEntity;
import com.example.handovercard.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/from-branch-api")
@RequiredArgsConstructor
public class BranchController {

    private final CardService service;
    @PostMapping("{orderId}")
    public void handOverFromBranch(@PathVariable Integer orderId , @RequestBody HandedOverCardEntity entity){
        service.handOverCard(orderId ,entity);
    }
}
