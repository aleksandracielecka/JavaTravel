package com.example.javatravel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Continent continent;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String address;

//    @OneToMany(fetch = FetchType.EAGER)
//    private Set<AirportEntity> airports;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "location")
//    private Set<HotelEntity> hotels;



    public enum Continent{
        EUROPA,
        AZJA,
        AFRYKA,
        AUSTRALIA,
        AMERYKA_PÓŁNOCNA,
        AMERYKA_POLUDNIOWA,
        ANTARKTYDA

    }



}


