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
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String name;
    @Column
    int age;
    @Column
    String gender;

    @Column
    float salary;

    @ManyToOne
    @ToString.Exclude
    Shop shop;

    public Employee(String name, int age, String gender, float salary, Shop shop) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.shop = shop;
    }
}
