package com.example.javatravel.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    private HotelEntity hotel;

    @ManyToOne
    private AirportEntity airportFrom;

    @ManyToOne
    private AirportEntity airportTo;

    @ManyToOne
    private PriceEntity price;



}
