package com.example.javatravel.service;

import com.example.javatravel.dto.LocationDto;
import com.example.javatravel.dto.PurchaseDto;
import com.example.javatravel.entity.LocationEntity;
import com.example.javatravel.entity.PurchaseEntity;
import com.example.javatravel.repository.PurchaseRepository;
import com.example.javatravel.utils.mapper.LocationMapper;
import com.example.javatravel.utils.mapper.PurchaseMapper;
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

    public PurchaseDto createPurchase(PurchaseDto purchaseDto){
        PurchaseEntity purchaseEntity = PurchaseMapper.toPurchaseEntity(purchaseDto);
        PurchaseEntity savedPurchasedEntity = purchaseRepository.save(purchaseEntity);
        PurchaseDto dto = PurchaseMapper.toPurchaseDto(savedPurchasedEntity);
        return dto;
    }
}
