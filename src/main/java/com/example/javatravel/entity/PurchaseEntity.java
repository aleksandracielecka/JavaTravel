package com.example.javatravel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.repository.cdi.Eager;

@Entity
@Getter
@Setter
@ToString
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adult number",nullable = false)
    private int adultNumber;

    @Column(name = "child number",nullable = false)
    private int childNumber;

    @OneToOne
    private TripEntity trip;

    @OneToOne
    private StandardEntity standard;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "user_id")
    private UserEntity user;
}
