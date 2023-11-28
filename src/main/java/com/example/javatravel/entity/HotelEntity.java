package com.example.javatravel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int stars;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id", nullable = false)
    private LocationEntity location;

    @OneToOne(fetch =FetchType.EAGER)
    private TripEntity trip;

}
