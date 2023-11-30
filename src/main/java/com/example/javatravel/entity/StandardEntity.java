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

    public enum StandardType {
        OB,
        BB,
        HB,
        FB,
        AI
    }
}
