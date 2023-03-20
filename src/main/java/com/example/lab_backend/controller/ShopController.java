package com.example.lab_backend.controller;

import com.example.lab_backend.dto.shop.ShopAvgPriceDto;
import com.example.lab_backend.dto.shop.ShopDetailsDto;
import com.example.lab_backend.dto.shop.ShopDto;
import com.example.lab_backend.entity.Shop;
import com.example.lab_backend.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/shops")
public class ShopController {
    private final ShopService service;

    public ShopController(ShopService service) {
        this.service = service;
    }

    @GetMapping()
    public List<ShopDto> viewAll(){
        return service.viewAll();
    }

    @GetMapping(value = "/{id}")
    public ShopDetailsDto viewOne(@PathVariable("id") int id){
        return service.viewOne(id);
    }

    @GetMapping(value = "/nrOfEmployees={number}")
    public List<ShopDto> filterNumberOfClients(@PathVariable("number") int number){
        return service.filter(number);
    }

    @GetMapping(value = "/sortByAvgPrice")
    public List<ShopAvgPriceDto> sortAvgPrice(){
        return service.sortAvgPrice();
    }

    @PostMapping()
    public ShopDetailsDto create(@RequestBody Shop p){
        return service.create(p);
    }

    @PutMapping()
    public ShopDetailsDto update(@RequestBody Shop p){
        return service.update(p);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id){
        service.delete(id);
    }
}
