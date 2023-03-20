package com.example.lab_backend.dto.product;

import com.example.lab_backend.entity.Product;
import lombok.Data;

import java.util.Date;

@Data
public class ProductDto {
    private Integer id;
    private String name;
    private Float price;
    private Float weight;
    private String type;
    private Date manufacturingDate;

    public static ProductDto productDtoFromProduct(Product product){
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setWeight(product.getWeight());
        dto.setType(product.getType());
        dto.setManufacturingDate(product.getManufacturingDate());
        return dto;
    }
}
