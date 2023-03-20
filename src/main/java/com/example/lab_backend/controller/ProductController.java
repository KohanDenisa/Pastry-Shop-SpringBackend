package com.example.lab_backend.controller;

import com.example.lab_backend.dto.product.ProductDetailsDto;
import com.example.lab_backend.dto.product.ProductDto;
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
    public List<ProductDto> viewAll(){
        return service.viewAll();
    }

    @GetMapping(value = "/{id}")
    public ProductDetailsDto viewOne(@PathVariable("id") int id){
        return service.viewOne(id);
    }

    @PostMapping()
    public ProductDetailsDto create(@RequestBody Product p){
        return service.create(p);
    }

    @PutMapping()
    public ProductDetailsDto update(@RequestBody Product p){
        return service.update(p);
    }

    @PutMapping(value = "{id}/shopId={shopId}")
    public ProductDetailsDto addProductToShop(@PathVariable("id")int id, @PathVariable("shopId")int shopId){
        return service.addProductToShop(id, shopId);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id){
        service.delete(id);
    }
}
