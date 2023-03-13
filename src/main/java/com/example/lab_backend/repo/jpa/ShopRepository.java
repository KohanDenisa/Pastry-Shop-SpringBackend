package com.example.lab_backend.repo.jpa;

import com.example.lab_backend.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ShopRepository extends JpaRepository<Shop, Integer> {
}
