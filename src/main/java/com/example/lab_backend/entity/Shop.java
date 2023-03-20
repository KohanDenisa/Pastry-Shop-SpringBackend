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
public class Shop implements Comparable<Shop> {
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

    @OneToMany
    @ToString.Exclude
    List<Employee> employees;

    @ManyToMany
    @ToString.Exclude
    List<Product> products;

    public Shop(String name, int nrOfEmployees, String location, String type, int years) {
        this.name = name;
        this.nrOfEmployees = nrOfEmployees;
        this.location = location;
        this.type = type;
        this.years = years;
    }

    public void addEmployeeToShop(Employee e){
        employees.add(e);
    }

    public void addProductToShop(Product product){
        products.add(product);
    }

    @Override
    public int compareTo(Shop o) {
        Float avgPriceThis = 0.0F;
        for(Product product: products){
            avgPriceThis += product.getPrice();
        }
        avgPriceThis /= products.size();

        Float avgPriceShopO = 0.0F;
        for(Product product: o.products){
            avgPriceShopO += product.getPrice();
        }
        avgPriceShopO /= o.products.size();

        return avgPriceThis.compareTo(avgPriceShopO);
    }
}
