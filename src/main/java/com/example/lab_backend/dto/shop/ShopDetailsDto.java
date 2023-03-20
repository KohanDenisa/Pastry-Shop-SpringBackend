package com.example.lab_backend.dto.shop;

import com.example.lab_backend.dto.employee.EmployeeDto;
import com.example.lab_backend.dto.product.ProductDto;
import com.example.lab_backend.entity.Shop;
import lombok.Data;

import java.util.List;

@Data
public class ShopDetailsDto {
    private Integer id;
    private String name;
    private Integer nrOfEmployees;
    private String location;
    private String type;
    private Integer years;
    private List<EmployeeDto> employeeDtos;

    private List<ProductDto> productDtos;

    public static ShopDetailsDto shopDtoFromShop(Shop shop){
        ShopDetailsDto dto = new ShopDetailsDto();
        dto.setId(shop.getId());
        dto.setName(shop.getName());
        dto.setNrOfEmployees(shop.getNrOfEmployees());
        dto.setLocation(shop.getLocation());
        dto.setType(shop.getType());
        dto.setYears(shop.getYears());
        dto.setEmployeeDtos(shop.getEmployees().stream().map(EmployeeDto::employeeDtoFromEmployee).toList());
        dto.setProductDtos(shop.getProducts().stream().map(ProductDto::productDtoFromProduct).toList());
        return dto;
    }
}
