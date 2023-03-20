package com.example.lab_backend.dto.shop;

import com.example.lab_backend.entity.Product;
import com.example.lab_backend.entity.Shop;
import lombok.Data;

@Data
public class ShopAvgPriceDto {
    private Integer id;
    private String name;
    private Integer nrOfEmployees;
    private String location;
    private String type;
    private Integer years;
    private Float averagePrice;

    public static ShopAvgPriceDto shopAvgPriceDtoFromShop(Shop shop){
        ShopAvgPriceDto dto = new ShopAvgPriceDto();
        dto.setId(shop.getId());
        dto.setName(shop.getName());
        dto.setNrOfEmployees(shop.getNrOfEmployees());
        dto.setLocation(shop.getLocation());
        dto.setType(shop.getType());
        dto.setYears(shop.getYears());

        Float avgPriceThis = 0.0F;
        for(Product product: shop.getProducts()){
            avgPriceThis += product.getPrice();
        }
        avgPriceThis /= shop.getProducts().size();

        dto.setAveragePrice(avgPriceThis);
        return dto;
    }
}
