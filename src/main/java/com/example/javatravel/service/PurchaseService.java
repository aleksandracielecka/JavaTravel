package com.example.javatravel.service;

import com.example.javatravel.dto.PurchaseDto;
import com.example.javatravel.entity.PurchaseEntity;
import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.entity.UserEntity;
import com.example.javatravel.repository.PurchaseRepository;
import com.example.javatravel.repository.TripRepository;
import com.example.javatravel.repository.UserRepository;
import com.example.javatravel.utils.mapper.PurchaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final UserRepository userRepository;
    private final TripRepository tripRepository;

    public List<PurchaseEntity> getPurchaseList() {
        return purchaseRepository.findAll();
    }

    public void createPurchase(PurchaseDto purchaseDto, String userEmail){
        TripEntity selectedTrip =tripRepository.findById(purchaseDto.getTripId()).orElseThrow();
        UserEntity user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("Nie ma usera"));
        PurchaseEntity purchaseEntity = PurchaseMapper.toPurchaseEntity(purchaseDto, user, selectedTrip);
        PurchaseEntity savedPurchasedEntity = purchaseRepository.save(purchaseEntity);
        selectedTrip.setMaxAdultNumber(selectedTrip.getMaxAdultNumber()-purchaseDto.getAdultNumber());
        selectedTrip.setMaxChildNumber(selectedTrip.getMaxChildNumber()-purchaseDto.getChildNumber());
        tripRepository.save(selectedTrip);
//        PurchaseDto dto = PurchaseMapper.toPurchaseDto(savedPurchasedEntity);
//        return dto;
    }
}
