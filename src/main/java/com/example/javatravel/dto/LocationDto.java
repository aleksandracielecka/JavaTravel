package com.example.javatravel.dto;

import com.example.javatravel.entity.LocationEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDto {
    private Long id;
    private LocationEntity.Continent continent;
    private String country;
    private String city;
    private String address;
}


