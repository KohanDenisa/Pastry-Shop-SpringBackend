package com.example.lab_backend.dto.employee;

import com.example.lab_backend.entity.Employee;
import lombok.Data;

@Data
public class EmployeeDto {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;

    public static EmployeeDto employeeDtoFromEmployee(Employee employee){
        EmployeeDto dto = new EmployeeDto();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setAge(employee.getAge());
        dto.setGender(employee.getGender());
        return dto;
    }
}
