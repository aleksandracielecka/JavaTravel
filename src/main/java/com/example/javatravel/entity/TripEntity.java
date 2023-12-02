package com.example.javatravel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id")
    private Set<PriceEntity> prices;

//    @OneToOne(fetch = FetchType.EAGER, mappedBy = "trip")
//    private PurchaseEntity purchase;

}
