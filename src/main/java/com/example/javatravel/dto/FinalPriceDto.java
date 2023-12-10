package com.example.javatravel.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FinalPriceDto {


    private Long selectedTripId;
    private int adultNumber;
    private int childNumber;
    private String standard;


}
