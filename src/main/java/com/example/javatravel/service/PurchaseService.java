package com.example.javatravel.service;

import com.example.javatravel.entity.PurchaseEntity;
import com.example.javatravel.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;


    public List<PurchaseEntity> getPurchaseList() {
        return purchaseRepository.findAll();
    }
}
