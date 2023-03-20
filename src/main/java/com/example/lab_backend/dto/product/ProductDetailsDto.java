package com.example.lab_backend.dto.product;

import com.example.lab_backend.dto.shop.ShopDto;
import com.example.lab_backend.entity.Product;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProductDetailsDto {
    private Integer id;
    private String name;
    private Float price;
    private Float weight;
    private String type;
    private Date manufacturingDate;
    private List<ShopDto> shopDtos;

    public static ProductDetailsDto productDetailsDtoFromProduct(Product product){
        ProductDetailsDto dto = new ProductDetailsDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setWeight(product.getWeight());
        dto.setType(product.getType());
        dto.setManufacturingDate(product.getManufacturingDate());
        dto.setShopDtos(product.getShops().stream().map(ShopDto::shopDtoFromShop).toList());
        return dto;
    }
}
