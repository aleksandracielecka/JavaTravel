package com.example.javatravel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adult number",nullable = false)
    private int adultNumber;

    @Column(name = "child number",nullable = false)
    private int childNumber;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name= "trip_id")
    private TripEntity trip;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name= "standard_id")
    private StandardEntity standard;
}
