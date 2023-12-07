package com.example.javatravel.utils.mapper;

import com.example.javatravel.dto.PurchaseDto;
import com.example.javatravel.entity.PurchaseEntity;
import com.example.javatravel.entity.TripEntity;

public class PurchaseMapper {

    public static PurchaseEntity toPurchaseEntity(PurchaseDto purchaseDto){
        PurchaseEntity purchaseEntity = new PurchaseEntity();
        purchaseEntity.setId(purchaseDto.getId());
        purchaseEntity.setAdultNumber(purchaseDto.getAdultNumber());
        purchaseEntity.setChildNumber(purchaseDto.getChildNumber());
        purchaseEntity.setTrip(purchaseDto.getTrip());
        purchaseEntity.setStandard(purchaseDto.getStandard());
        purchaseEntity.setUser(purchaseDto.getUser());
        return purchaseEntity;
    }

    public static PurchaseDto toPurchaseDto(PurchaseEntity purchaseEntity){
        PurchaseDto purchaseDto = new PurchaseDto();
        purchaseDto.setId(purchaseEntity.getId());
        purchaseDto.setAdultNumber(purchaseEntity.getAdultNumber());
        purchaseDto.setChildNumber(purchaseEntity.getChildNumber());
        purchaseDto.setTrip(purchaseEntity.getTrip());
        purchaseDto.setStandard(purchaseEntity.getStandard());
        purchaseDto.setUser(purchaseEntity.getUser());
        return purchaseDto;
    }
}
