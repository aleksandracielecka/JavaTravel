package com.example.javatravel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.repository.cdi.Eager;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adult_number", nullable = false)
    private int adultNumber;

    @Column(name = "child_number", nullable = false)
    private int childNumber;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private TripEntity trip;

    @Column
    private BigDecimal finalPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
