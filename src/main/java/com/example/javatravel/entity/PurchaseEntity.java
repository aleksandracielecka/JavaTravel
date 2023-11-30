package com.example.javatravel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.repository.cdi.Eager;

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
    @JoinColumn(name= "trip_id")
    private TripEntity trip;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "standard_id")
    private StandardEntity standard;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "user_id")
    private UserEntity user;
}
