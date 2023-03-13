package com.example.lab_backend.service;

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
    public Employee create(Employee employee){
        return repository.save(employee);
    }

    @Transactional
    public Employee update(Employee employee){
        return repository.save(employee);
    }

    @Transactional
    public List<Employee> viewAll(){
        return repository.findAll();
    }

    @Transactional
    public Employee viewOne(int id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void delete(int id){
        repository.deleteById(id);
    }

    @Transactional
    public Employee addEmployeeToShop(int id_employee, int id_shop){
        Optional<Employee> employee = repository.findById(id_employee);
        Optional<Shop> shop = shopRepository.findById(id_shop);
        if(employee.isPresent() && shop.isPresent()){
            employee.get().setShop(shop.get());
            return employee.get();
        }
        else {
            return null;
        }
    }
}
