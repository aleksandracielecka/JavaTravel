package com.example.javatravel.dto;

import com.example.javatravel.entity.enums.StandardType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceDto {

    private Long id;
    private Long pricePerDay;
    private Long flightPrice;
    private StandardType standard;

}
