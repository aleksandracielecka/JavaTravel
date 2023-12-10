package com.example.javatravel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class TripEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="start_date",nullable = false)
    private LocalDate startDate;

    @Column(name="end_date",nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private Integer maxAdultNumber;

    @Column(nullable = false)
    private Integer maxChildNumber;

    @OneToOne
    private HotelEntity hotel;

    @OneToOne
    private AirportEntity airportFrom;

    @OneToOne
    private AirportEntity airportTo;

    @OneToOne
    private PriceEntity price;



}
