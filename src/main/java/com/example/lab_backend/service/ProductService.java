package com.example.lab_backend.service;

import com.example.lab_backend.entity.Product;
import com.example.lab_backend.repo.jpa.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    @Transactional
    public Product create(Product p){
        return repository.save(p);
    }

    @Transactional
    public Product update(Product p){
        return repository.save(p);
    }
    @Transactional
    public void delete(int id){
        repository.deleteById(id);
    }
    @Transactional
    public List<Product> viewAll(){
        return repository.findAll();
    }
    @Transactional
    public Product viewOne(int id){
        return repository.findById(id).orElse(null);
    }
}
