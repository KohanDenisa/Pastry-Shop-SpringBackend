package com.example.lab_backend.dto.employee;

import com.example.lab_backend.dto.shop.ShopDto;
import com.example.lab_backend.entity.Employee;
import lombok.Data;

@Data
public class EmployeeDetailsDto {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private ShopDto shopDto;

    public static EmployeeDetailsDto employeeDetailsDtoFromEmployee(Employee employee){
        EmployeeDetailsDto dto = new EmployeeDetailsDto();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setAge(employee.getAge());
        dto.setGender(employee.getGender());
        dto.setShopDto(ShopDto.shopDtoFromShop(employee.getShop()));
        return dto;
    }
}
