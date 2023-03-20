package com.example.lab_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String name;
    @Column
    Float price;
    @Column
    Float weight;
    @Column
    String type;
    @Column
    Date manufacturingDate;

    @ManyToMany
    List<Shop> shops;

    public Product(String name, float price, float weight, String type, Date manufacturingDate) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.type = type;
        this.manufacturingDate = manufacturingDate;
    }

    public void addProductToShop(Shop shop){
        shops.add(shop);
    }
}
