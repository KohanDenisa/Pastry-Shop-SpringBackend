package com.example.lab_backend.controller;

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
    public List<Shop> viewAll(){
        return service.viewAll();
    }

    @GetMapping(value = "/{id}")
    public Shop viewOne(@PathVariable("id") int id){
        return service.viewOne(id);
    }

    @GetMapping(value = "/nrOfEmployees={number}")
    public List<Shop> filterNumberOfClients(@PathVariable("number") int number){
        return service.filter(number);
    }

    @PostMapping()
    public Shop create(@RequestBody Shop p){
        return service.create(p);
    }

    @PutMapping()
    public Shop update(@RequestBody Shop p){
        return service.update(p);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id){
        service.delete(id);
    }
}
