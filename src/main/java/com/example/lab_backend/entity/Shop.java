package com.example.lab_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String name;
    @Column
    Integer nrOfEmployees;
    @Column
    String location;
    @Column
    String type;
    @Column
    Integer years;

    public Shop(String name, int nrOfEmployees, String location, String type, int years) {
        this.name = name;
        this.nrOfEmployees = nrOfEmployees;
        this.location = location;
        this.type = type;
        this.years = years;
    }
}
