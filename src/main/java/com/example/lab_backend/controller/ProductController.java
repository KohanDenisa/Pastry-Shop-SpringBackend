package com.example.lab_backend.controller;

import com.example.lab_backend.entity.Product;
import com.example.lab_backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Product> viewAll(){
        return service.viewAll();
    }

    @GetMapping(value = "/{id}")
    public Product viewOne(@PathVariable("id") int id){
        return service.viewOne(id);
    }

    @PostMapping()
    public Product create(@RequestBody Product p){
        return service.create(p);
    }

    @PutMapping()
    public Product update(@RequestBody Product p){
        return service.update(p);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id){
        service.delete(id);
    }
}
