package com.example.lab_backend.controller;

import com.example.lab_backend.dto.employee.EmployeeDetailsDto;
import com.example.lab_backend.dto.employee.EmployeeDto;
import com.example.lab_backend.entity.Employee;
import com.example.lab_backend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping
    public List<EmployeeDto> viewAll(){
        return service.viewAll();
    }

    @GetMapping(value = "/{id}")
    public EmployeeDetailsDto viewOne(@PathVariable("id") Integer id){
        return service.viewOne(id);
    }

    @PostMapping()
    public EmployeeDetailsDto create(@RequestBody Employee employee){
        return service.create(employee);
    }

    @PutMapping()
    public EmployeeDetailsDto update(@RequestBody Employee employee){
        return service.update(employee);
    }

    @PutMapping(value = "/{id}/shopId={shopId}")
    public EmployeeDetailsDto addToShop(@PathVariable("id") int id, @PathVariable("shopId") int idShop){
        return service.addEmployeeToShop(id, idShop);
    }

    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable("id") int id){
        service.delete(id);
    }
}
