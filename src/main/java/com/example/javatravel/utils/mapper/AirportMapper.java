package com.example.javatravel.utils.mapper;

import com.example.javatravel.dto.AirportDto;
import com.example.javatravel.entity.AirportEntity;

public class AirportMapper {

    public static AirportEntity toAirportEntity(AirportDto airportDto){
        AirportEntity airportEntity = new AirportEntity();
        airportEntity.setCode(airportDto.getCode());
        airportEntity.setName(airportDto.getName());
        airportEntity.setLocation(airportDto.getLocation());
        return airportEntity;
    }

    public static AirportDto toAirportDto(AirportEntity airportEntity){
        AirportDto airportDto = new AirportDto();
        airportDto.setCode(airportEntity.getCode());
        airportDto.setName(airportEntity.getName());
        airportDto.setLocation(airportDto.getLocation());
        return airportDto;
    }
}
