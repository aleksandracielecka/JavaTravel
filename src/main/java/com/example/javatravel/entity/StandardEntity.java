package com.example.javatravel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class StandardEntity {
    @Id
    @Enumerated(EnumType.STRING)
    private StandardType standardType;

    @OneToOne(fetch = FetchType.EAGER)
    private TripEntity trip;

    @OneToOne(fetch = FetchType.EAGER)
    private PurchaseEntity purchase;

//czy możemy to tak zostawić??
    public enum StandardType {
        OB,
        BB,
        HB,
        FB,
        AI
    }
}
