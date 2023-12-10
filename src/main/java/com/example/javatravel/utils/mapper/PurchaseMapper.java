package com.example.javatravel.utils.mapper;

import com.example.javatravel.dto.PurchaseDto;
import com.example.javatravel.entity.PurchaseEntity;
import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.entity.UserEntity;

public class PurchaseMapper {

    public static PurchaseEntity toPurchaseEntity(PurchaseDto purchaseDto, UserEntity user,TripEntity trip){
        PurchaseEntity purchaseEntity = new PurchaseEntity();
        purchaseEntity.setId(purchaseDto.getId());
        purchaseEntity.setAdultNumber(purchaseDto.getAdultNumber());
        purchaseEntity.setChildNumber(purchaseDto.getChildNumber());
        purchaseEntity.setTrip(trip);
        purchaseEntity.setFinalPrice(purchaseDto.getFinalPrice());
        purchaseEntity.setUser(user);
        return purchaseEntity;
    }

    public static PurchaseDto toPurchaseDto(PurchaseEntity purchaseEntity){
        PurchaseDto purchaseDto = new PurchaseDto();
        purchaseDto.setId(purchaseEntity.getId());
        purchaseDto.setAdultNumber(purchaseEntity.getAdultNumber());
        purchaseDto.setChildNumber(purchaseEntity.getChildNumber());
//        purchaseDto.setTrip(purchaseEntity.getTrip());
        purchaseDto.setFinalPrice(purchaseEntity.getFinalPrice());
//        purchaseDto.setUser(purchaseEntity.getUser());
        return purchaseDto;
    }
}
