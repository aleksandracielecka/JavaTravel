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
    private Integer adultNumber;

    @Column(nullable = false)
    private Integer childNumber;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="hotel_id",nullable = false)
    private HotelEntity hotel;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (name = "trip_x_airportsFrom")
    private Set<AirportEntity> airportsFrom;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (name = "trip_x_airportsTo")
    private Set<AirportEntity> airportsTo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "trip")
    private Set<PriceEntity> prices;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "trip")
    private PurchaseEntity purchase;

}
