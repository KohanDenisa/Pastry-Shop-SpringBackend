package com.example.lab_backend.service;

import com.example.lab_backend.dto.employee.EmployeeDetailsDto;
import com.example.lab_backend.dto.employee.EmployeeDto;
import com.example.lab_backend.entity.Employee;
import com.example.lab_backend.entity.Shop;
import com.example.lab_backend.repo.jpa.EmployeeRepository;
import com.example.lab_backend.repo.jpa.ShopRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;
    private final ShopRepository shopRepository;

    @Transactional
    public EmployeeDetailsDto create(Employee employee){
        return EmployeeDetailsDto.employeeDetailsDtoFromEmployee(repository.save(employee));
    }

    @Transactional
    public EmployeeDetailsDto update(Employee employee){
        return EmployeeDetailsDto.employeeDetailsDtoFromEmployee(repository.save(employee));
    }

    @Transactional
    public List<EmployeeDto> viewAll(){
        return repository.findAll().stream().map(EmployeeDto::employeeDtoFromEmployee).toList();
    }

    @Transactional
    public EmployeeDetailsDto viewOne(int id){
        return repository.findById(id).map(EmployeeDetailsDto::employeeDetailsDtoFromEmployee).orElse(null);
    }

    @Transactional
    public void delete(int id){
        repository.deleteById(id);
    }

    @Transactional
    public EmployeeDetailsDto addEmployeeToShop(int id_employee, int id_shop){
        Optional<Employee> employee = repository.findById(id_employee);
        Optional<Shop> shop = shopRepository.findById(id_shop);
        if(employee.isPresent() && shop.isPresent()) {
            employee.get().setShop(shop.get());
            shop.get().addEmployeeToShop(employee.get());
            return EmployeeDetailsDto.employeeDetailsDtoFromEmployee(employee.get());
        }
        else {
            return null;
        }
    }
}
