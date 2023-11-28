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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name ="airport_id_from",nullable = false)
    private Set<AirportEntity> airportsFrom;

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name ="airport_id_to",nullable = false)
//    private Set<AirportEntity> airportsTo;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name ="price_id",nullable = false)
    private Set<PriceEntity> prices;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name= "purchase_id")
    private PurchaseEntity purchase;

}
