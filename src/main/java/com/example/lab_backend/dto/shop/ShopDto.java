package com.example.lab_backend.dto.shop;

import com.example.lab_backend.entity.Shop;
import lombok.Data;

@Data
public class ShopDto {
    private Integer id;
    private String name;
    private Integer nrOfEmployees;
    private String location;
    private String type;
    private Integer years;

    public static ShopDto shopDtoFromShop(Shop shop){
        ShopDto dto = new ShopDto();
        dto.setId(shop.getId());
        dto.setName(shop.getName());
        dto.setNrOfEmployees(shop.getNrOfEmployees());
        dto.setLocation(shop.getLocation());
        dto.setType(shop.getType());
        dto.setYears(shop.getYears());
        return dto;
    }
}
