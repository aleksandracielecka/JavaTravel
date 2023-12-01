package com.example.javatravel.dto;

import com.example.javatravel.entity.LocationEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirportDto {

    private String code;
    private String name;
    private LocationEntity location;
}
