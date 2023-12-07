package com.example.javatravel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
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
