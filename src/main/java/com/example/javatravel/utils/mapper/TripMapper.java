package com.example.javatravel.utils.mapper;


import com.example.javatravel.dto.TripDto;
import com.example.javatravel.entity.TripEntity;

public class TripMapper {

    public static TripEntity toTripEntity(TripDto tripDto){
        TripEntity tripEntity = new TripEntity();
        tripEntity.setId(tripDto.getId());
        tripEntity.setStartDate(tripDto.getStartDate());
        tripEntity.setEndDate(tripDto.getEndDate());
        tripEntity.setMaxAdultNumber(tripDto.getMaxAdultNumber());
        tripEntity.setMaxChildNumber(tripDto.getMaxChildNumber());
        tripEntity.setHotel(tripDto.getHotel());
        tripEntity.setAirportFrom(tripDto.getAirportFrom());
        tripEntity.setAirportTo(tripDto.getAirportTo());
        tripEntity.setPrice(tripDto.getPrice());
        return tripEntity;
    }

    public static TripDto toTripDto(TripEntity tripEntity){
        TripDto tripDto = new TripDto();
        tripDto.setId(tripEntity.getId());
        tripDto.setStartDate(tripEntity.getStartDate());
        tripDto.setEndDate(tripEntity.getEndDate());
        tripDto.setMaxAdultNumber(tripEntity.getMaxAdultNumber());
        tripDto.setMaxChildNumber(tripEntity.getMaxChildNumber());
        tripDto.setHotel(tripEntity.getHotel());
        tripDto.setAirportFrom(tripEntity.getAirportFrom());
        tripDto.setAirportTo(tripEntity.getAirportTo());
        tripDto.setPrice(tripEntity.getPrice());
        return tripDto;
    }
}
