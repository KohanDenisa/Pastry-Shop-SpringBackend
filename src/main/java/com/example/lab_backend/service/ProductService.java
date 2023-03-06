package com.example.lab_backend.service;

import com.example.lab_backend.entity.Product;
import com.example.lab_backend.repo.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    @Transactional
    public Product create(Product p){
        return repository.create(p);
    }

    @Transactional
    public Product update(Product p){
        return repository.update(p);
    }
    @Transactional
    public void delete(int id){
        repository.delete(id);
    }
    @Transactional
    public List<Product> viewAll(){
        return repository.viewAll();
    }
    @Transactional
    public Product viewOne(int id){
        return repository.viewOne(id);
    }
}
