package com.example.javatravel.dto;

import com.example.javatravel.entity.AirportEntity;
import com.example.javatravel.entity.HotelEntity;
import com.example.javatravel.entity.PriceEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TripDto {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer maxAdultNumber;
    private Integer maxChildNumber;
    private HotelEntity hotel;
    private AirportEntity airportFrom;
    private AirportEntity airportTo;
    private PriceEntity price;
}
