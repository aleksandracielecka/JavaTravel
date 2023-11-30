package com.example.javatravel.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class AirportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id", nullable = false)
    private LocationEntity location;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "airportsFrom")
    private Set<TripEntity> tripsFromAirport;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "airportsTo")
    private Set<TripEntity> tripsToAirport;

}
