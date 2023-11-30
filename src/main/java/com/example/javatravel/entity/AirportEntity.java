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
    private String code;

    @Column(nullable = false)
    private String name;

    @OneToOne
    private LocationEntity location;



}
