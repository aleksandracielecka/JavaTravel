package com.example.javatravel.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class NewTripDto {


        private LocalDate startDate;
        private LocalDate endDate;
        private Integer maxAdultNumber;
        private Integer maxChildNumber;
        private Long hotelId;
        private String airportFromCode;
        private String airportToCode;
        private Long priceId;
}
