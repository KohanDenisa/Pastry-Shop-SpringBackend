package com.example.lab_backend.service;

import com.example.lab_backend.dto.product.ProductDetailsDto;
import com.example.lab_backend.dto.product.ProductDto;
import com.example.lab_backend.entity.Product;
import com.example.lab_backend.entity.Shop;
import com.example.lab_backend.repo.jpa.ProductRepository;
import com.example.lab_backend.repo.jpa.ShopRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final ShopRepository shopRepository;

    public ProductService(ProductRepository repository, ShopRepository shopRepository){
        this.repository = repository;
        this.shopRepository = shopRepository;
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

    public ProductDetailsDto addProductToShop(int id, int shopId) {
        Optional<Product> product = repository.findById(id);
        Optional<Shop> shop = shopRepository.findById(shopId);
        if(product.isPresent() && shop.isPresent()){
            product.get().addProductToShop(shop.get());
            shop.get().addProductToShop(product.get());
            repository.save(product.get());
            shopRepository.save(shop.get());
            return ProductDetailsDto.productDetailsDtoFromProduct(product.get());
        }
        return null;
    }
}
