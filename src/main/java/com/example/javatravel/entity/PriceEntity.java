package com.example.javatravel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price_per_day" , nullable = false)
    private Long pricePerDay;

    @Column(name = "flight_price" , nullable = false)
    private Long flightPrice;

    @OneToOne
    private StandardEntity standard;



}
