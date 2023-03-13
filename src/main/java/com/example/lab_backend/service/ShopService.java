package com.example.lab_backend.service;

import com.example.lab_backend.entity.Shop;
import com.example.lab_backend.repo.jpa.ShopRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {
    private final ShopRepository repository;

    public ShopService(ShopRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Shop create(Shop p){
        return repository.save(p);
    }

    @Transactional
    public Shop update(Shop p){
        return repository.save(p);
    }
    @Transactional
    public void delete(int id){
        repository.deleteById(id);
    }
    @Transactional
    public List<Shop> viewAll(){
        return repository.findAll();
    }
    @Transactional
    public Shop viewOne(int id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public List<Shop> filter(int v){
        return repository.findAll().stream().filter(shop -> shop.getNrOfEmployees() > v).toList();
    }


}
