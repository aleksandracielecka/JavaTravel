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

    @OneToMany(fetch = FetchType.EAGER)
    private Set<AirportEntity> airports;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<HotelEntity> hotels;



    public enum Continent{
        EUROPE,
        ASIA,
        AFRICA,
        AUSTRALIA,
        NORTH_AMERICA,
        SOUTH_AMERICA,
        ANTARCTICA

    }



}


