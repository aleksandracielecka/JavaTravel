package com.example.javatravel.dto;

import com.example.javatravel.entity.PriceEntity;
import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PurchaseDto {

    private Long id;
    private int adultNumber;
    private int childNumber;
    private Long tripId;
    private BigDecimal finalPrice;


}
