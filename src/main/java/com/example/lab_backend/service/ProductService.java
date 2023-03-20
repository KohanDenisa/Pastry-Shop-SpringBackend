package com.example.lab_backend.service;

import com.example.lab_backend.dto.product.ProductDetailsDto;
import com.example.lab_backend.dto.product.ProductDto;
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
    public ProductDetailsDto create(Product p){
        return ProductDetailsDto.productDetailsDtoFromProduct(repository.save(p));
    }

    @Transactional
    public ProductDetailsDto update(Product p){
        return ProductDetailsDto.productDetailsDtoFromProduct(repository.save(p));
    }
    @Transactional
    public void delete(int id){
        repository.deleteById(id);
    }
    @Transactional
    public List<ProductDto> viewAll(){
        return repository.findAll().stream().map(ProductDto::productDtoFromProduct).toList();
    }
    @Transactional
    public ProductDetailsDto viewOne(int id){
        return repository.findById(id).map(ProductDetailsDto::productDetailsDtoFromProduct).orElse(null);
    }
}
