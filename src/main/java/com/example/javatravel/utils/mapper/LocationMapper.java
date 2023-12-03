package com.example.javatravel.utils.mapper;

import com.example.javatravel.dto.LocationDto;
import com.example.javatravel.entity.LocationEntity;

public class LocationMapper {

    public static LocationEntity toLocationEntity(LocationDto locationDto){
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setAddress(locationDto.getAddress());
        locationEntity.setCity(locationDto.getCity());
        locationEntity.setCountry(locationDto.getCountry());
        locationEntity.setContinent(locationDto.getContinent());
        if(locationDto.getId() != null){
            locationEntity.setId(locationDto.getId());
        }
        return locationEntity;
    }

    public static LocationDto toLocationDto(LocationEntity locationEntity){
        LocationDto locationDto = new LocationDto();
        locationDto.setAddress(locationEntity.getAddress());
        locationDto.setCity(locationEntity.getCity());
        locationDto.setCountry(locationEntity.getCountry());
        locationDto.setContinent(locationEntity.getContinent());
        locationDto.setId(locationEntity.getId());
        return locationDto;
    }
}
