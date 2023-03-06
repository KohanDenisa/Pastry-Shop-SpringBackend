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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String name;
    @Column
    float price;
    @Column
    float weight;
    @Column
    String type;
    @Column
    Date manufacturingDate;

    public Product(String name, float price, float weight, String type, Date manufacturingDate) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.type = type;
        this.manufacturingDate = manufacturingDate;
    }
}
