package com.example.javatravel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
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


