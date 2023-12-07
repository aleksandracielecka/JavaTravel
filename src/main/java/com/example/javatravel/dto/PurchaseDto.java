package com.example.javatravel.dto;

import com.example.javatravel.entity.StandardEntity;
import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseDto {

    private Long id;
    private int adultNumber;
    private int childNumber;
    private TripEntity trip;
    private StandardEntity standard;
    private UserEntity user;

}
