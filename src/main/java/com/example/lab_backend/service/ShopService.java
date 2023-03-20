package com.example.lab_backend.service;

import com.example.lab_backend.dto.shop.ShopAvgPriceDto;
import com.example.lab_backend.dto.shop.ShopDetailsDto;
import com.example.lab_backend.dto.shop.ShopDto;
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
    public ShopDetailsDto create(Shop p){
        return ShopDetailsDto.shopDtoFromShop(repository.save(p));
    }

    @Transactional
    public ShopDetailsDto update(Shop p){
        return ShopDetailsDto.shopDtoFromShop(repository.save(p));
    }
    @Transactional
    public void delete(int id){
        repository.deleteById(id);
    }
    @Transactional
    public List<ShopDto> viewAll(){
        return repository.findAll().stream().map(ShopDto::shopDtoFromShop).toList();
    }
    @Transactional
    public ShopDetailsDto viewOne(int id){
        return repository.findById(id).map(ShopDetailsDto::shopDtoFromShop).orElse(null);
    }

    @Transactional
    public List<ShopDto> filter(int v){
        return repository.findAll().stream().filter(shop -> shop.getNrOfEmployees() > v).map(ShopDto::shopDtoFromShop).toList();
    }

    @Transactional
    public List<ShopAvgPriceDto> sortAvgPrice(){
        return repository.findAll().stream().sorted().map(ShopAvgPriceDto::shopAvgPriceDtoFromShop).toList();
    }
}
