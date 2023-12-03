package com.example.javatravel.dto;

import com.example.javatravel.entity.LocationEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelDto {
    private Long id;
    private String name;
    private String description;
    private int stars;
    private LocationEntity location;

}
